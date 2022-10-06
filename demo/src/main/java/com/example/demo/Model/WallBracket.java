package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "WallBrackets")
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String size;

    private boolean ajustable;

    private String name;

    private double price;

    @ManyToMany
    @JoinColumn(name = "television_id")
    List<Television> televisions;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAjustable() {
        return ajustable;
    }

    public void setAjustable(boolean ajustable) {
        this.ajustable = ajustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }
}
