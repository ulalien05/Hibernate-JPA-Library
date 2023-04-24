package ru.volkova.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @NotEmpty(message="Укажите название книги")
    @Size(min=2, max=100, message = "Название книги должно быть от 2 до 100 символов длиной")
    @Column(name="title")
    private String title;
    @NotEmpty(message = "Укажите автора книги")
    @Size(min=2, max=100, message = "Имя автора должно быть от 2 до 100 символов длиной")
    @Column(name="author")
    private String author;
    @Min(value=1500, message = "Год издания не может быть ранее 1500 года")
    @Column(name="year")
    private int year;

    @ManyToOne
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name="taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;

    public Book(){

    }

    public Book( String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }
}
