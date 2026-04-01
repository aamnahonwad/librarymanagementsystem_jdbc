import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BooksDAO dao = new BooksDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Get Book by ID");
            System.out.println("4. Delete Book");
            System.out.println("5. Update Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Copies: ");
                    int copies = sc.nextInt();

                    dao.addBook(new Books(id, title, author, genre, price, copies));
                    break;

                case 2:
                    dao.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    dao.getBookById(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    dao.deleteBook(sc.nextInt());
                    break;

                case 5:
                    System.out.println("1. Title 2. Price 3. Copies");
                    int ch = sc.nextInt();
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    if (ch == 1) {
                        System.out.print("New Title: ");
                        dao.updateTitle(uid, sc.nextLine());
                    } else if (ch == 2) {
                        System.out.print("New Price: ");
                        dao.updatePrice(uid, sc.nextDouble());
                    } else if (ch == 3) {
                        System.out.print("New Copies: ");
                        dao.updateCopies(uid, sc.nextInt());
                    }
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    dao.issueBook(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter ID: ");
                    dao.returnBook(sc.nextInt());
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
