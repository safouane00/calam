/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Shop;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author zribioussama
 */
public class Shop {
     Cart cart = new Cart();
    private int ch = 0;
    
    public Shop () {
        menu();
    }
    
    public void startScreen (){
        System.out.println("1. Display Shop Products");
        System.out.println("2. Display Cart");
        System.out.println("0. Exit");    
    }
    
    
    public void ShopProductsMenu (){
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove from Cart");
        System.out.println("0. Exit");  
    }
    
    public void menu (){
        do {
            startScreen();
            getUserInput();
            
            
            switch (ch){
                case 1:
                    displayShopProducts();
                    ShopProductsMenu();
                    getUserInput();
                    innerChoice1();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                
                default:
                    
                    break;
                
            }
        }while (ch != 0);
    }
    
    
    
    private void innerChoice1() {
        switch (ch){
            case 1: 
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:
                break;
        }   
    }
    
    private int getUserInput() throws NumberFormatException {
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }
    
    private void displayShopProducts() {
        List<Produit> produits = new Produits().getProduits();
        for (Produit prod: produits) {
            System.out.println(
                    prod.getPid() + "- " +
                            prod.getName() + " AVEC PRIX " +
                            prod.getPrice() + "dt POUR " +
                            prod.getStock() + "JOURS"
                               );
        }
    }
    
    private void addProductToCart() {
        int pid = getUserInput();
        cart.addProduitToCartByPID(pid);      
    }
    
    private void showCart() {
        cart.afficheCartItems();
    }
    
    private void removeProductFromCart() {
        int pid = getUserInput();
        cart.removeProduitByPID(pid);
    }
    
    
    
}
