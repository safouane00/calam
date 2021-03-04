/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Shop;
import Entities.Shop.Produit;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author zribioussama
 */
public class Cart {
    List<Produit> cartItems = new ArrayList<Produit>();
    
    public void addProduitToCartByPID (int pid){
        Produit produit = getProduitByProduitID(pid);
        addToCart(produit);
    }
    
    private Produit getProduitByProduitID (int pid) {
        Produit produit = null;
        List <Produit> produits =new Produits().getProduits();
        for (Produit prod : produits){
            if (prod.getPid() == pid){
                produit = prod;
                break;
            }
        }
        return produit;
    }
    
    private void addToCart (Produit produit) {
        cartItems.add(produit);
    }
    
    void removeProduitByPID(int pid){
        Produit prod = getProduitByProduitID(pid);
        cartItems.remove(prod);
       
    }
    
    void afficheCartItems(){
        cartItems.forEach((prod) -> {
            System.out.println(prod.getName());
        });
    }
}
