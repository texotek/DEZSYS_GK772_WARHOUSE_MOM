package tradearea.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productID;
    private String productName;
    private String productCountry;
    private int productQuantity;
    private String productUnit;

    public Product() {}
    public Product(String productID, String productName, String productCountry, int productQuantity, String productUnit) {
        this.productID = productID;
        this.productName = productName;
        this.productCountry = productCountry;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    public String getProductID() {
        return productID;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductCountry(String productCountry) {
        this.productCountry = productCountry;
    }
    public String getProductCountry() {
        return productCountry;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
    public String getProductUnit() {
        return productUnit;
    }
    
}
