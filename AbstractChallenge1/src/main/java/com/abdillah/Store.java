package com.abdillah;

import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product) {
}

public class Store {

    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();
    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting", 1350.0, "Impressionistic work by ABF painted in 2010"));
        storeProducts.add(new ArtObject("Sculpture", 2000.0, "Bronze work by JKF, produced in 1950"));
        storeProducts.add(new Furniture("Desk", 500.0, "Mahogany Desk"));
        storeProducts.add(new ArtObject("Lamp", 200.0, "Tiffany lamp with humming birds"));

        listProducts();
        System.out.println();

        var order1 =  new ArrayList<OrderItem>();
        addItemToOrder(order1, 0, 1);
        addItemToOrder(order1, 1, 2);
        printOrder(order1);

        var order2 =  new ArrayList<OrderItem>();
        addItemToOrder(order2, 2, 3);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 3, 2);
        printOrder(order2);
//         manage list of products for sale, including displaying the product details
//         manage order which can just be a list of OrderItem objects
//         have methods to add an item to the order, and print the ordered items, so it looks like receipt

//        Create ProductForSale class that should have: type, price, description
//        have methods: getSalesPrice(quantity), printPricedItem(quantity), showDetails abstract method

//        Create OrderItem type that has quantity, and a ProductForSale
//        Create 2 or 3 classes that extend ProductForSale class, that will be products in your store
    }

    public static void listProducts(){
        for (var item : storeProducts) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for(var item : order){
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }

        System.out.printf("Sales total = $%6.2f %n", salesTotal);
    }
}