import org.example.BookStore;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookStoreTest {
    @Test
    public void testBookStoreCreation() {
        BookStore bookstore = new BookStore("New York", "Barnes and Noble");
        assertNotNull(bookstore);
    }

    @Test
    public void testCity() {
        BookStore bookstore = new BookStore("New York", "Barnes and Noble");
        assertEquals("New York", bookstore.getCity());
    }

    @Test
    public void testName() {
        BookStore bookstore = new BookStore("New York", "Barnes and Noble");
        assertEquals("Barnes and Noble", bookstore.getName());
    }
}
