/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author ayedmouna
 */
public interface IServiceFavoris <Favoris>{
     public void ajouterfavoris(Favoris t);
    public void supprimerfavoris(Favoris t);
    public void modifierfavoris(Favoris t);
    public List<Favoris> rechercher(int favoris_id);

    public List<Favoris> afficherfavoris();
    
}
