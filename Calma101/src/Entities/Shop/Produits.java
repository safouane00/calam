/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zribioussama
 */
public class Produits {
    private final List<Produit> produits = new ArrayList<Produit>();
    public Produits(){
        this.initStoreItems();
    }

    public List<Produit> getProduits() {
        return produits;
    }
    
    public void initStoreItems(){
        String [] produitNoms = {"Abonnement Premium", "Abonnement Gold", "Abonnement Silver","Discover"};
        Double [] produitPrix = {60.00d , 40.00d , 20.00d, 00.00d };
        Integer [] stock = {30, 30, 30 , 7};
        
        for (int i=0; i< produitNoms.length; i++) {
            this.produits.add ( new Produit (i+1, produitNoms[i], produitPrix[i], stock[i]));
        }
    }
    
}
