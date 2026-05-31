package ru.ave.libraryCatalog;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Publication> publications = new ArrayList<>();

    public void addPublication(Publication pub) {
        // добавить публикацию
        publications.add(pub);
    }

    public void searchPublicationByAuthor(String author) {
        // поиск по автору
        for (int i = 0; i < publications.size(); i++) {
            if (publications.get(i).getAuthor().equals(author)) {
                System.out.println(publications.get(i));
                break;
            } else if (i == publications.size() - 1) {
                System.out.printf("Публикации автора \"%s\" не найдены\n", author);
            }
        }
    }

    public void listPublication() {
        // список всех публикаций
        if (publications.isEmpty()) {
            System.out.println("Библиотека пуста");
        } else {
            for (Publication pub : publications) {
                pub.printDetails();
            }
        }
    }

}
