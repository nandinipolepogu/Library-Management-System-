import java.util.*;

class Book {

    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Title: " + title + " | Author: " + author);
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(title, author));

        System.out.println("Book Added Successfully!\n");
    }

    public static void displayBooks() {

        if(books.isEmpty()) {
            System.out.println("No books available.\n");
            return;
        }

        System.out.println("\n--- Library Books ---");

        for(Book b : books) {
            b.display();
        }

        System.out.println();
    }

    public static void searchBook() {

        System.out.print("Enter title to search: ");
        String title = sc.nextLine();

        for(Book b : books) {

            if(b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                b.display();
                return;
            }
        }

        System.out.println("Book not found.\n");
    }

    public static void removeBook() {

        System.out.print("Enter title to remove: ");
        String title = sc.nextLine();

        Iterator<Book> it = books.iterator();

        while(it.hasNext()) {

            Book b = it.next();

            if(b.title.equalsIgnoreCase(title)) {
                it.remove();
                System.out.println("Book removed successfully.\n");
                return;
            }
        }

        System.out.println("Book not found.\n");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    removeBook();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!\n");
            }

        } while(choice != 5);
    }
}