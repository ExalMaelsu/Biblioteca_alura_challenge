import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books/";

    private final RestTemplate restTemplate;

    public GutendexService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para buscar libros por título en Gutendex API
    public Book searchBookByTitle(String title) {
        String url = GUTENDEX_API_URL + "?search=" + title;
        return restTemplate.getForObject(url, Book.class);
    }
}
