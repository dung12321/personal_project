package example.Entities;

import jakarta.persistence.*;

@Entity
public class receiptItem {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private receipt receipt;
    @OneToOne
    @JoinColumn(name = "product_id")
    private product product;
    private int receiptItemQuantity;
    private double receiptItemPrice;
    private int receiptItemSale;
    private boolean receiptItemStatus;

    public receiptItem(int id, example.Entities.receipt receipt, example.Entities.product product, int receiptItemQuantity, double receiptItemPrice, int receiptItemSale, boolean receiptItemStatus) {
        this.id = id;
        this.receipt = receipt;
        this.product = product;
        this.receiptItemQuantity = receiptItemQuantity;
        this.receiptItemPrice = receiptItemPrice;
        this.receiptItemSale = receiptItemSale;
        this.receiptItemStatus = receiptItemStatus;
    }

    public receiptItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public example.Entities.receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(example.Entities.receipt receipt) {
        this.receipt = receipt;
    }

    public example.Entities.product getProduct() {
        return product;
    }

    public void setProduct(example.Entities.product product) {
        this.product = product;
    }

    public int getReceiptItemQuantity() {
        return receiptItemQuantity;
    }

    public void setReceiptItemQuantity(int receiptItemQuantity) {
        this.receiptItemQuantity = receiptItemQuantity;
    }

    public double getReceiptItemPrice() {
        return receiptItemPrice;
    }

    public void setReceiptItemPrice(double receiptItemPrice) {
        this.receiptItemPrice = receiptItemPrice;
    }

    public int getReceiptItemSale() {
        return receiptItemSale;
    }

    public void setReceiptItemSale(int receiptItemSale) {
        this.receiptItemSale = receiptItemSale;
    }

    public boolean isReceiptItemStatus() {
        return receiptItemStatus;
    }

    public void setReceiptItemStatus(boolean receiptItemStatus) {
        this.receiptItemStatus = receiptItemStatus;
    }
}
