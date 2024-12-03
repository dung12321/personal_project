package example.Entities;

import jakarta.persistence.*;

@Entity
public class product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;
    private String description;
    private String image;
    private String category;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customer customer;

    public product() {
    }

    public product(long id, String name, double price, String description, String image, String category, int quantity, example.Entities.customer customer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.quantity = quantity;
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public example.Entities.customer getCustomer() {
        return customer;
    }

    public void setCustomer(example.Entities.customer customer) {
        this.customer = customer;
    }
}
