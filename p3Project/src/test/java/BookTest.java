import org.example.Author;
import org.example.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    public void testBookProperties() {
        Book book = new Book("The Great Gatsby", "John Smith", 15 , 1234567890);

        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("1234567890123", book.getISBN());
    }
}
