package org.example.model;

import java.util.concurrent.atomic.AtomicLong;

public class Toy {
    private static final AtomicLong atomLong = new AtomicLong(0);
    private Long id;
    private String description;
    private int quantity;
    private int chance;

    public Toy(String description, int quantity, int chance) {
        this.id = atomLong.getAndIncrement();
        this.description = description;
        this.quantity = quantity;
        this.chance = chance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        if (chance > 100 || chance < 1)
            throw new IllegalStateException("chance must be in interval 1 and 100");
        this.chance = chance;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%d,%d", id, description, quantity, chance);
    }
}
