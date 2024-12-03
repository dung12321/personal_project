package example.Entities;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private product product;
    private int quantity;

    public Cart(int id, example.Entities.product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public example.Entities.product getProduct() {
        return product;
    }

    public void setProduct(example.Entities.product product) {
        this.product = product;
    }
}
