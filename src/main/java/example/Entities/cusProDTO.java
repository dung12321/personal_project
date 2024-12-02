package example.Entities;

public class cusProDTO {
    private customer customer;
    private product product;

    public cusProDTO(example.Entities.customer customer, example.Entities.product product) {
        this.customer = customer;
        this.product = product;
    }

    public cusProDTO() {
    }

    public example.Entities.customer getCustomer() {
        return customer;
    }

    public void setCustomer(example.Entities.customer customer) {
        this.customer = customer;
    }

    public example.Entities.product getProduct() {
        return product;
    }

    public void setProduct(example.Entities.product product) {
        this.product = product;
    }
}
