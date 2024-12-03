package example.Service;

import example.DAO.ReceiptItemRepo;
import example.DAO.ReceiptRepo;
import example.Entities.receipt;
import example.Entities.receiptItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class receiptItemServiceImpl implements receiptItemService {
    @Autowired
    ReceiptItemRepo receiptItemRepo;
    @Override
    public receiptItem create(receiptItem receiptItem) {
        return receiptItemRepo.save(receiptItem);
    }
}
