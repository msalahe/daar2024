package org.ms.java.models;



public class Document {
	
	
	private String title;
	private String author;
	private String releaseDate;
	private String language;
    private String content;
    private double rankingScore;
	private int occur;

    
    public Document(String title, String author, 
			 int occur,double rankig) {
		super();
		this.title = title;
		this.author = author;
		this.occur = occur;
		this.rankingScore = rankig;

	}
    public Document(String title, String author, String releaseDate, String language,
			 int occur,String content) {
		super();
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
		this.language = language;
		this.occur = occur;
		this.content = content;
	}

	public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public double getRankingScore() {
        return rankingScore;
    }

    public void setRankingScore(double rankingScore) {
        this.rankingScore = rankingScore;
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

	public int getOccur() {
		return occur;
	}

	public void setOccur(int occur) {
		this.occur = occur;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
    

    // Autres méthodes ou propriétés en fonction des besoins
}

