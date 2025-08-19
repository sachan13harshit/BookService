import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetReader {
    public List<Book> readBooksFromCSV(String filename) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 7) {
                    String title = data[0].trim();
                    String author = data[1].trim();
                    double rating = Double.parseDouble(data[2].trim());
                    int reviews = Integer.parseInt(data[3].trim());
                    double price = Double.parseDouble(data[4].trim());
                    int year = Integer.parseInt(data[5].trim());
                    String genre = data[6].trim();
                    books.add(new Book(title, author, rating, reviews, price, year, genre));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}