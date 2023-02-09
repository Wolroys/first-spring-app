package springapp.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;



public class Book {
    private int id;

    @NotEmpty(message = "Need to enter the title")
    private String title;
    @Max(value=2023,message = "Enter correct year")
    @Min(value = 0, message = "Enter correct year")
    private int year;
    @NotEmpty(message = "The book has author")
    private String author;

    public Book(){}

    public Book(int id, String title, int year, String author) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
