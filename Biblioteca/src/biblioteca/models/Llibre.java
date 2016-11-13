/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.models;

/**
 *
 * @author Roger
 */
public class Llibre {
  private String titol;
  private String autor;
  private String editorial;
  private int any;
  private int edicio;
  private int coleccio;
  private String descripcio;
  private String ISBN;
  private int genere;
  private int idioma;

    public Llibre(String titol, String autor, String editorial, int any, int edicio, int coleccio, String descripcio, String ISBN, int genere, int idioma) {
        this.titol = titol;
        this.autor = autor;
        this.editorial = editorial;
        this.any = any;
        this.edicio = edicio;
        this.coleccio = coleccio;
        this.descripcio = descripcio;
        this.ISBN = ISBN;
        this.genere = genere;
        this.idioma = idioma;
    }

  
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getEdicio() {
        return edicio;
    }

    public void setEdicio(int edicio) {
        this.edicio = edicio;
    }

    public int getColeccio() {
        return coleccio;
    }

    public void setColeccio(int coleccio) {
        this.coleccio = coleccio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getGenere() {
        return genere;
    }

    public void setGenere(int genere) {
        this.genere = genere;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }
  
  
}
