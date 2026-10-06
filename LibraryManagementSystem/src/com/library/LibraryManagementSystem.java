
package com.library;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println();
            System.out.println("=================================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println();
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                addBook();
                break;

            case 2:
                removeBook();
                break;

            case 3:
                searchBook();
                break;

            case 4:
                viewBooks();
                break;

            case 5:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    public static void addBook() {

        System.out.print("How many books do you want to add: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println();
            System.out.println("Enter details for Book " + i);

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            Book b = new Book(id, title, author);
            books.add(b);

            System.out.println("Book added successfully!");
        }
    }

    public static void removeBook() {

        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.bookId == id) {
                books.remove(b);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public static void searchBook() {

        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.bookId == id) {
                System.out.println("Book Found!");
                System.out.println("Book ID: " + b.bookId);
                System.out.println("Title: " + b.title);
                System.out.println("Author: " + b.author);
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public static void viewBooks() {

        if (books.size() == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println();
        System.out.println("========== ALL BOOKS ==========");

        for (Book b : books) {

            System.out.println("-------------------------");
            System.out.println("Book ID: " + b.bookId);
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);
        }

        System.out.println("-------------------------");
        System.out.println("Total Books: " + books.size());
    }
}

