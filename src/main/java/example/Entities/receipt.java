package example.Entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
public class receipt {
    @Id
    @GeneratedValue
    @Column(name = "receipt_id")
    private int id;
    private String name;
    private String email;
    private String address;
    private Timestamp date;
    private Boolean status;
    @OneToMany(mappedBy = "receipt", fetch = FetchType.LAZY)
    private Set<receiptItem> receiptItem;

    public receipt() {
    }

    public receipt(int id, String name, String email, String address, Timestamp date, Boolean status, Set<example.Entities.receiptItem> receiptItem) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.date = date;
        this.status = status;
        this.receiptItem = receiptItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<example.Entities.receiptItem> getReceiptItem() {
        return receiptItem;
    }

    public void setReceiptItem(Set<example.Entities.receiptItem> receiptItem) {
        this.receiptItem = receiptItem;
    }
}
