/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import biblioteca.models.Coleccio;
import biblioteca.models.Genere;
import biblioteca.models.Idioma;
import biblioteca.models.Llibre;
import java.util.List;

/**
 *
 * @author Roger
 */
public class Controller {
    
    
    private Model model;
    
    
    
    public Controller() {
       this.model = new Model(); 
        
    }
    
    
    public int AddIdioma(Idioma i) {
        return this.model.insertIdioma(i);
    }
    public int AddGenere(Genere g) {
        
        return this.model.insertGenere(g);
    }
    public int AddColeccio(Coleccio c) {
        return this.model.insertCollecio(c);
    }
    public int AddLlibre(Llibre l) {
        return this.model.insertLlibre(l);
    }
 
    public List<String> GetIdiomesByName() {
        return this.model.getObjectsByName("Idioma");
    }
    public List<String> GetGeneresByName() {
        return this.model.getObjectsByName("Genere");
    }
    public List<String> GetColeccionsByName() {
        return this.model.getObjectsByName("Coleccio");
    }
    
}
