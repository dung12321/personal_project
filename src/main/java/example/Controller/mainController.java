package example.Controller;


import example.DAO.productRepo;
import example.DAO.userPRepo;
import example.Entities.*;
import example.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class mainController {
//    @Autowired
//    customerService customerService;
    @Autowired
    productService productService;
    @Autowired
    userPService userPService;
    @Autowired
    receiptService receiptService;

    @Autowired
    receiptItemService receiptItemService;

    @GetMapping("/Login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new userP());
        return "login";
    }

    @PostMapping("/Login")
    public String processLoginForm(@ModelAttribute("user") userP user, Model model, HttpSession session) {
        userP checkUserP = userPService.findByAccount(user.getAccount());
        if (checkUserP != null && user.getPassword().equals(checkUserP.getPassword())) {
            session.setAttribute("user", checkUserP);
            model.addAttribute("user", checkUserP);
            return "redirect:/index";
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/index")
    public String ProductList(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "index";
    }
    @GetMapping("/cart")
    public String showCart(Model model, HttpSession session) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        double total = totalPrice(cartItems);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", total);
        model.addAttribute("cartSize", cartItems.size());
        return "cart";
    }
    @GetMapping(value = "add/{id}.html")
    public String addProduct(ModelMap mm, HttpSession session, @PathVariable("id") int id) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        product product = productService.findById(id);
        if (product != null) {
            if (cartItems.containsKey(product.getId())) {
                Cart cart = cartItems.get(product.getId());
                cart.setProduct(product);
                cart.setQuantity(cart.getQuantity() + 1);
            } else {
                Cart cart = new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
                cartItems.put(id, cart);
            }
        }
        session.setAttribute("cart", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("Num", cartItems.size());
        return "redirect:/cart";
    }

    @PostMapping(value = "update/{id}.html")
    public String updateProduct(ModelMap mm, HttpSession session, @PathVariable("id") int id, @RequestParam("quantity")int quantity) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(id)) {
            Cart cart = cartItems.get(id);
            cart.setQuantity(quantity);
            cartItems.put(id, cart);
        }
        session.setAttribute("cart", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("Num", cartItems.size());
        return "redirect:/cart";
    }
    @GetMapping(value = "remove/{id}.html")
    public String removeProduct(ModelMap mm, HttpSession session, @PathVariable("id") int id) {
       HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cart");
       if (cartItems == null) {
           cartItems = new HashMap<>();
       }
       if (cartItems.containsKey(id)) {

           cartItems.remove(id);

       }
       session.setAttribute("cart", cartItems);
       session.setAttribute("myCartTotal", totalPrice(cartItems));
       session.setAttribute("Num", cartItems.size());
       return "redirect:/cart";
    }
    @PostMapping(value = "Pay.html")
    public String pay(ModelMap mm, HttpSession session, @ModelAttribute("receipt") receipt receipt) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        receipt.setDate(new Timestamp(new Date().getTime()));
        receipt.setStatus(true);
        receiptService.create(receipt);
        for(Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            receiptItem receiptItem = new receiptItem();
            receiptItem.setReceipt(receipt);
            receiptItem.setProduct(entry.getValue().getProduct());
            receiptItem.setReceiptItemPrice(entry.getValue().getProduct().getPrice());
            receiptItem.setReceiptItemQuantity(entry.getValue().getQuantity());
            receiptItem.setReceiptItemStatus(true);
            receiptItemService.create(receiptItem);
        }
        cartItems = new HashMap<>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
        return "pages/success";
    }

    private double totalPrice(HashMap<Integer, Cart> cartItems) {
        int total = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()){
            total += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
        }
        return total;
    }
}

