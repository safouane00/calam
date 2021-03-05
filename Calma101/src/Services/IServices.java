/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Shop.Produit;
/**
 *
 * @author zribioussama
 */
public interface IServices  {
    public void ajouterProduit();
    public void modifierProduit(Produit p);
    public void afficherProduit(Produit p);
    public void rechercherProduit(Produit p);
    
}
