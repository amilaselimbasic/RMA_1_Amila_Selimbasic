package ba.moviecatalog;

import java.io.Serializable;

// Klasa koja predstavlja jednog glumca
public class Actor implements Serializable {
    String ime;   // Ime glumca
    int slika;    // ID resursa za sliku glumca

    public Actor(String ime, int slika) {
        this.ime = ime;
        this.slika = slika;
    }
}
