package ru.ave.libraryCatalog;

import java.util.Objects;

public class Newspaper extends Publication{

    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType() {
        return "Газета";
    }

    @Override
    public void printDetails() {
        System.out.printf("%s: название - %s, автор - %s, год выпуска - %d, день публикации - %s"
                , getType(), getTitle(), getAuthor(), getYear(), getPublicationDay());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                super.toString() +
                ", publicationDay='" + publicationDay + '\'' +
                '}';
    }
}
