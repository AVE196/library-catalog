package ru.ave.libraryCatalog;

import java.util.Objects;

public class Book extends Publication{

    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public void printDetails() {
        System.out.printf("%s: название - %s, автор - %s, год выпуска - %d, ISBN - %s"
                , getType(), getTitle(), getAuthor(), getYear(), getISBN());
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                '}';
    }
}
