package ru.ave.libraryCatalog;

import java.util.Scanner;

public class Main {

    static void main() {

        String menu = """
                Введите номер выбранной опции:
                1. Добавить новую публикацию
                2. Вывести список всех публикаций
                3. Поиск публикации по автору
                4. Вывести общее количество публикаций
                0. Выход
                """;

        String errorMessage = "Некорректный ввод";

        boolean isExit = false;

        Scanner scan = new Scanner(System.in);

        Library lib = new Library();

        do {
            System.out.println(menu);
            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Выберите тип публикации: 1 – Book, 2 – Magazine, 3 – Newspaper");
                    String typePublication = scan.nextLine();
                    if (typePublication.equals("1") || typePublication.equals("2") || typePublication.equals("3")) {
                        System.out.print("Введите название: ");
                        String title = scan.nextLine();
                        System.out.print("Введите автора: ");
                        String author = scan.nextLine();
                        System.out.print("Введите год: ");
                        int year = scan.nextInt();
                        switch (typePublication) {
                            case "1":
                                System.out.print("Введите ISBN: ");
                                lib.addPublication(new Book(title, author, year, scan.nextLine()));
                                break;
                            case "2":
                                System.out.print("Введите issueNumber: ");
                                lib.addPublication(new Magazine(title, author, year, scan.nextInt()));
                                break;
                            case "3":
                                System.out.print("Введите день публикации: ");
                                lib.addPublication(new Newspaper(title, author, year, scan.nextLine()));
                                break;
                        }
                    } else {
                        System.out.println(errorMessage);
                        break;
                    }
                    break;
                case "2":
                    lib.listPublication();
                    break;
                case "3":
                    System.out.println("Введите имя автора для поиска:");
                    lib.searchPublicationByAuthor(scan.nextLine());
                    break;
                case "4":
                    System.out.println("Всего публикаций: " + Publication.getPublicationCount());
                    break;
                case "0":
                    isExit = true;
                    break;
                default:
                    System.out.println(errorMessage);
                    break;
            }



        } while (!isExit);

    }

}
