import java.util.List;
import java.util.Map;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        DatasetReader reader = new DatasetReader();
        List<Book> books = reader.readBooksFromCSV("data.csv");
        String author = "George Orwell";
        double rating = 4.7;
        BookService bookService = new BookService(books);
        int BooksCountsByAuthorName = bookService.getBooksCountByAuthor(author);
        List<String> allAuthors = bookService.getAllAuthors();
        List<String> titles = bookService.getBookTitlesByAuthor(author);
        List<Book> booksWithRating = bookService.getBooksByRating(rating);
        Map<String, Double> pricedBooks = bookService.getBookPricesByAuthor(author);
    }
}