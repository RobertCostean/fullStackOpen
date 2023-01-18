import org.example.Author;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthorTest {
    @Test
    public void testAuthorProperties() {
        Author author = new Author("John Smith", "johnsmith@email.com","Male");

        assertEquals("John Smith", author.getName());
        assertEquals("johnsmith@email.com", author.getEmail());
    }
}
