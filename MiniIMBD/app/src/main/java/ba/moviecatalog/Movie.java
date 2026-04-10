package ba.moviecatalog;

import java.io.Serializable;
import java.util.List;

// Klasa koja predstavlja jedan film
public class Movie implements Serializable {

    // osnovni podaci o filmu
    public String naslov;
    public String zanr;
    public String opis;

    // slika postera (resurs)
    public int poster;

    // pocetna ocjena filma
    public float rating;

    // korisnicka ocjena
    public float userRating = 0;

    // lista glumaca
    public List<Actor> glumci;

    // da li je favorit
    public boolean favorit = false;

    // konstruktor
    public Movie(String naslov, String zanr, String opis, int poster, float rating, List<Actor> glumci) {

        this.naslov = naslov;
        this.zanr = zanr;
        this.opis = opis;
        this.poster = poster;
        this.rating = rating;
        this.glumci = glumci;

    }

}