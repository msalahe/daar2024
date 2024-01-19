package org.ms.java.models;



public class Document {
    
	private int id;
	private String title;
	private String author;
	private int reptition;
	
	
	
	
	public Document(int id, String title, String author, int reptition) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.reptition = reptition;
	}

	public Document() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getReptition() {
		return reptition;
	}

	public void setReptition(int reptition) {
		this.reptition = reptition;
	}
	
	

}
