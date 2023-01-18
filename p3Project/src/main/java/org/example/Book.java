package org.example;

public class Book implements BookInformation {
    private String title;
    private String AuthorName;
    private int price;
    private int ISBN;

    public Book(String title, String AuthorName, int price, int ISBN) {
        this.title = title;
        this.AuthorName = AuthorName;
        this.price = price;
        this.ISBN = ISBN;
    }

        public String getTitle() {
            return title;
        }

        public String getAuthorName() {
            return AuthorName;
        }

    @Override
    public int getPrice() {
        return price;
    }

    public int getISBN() {
            return ISBN;
        }
}
