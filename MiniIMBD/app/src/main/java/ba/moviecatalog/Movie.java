package ba.moviecatalog;

import java.io.Serializable;
import java.util.List;

// Klasa koja predstavlja jedan film
// Serializable omogućava da se objekat prenosi kroz Intent
public class Movie implements Serializable {
    String naslov;      // Naslov filma
    String zanr;        // Žanr filma
    String opis;        // Kratki opis filma
    int poster;         // ID resursa za poster slike
    float rating;       // Ocjena filma
    List<Actor> glumci; // Lista glumaca koji glume u filmu
    boolean favorit;    // Da li je film označen kao favorit

    // Konstruktor za kreiranje novog filma
    public Movie(String naslov, String zanr, String opis, int poster, float rating, List<Actor> glumci) {
        this.naslov = naslov;
        this.zanr = zanr;
        this.opis = opis;
        this.poster = poster;
        this.rating = rating;
        this.glumci = glumci;
        this.favorit = false; // Po defaultu film nije favorit
    }
}
