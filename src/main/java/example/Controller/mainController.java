package example.Controller;

import example.DAO.CustomerRepo;
import example.DAO.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    productRepo productRepo;
    @GetMapping("/index")
    public String ProductList(Model model) {
        model.addAttribute("product", productRepo.findAll());
        return "index";
    }
}
