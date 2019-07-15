package lv.uzdevums;

import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private Date created;
    private String productType;
    private int status;


    public Product(int id, String name, Date created, String productType, int status) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.productType = productType;
        this.status = status;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created='" + created + '\'' +
                ", productType='" + productType + '\'' +
                ", status=" + status +
                '}';
    }
}
