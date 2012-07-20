package org.recipesearch.hibernatesearch.po;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.recipesearch.hibernatesearch.util.ParameterizedPaddedRoundedPriceBridge;


@javax.persistence.Entity()
@NamedQueries(
value = {
    @NamedQuery(name = "Recipe.allRecipesByCook",
    query =
    "from Recipe r where upper(r.cook.firstName) = upper(?) and upper(r.cook.lastName) = upper(?)"), 
    @NamedQuery(name = "Recipe.allRecipesByExactText",
    query =
    "from Recipe r where r.text like '%' || ? || '%'")
	})
@Indexed
/*
@org.hibernate.search.annotations.FullTextFilterDefs( {
	@org.hibernate.search.annotations.FullTextFilterDef(name="maximumprice", impl=org.recipesearch.hibernatesearch.util.MaximumPriceFilterFactory.class) 
} )
*/
public class Recipe extends SearchableEntityBase {

	private transient org.recipesearch.core.po.Recipe recipe;
	private Person cook;
	private BigDecimal price;
	
	@Transient
	public org.recipesearch.core.po.Recipe getRecipeCore() {
		return this.recipe;
	}
   

    @Field
    public String getTitle() {
        return this.recipe.getTitle();
    }

    public void setTitle(String title) {
    	this.recipe.setTitle(title);
    }
    
    @Field
    public String getText() {
		return this.recipe.getText();
	}

	public void setText(String text) {
		this.recipe.setText(text);
	}

	/**
     *
     */
    public Recipe() {
    	this.recipe = new org.recipesearch.core.po.Recipe();
    }

    public Recipe(String author, String title) {
        this(author, title, null, 0);
    }
    
    public Recipe(String author, String title, String text) {
        this(author, title, text, 0);
    }

    public Recipe(String author, String title, String text, int numPages) {
    	this.recipe = new org.recipesearch.core.po.Recipe(author, title, text, numPages);
    }

    public String getAuthor() {
        return this.recipe.getAuthor();
    }

    public void setAuthor(String author) {
    	this.recipe.setAuthor(author);
    }

    public int getNumPages() {
        return this.recipe.getNumPages();
    }

    public void setNumPages(int numPages) {
    	this.recipe.setNumPages(numPages);
    }

    

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    public Person getCook() {
        return this.cook;
    }

    public void setCook(Person cook) {
        this.cook = cook;
    }

    @Override
    public String toString() {
        return this.recipe.toString();
    }

    @Column(name="price") @NotNull 
    @Digits(fraction = 2, integer = 10) 
    @Field(index=Index.UN_TOKENIZED, name="price") 
    @FieldBridge( 
    impl=ParameterizedPaddedRoundedPriceBridge.class,
    params= { @Parameter(name="pad", value="10"),
    @Parameter(name="round", value="1") }
    ) 
	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
    

}
