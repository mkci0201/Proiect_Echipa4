package ro.ubb.flowershop.core.model;

public class Product extends BaseEntity<Integer>{
    private String name;
    private String description;
    private int stock;
    private double price;
    private Category categoryId;

    public Product(String name, String description, int stock, double price, Category categoryId) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }
}
