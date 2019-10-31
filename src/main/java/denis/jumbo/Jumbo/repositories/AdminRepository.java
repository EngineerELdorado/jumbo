package denis.jumbo.Jumbo.repositories;
import denis.jumbo.Jumbo.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByUsername(String username);
}
