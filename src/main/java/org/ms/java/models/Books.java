package org.ms.java.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@org.springframework.data.mongodb.core.mapping.Document(collection = "books")
public class Books {
	
	@Id
    private String _id;
	@Field
    private String title;
	@Field
    private String author;
	@Field
    private String releaseDate;
	@Field
    private String language;
	@Field
    private String content;

	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(String id, String title, String author, String releaseDate, String language, String content) {
		super();
		this._id = id;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
		this.language = language;
		this.content = content;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
