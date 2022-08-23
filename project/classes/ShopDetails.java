package classes;

import java.lang.*;

public class ShopDetails {
    private String type;
    private String size;
    private String quantity;
    private String rent;

    public ShopDetails(String type, String size, String quantity, String rent) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.rent = rent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

}
