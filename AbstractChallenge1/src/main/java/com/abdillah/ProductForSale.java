package com.abdillah;

public abstract class ProductForSale {
    protected String type;
    protected Double price;
    protected String description;

    public ProductForSale(String type, Double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public void printPricedItem(int qty) {
        System.out.printf("%2d qty at price $%8.2f each , %-15s %-35s %n\n", qty, price, type, description);
    }

    public Double getSalesPrice(int qty) {
        return price * qty;
    }

    public abstract void showDetails();
}
