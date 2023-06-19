package items;

public class Book extends Item{
    private String author;

    public Book(String title, Double price, Boolean isBogof, String author) {
        super(title, price, isBogof);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
