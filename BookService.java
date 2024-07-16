import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final GutendexService gutendexService;

    @Autowired
    public BookService(BookRepository bookRepository, GutendexService gutendexService) {
        this.bookRepository = bookRepository;
        this.gutendexService = gutendexService;
    }

    // Método para buscar un libro por título en la base de datos local o en Gutendex
    public Book findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        if (book == null) {
            // Si el libro no está en la base de datos local, buscar en Gutendex
            book = gutendexService.searchBookByTitle(title);
            if (book != null) {
                // Guardar el libro encontrado en la base de datos local
                bookRepository.save(book);
            }
        }
        return book;
    }

    // Puedes agregar más métodos de servicio según sea necesario
}
