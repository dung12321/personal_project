package example.Entities;

import jakarta.persistence.*;

@Entity
public class product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long id;
    private String name;
    private double price;
    private String description;
    private String image;
    private String category;
    private int quantity;
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private customer customer;
    @OneToOne(mappedBy = "product")
    private receiptItem receiptItem;

    public product() {
    }

    public product(String name, long id, double price, String description, String image, String category, int quantity, example.Entities.receiptItem receiptItem) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.quantity = quantity;
//        this.customer = customer;
        this.receiptItem = receiptItem;
    }

    public example.Entities.receiptItem getReceiptItem() {
        return receiptItem;
    }

    public void setReceiptItem(example.Entities.receiptItem receiptItem) {
        this.receiptItem = receiptItem;
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

//    public example.Entities.customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(example.Entities.customer customer) {
//        this.customer = customer;
//    }
}
