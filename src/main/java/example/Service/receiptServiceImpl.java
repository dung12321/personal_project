package example.Service;

import example.DAO.ReceiptRepo;
import example.DAO.userPRepo;
import example.Entities.receipt;
import example.Entities.userP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class receiptServiceImpl implements receiptService {
    @Autowired
    ReceiptRepo receiptRepo;
    @Override
    public receipt create(receipt receipt) {
        return receiptRepo.save(receipt);
    }
}
