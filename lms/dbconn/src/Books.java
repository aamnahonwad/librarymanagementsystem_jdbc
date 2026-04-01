public class Books {

    int book_id;
    String title;
    String author;
    String genre;
    double price;
    int available_copies;

   
    public Books(int book_id, String title, String author, String genre, double price, int available_copies) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.available_copies = available_copies;
    }
}