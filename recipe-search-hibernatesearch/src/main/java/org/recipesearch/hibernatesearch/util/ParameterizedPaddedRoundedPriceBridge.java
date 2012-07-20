package org.recipesearch.hibernatesearch.util;

import java.math.BigDecimal;
import java.util.Map;

import org.hibernate.search.bridge.ParameterizedBridge;
import org.hibernate.search.bridge.StringBridge;

/**
 * Round a price by range of <code>round</code>, going to the upper boundaries
 * pad the result with up to <code>pad</code> non-significant 0
 * Accept double and Double 
 */
public class ParameterizedPaddedRoundedPriceBridge implements StringBridge, ParameterizedBridge {
	private int pad = 6; //price of 1,000,000 online seems like a decent default target
	private double round = 1d; //by default round to the next non decimal amount
	private Padder padder;
	
	@Override
	public void setParameterValues(Map parameters) {
		if ( parameters.containsKey("pad") ) {
			pad = Integer.parseInt( (String) parameters.get("pad") );
		}
		
		if ( parameters.containsKey("round") ) {
			round = Double.parseDouble( (String) parameters.get("round") );
		}
		padder = new Padder(pad, round);
	}

	@Override
	public String objectToString(Object value) {
		if ( value == null ) return null;
		if (value instanceof BigDecimal) {
			long price = round( (BigDecimal) value );
			return this.padder.pad(price);
		}
		else {
			throw new IllegalArgumentException(ParameterizedPaddedRoundedPriceBridge.class 
					+ " used one a non BigDecimal type: " + value.getClass() );
		}
		
		
	}

	private long round(BigDecimal price) {
		double rounded = Math.floor( price.doubleValue() / round ) * round;
		if ( rounded != price.doubleValue() ) rounded+= round; //we round up
		return (long) rounded;
	}

}
