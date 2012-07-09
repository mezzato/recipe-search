package org.recipesearch.hibernatesearch.po;

import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

	private int numPages = 0;
    private String author = null;
    private String title = null;
    private Person cook = null;
    private String text = null;
   

    @Field
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    @Field
    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
     *
     */
    public Recipe() {
        // TODO Auto-generated constructor stub
    }

    public Recipe(String author, String title) {
        this(author, title, null, 0);
    }
    
    public Recipe(String author, String title, String text) {
        this(author, title, text, 0);
    }

    public Recipe(String author, String title, String text, int numPages) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.numPages = numPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    public Person getCook() {
        return cook;
    }

    public void setCook(Person cook) {
        this.cook = cook;
    }

    @Override
    public String toString() {
        return "Recipe{" + "numPages=" + numPages + " ; author=" + author + " ; title=" + title + " ; cook=" +
                cook + '}';
    }

}
