package org.recipesearch.hibernatesearch.po;

import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.lambico.po.hibernate.EntityBase;

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
public class Recipe extends SearchableEntityBase {

	private transient org.recipesearch.core.po.Recipe recipe;
	private Person cook;
	
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

}
