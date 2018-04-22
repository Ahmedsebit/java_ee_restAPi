package com.pluralsight.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;


@Entity
public class Book{

    @Id @GeneratedValue
    private Long id;
    
    @Column (length = 200)
    @NotNull
    @Size(min=1,max=200)
    private String title;

    @Column (length = 10000)
    @Size(min=1,max=10000)
    private String description;

    @Column (name = "unit_cost")
    private Float unitCost;

    @Column (length = 50)
    @NotNull
    @Size(min=1,max=50)
    private String isbn;

    @Column (name = "publication_date")
    @Temporal(TemporalType.DATE)
    @Past
    private Date publicationDate;

    @Column (name = "no_of_pages")
    private Integer noOfPages;

    @Column (name = "image_url")
    private String imageUrl;

    private Language language;

    public Book() {
		
	}

	public Book( String title, String description, Float unitCost, String isbn, Date publicationDate,
			Integer nbOfPages, String imageUrl, Language language) {
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.noOfPages = nbOfPages;
		this.imageUrl = imageUrl;
		this.language = language;
    }
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Float getUnitCost(){
        return unitCost;
    }

    public void setUnitCost(Float unitCost){
        this.unitCost = unitCost;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public Date getPublicationDate(){
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate){
        this.publicationDate = publicationDate;
    }

    public Integer getNoOfPages(){
        return noOfPages;
    }

    public void setNoOfPages(Integer noOfPages){
        this.noOfPages = noOfPages;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public Language getLanguage(){
        return language;
    }

    public void setLanguage(Language language){
        this.language = language;
    }

    @Override
    public String toString(){
        return "Book{" +
        "id" + id +
        "title" + title +
        "description" + description +
        "unitCost" + unitCost +
        "isbn" + isbn +
        "publicationDate" + publicationDate +
        "noOfPages" + noOfPages +
        "imageUrl" + imageUrl +
        "language" + language;
    }

}