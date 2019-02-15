package com.dotin.course.entities;

import javax.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue
    private Long id;

    private Double amount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ITEM_ID", foreignKey = @ForeignKey(name = "BID_FK_ITEM"))
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
