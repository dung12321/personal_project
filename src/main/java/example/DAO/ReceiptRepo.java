package example.DAO;


import example.Entities.receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepo extends JpaRepository<receipt, Integer> {

}
