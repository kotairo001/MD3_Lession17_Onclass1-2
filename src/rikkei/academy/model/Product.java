package rikkei.academy.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private String brand;
    private int price;
    private String description;

    public Product() {
    }

    public Product(int productId, String productName, String brand, int price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
