import java.util.*;

public class BookService {
    private List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public int getBooksCountByAuthor(String authorName) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }

    public List<String> getAllAuthors() {
        List<String> authors = new ArrayList<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    public List<String> getBookTitlesByAuthor(String authorName) {
        List<String> titles = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                titles.add(book.getTitle());
            }
        }
        return titles;
    }

    public List<Book> getBooksByRating(double rating) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getUserRating() == rating) {
                result.add(book);
            }
        }
        return result;
    }

    public Map<String, Double> getBookPricesByAuthor(String authorName) {
        Map<String, Double> titlePriceMap = new HashMap<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                titlePriceMap.put(book.getTitle(), book.getPrice());
            }
        }
        return titlePriceMap;
    }
}