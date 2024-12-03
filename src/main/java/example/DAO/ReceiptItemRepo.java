package example.DAO;

import example.Entities.receiptItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptItemRepo extends JpaRepository<receiptItem, Integer> {
}

