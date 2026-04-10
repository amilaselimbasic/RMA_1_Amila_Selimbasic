package ba.moviecatalog;

import java.io.Serializable;

// klasa za glumca
// cuva ime i sliku glumca
public class Actor implements Serializable {

    public String ime;
    public int slika;

    public Actor(String ime, int slika) {
        this.ime = ime;
        this.slika = slika;
    }

}