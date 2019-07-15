package lv.uzdevums;

import java.sql.Date;

public class Product { //Objekta "Product" apraksts
    private int id;
    private String name;
    private Date created;
    private String productType;
    private String status;


    public Product(int id, String name, Date created, String productType, String status) { // Konstruktors datu izvadei
        this.id = id;
        this.name = name;
        this.created = created;
        this.productType = productType;
        this.status = status;


    }

    public int getId() {   // "get" un "set" generēšana, lai būtu iespējamība saņēmt un ierakstīt datus, tālākām darbībām
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
