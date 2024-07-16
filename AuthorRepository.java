import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Método para encontrar autores vivos en un año determinado
    List<Author> findByYearOfBirthLessThanEqual(int year);

    // Puedes agregar más consultas personalizadas aquí según sea necesario
}
