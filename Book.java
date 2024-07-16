import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Método para buscar libros por título
    Book findByTitle(String title);

    // Puedes agregar más consultas personalizadas aquí según sea necesario
}
