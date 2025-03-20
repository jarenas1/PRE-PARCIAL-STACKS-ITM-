package com.company.models;

import java.math.BigDecimal;

public class Prenda {
    private String id;
    private String reference;
    private String brand;
    private BigDecimal price;
    private Long units;

    public Prenda() {
    }

    public Prenda(String id, String reference, String brand, BigDecimal price, Long units) {
        this.id = id;
        this.reference = reference;
        this.brand = brand;
        this.price = price;
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal gePrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUnits() {
        return units;
    }

    public void setUnits(Long units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", brand='" + brand + '\'' +
                ",price=" + price +
                ", units=" + units +
                '}';
    }
}
