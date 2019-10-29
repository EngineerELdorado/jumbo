package denis.jumbo.Jumbo.repositories;

import denis.jumbo.Jumbo.entities.Category;
import denis.jumbo.Jumbo.entities.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
