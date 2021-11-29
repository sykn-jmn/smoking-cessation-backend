package com.example.smokingcessation.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "dailyChallengeSequence")
public class Cigarette {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "cigaretteSeq")
    @Column(nullable = false, updatable = false)
    public Long id;
    @Column(length = 1000)
    public String name;
    public Double price;

    public Cigarette(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Cigarette() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cigarette{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}