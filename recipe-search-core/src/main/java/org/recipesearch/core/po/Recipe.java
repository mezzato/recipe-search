package org.recipesearch.core.po;


public class Recipe {

	private int numPages = 0;
    private String author = null;
    private String title = null;
    private Person cook = null;
    private String text = null;
   

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
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

    
    public Person getCook() {
        return cook;
    }

    public void setCook(Person cook) {
        this.cook = cook;
    }

    public String toString() {
        return "Recipe{" + "numPages=" + numPages + " ; author=" + author + " ; title=" + title + " ; cook=" +
                cook + '}';
    }

}
