package springapp.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class Person {
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min=2, max=50, message = "Name should be between 2 and 50")
    private String name;

    @Min(value = 1940, message = "Enter correct year: ")
    private int year;

    public Person() {}

    public Person(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
