package org.recipesearch.hibernatesearch.util;

import java.math.BigDecimal;

public class Padder {
	
	
	private final double round;
	private final int pad;

	public Padder(int pad, double round){
		this.pad = pad;
		this.round = round;
	}
	
	public String pad(long number) {
		String rawLong = Long.toString(number);
		if (rawLong.length() > pad) 
			throw new IllegalArgumentException( "Try to pad on a number too big" );
		StringBuilder paddedLong = new StringBuilder( );
		for ( int padIndex = rawLong.length() ; padIndex < pad ; padIndex++ ) {
			paddedLong.append('0');
		}
		return paddedLong.append( rawLong ).toString();
	}
	
	public String pad(BigDecimal number) {
		return pad(round(number));
	}
	
	private long round(BigDecimal price) {
		double rounded = Math.floor( price.doubleValue() / round ) * round;
		if ( rounded != price.doubleValue() ) rounded+= round; //we round up
		return (long) rounded;
	}

}
