package ba.moviecatalog;

import java.util.ArrayList;
import java.util.List;

// ova klasa sluzi samo da generise listu filmova

public class MovieData {

    public static List<Movie> getMovies() {

        List<Movie> lista = new ArrayList<>();

        // ======================
        // WHAT HAPPENED TO MONDAY
        // ======================

        List<Actor> actors1 = new ArrayList<>();
        actors1.add(new Actor("Noomi Rapace", R.drawable.noomi));
        actors1.add(new Actor("Willem Dafoe", R.drawable.dafoe));
        actors1.add(new Actor("Glenn Close", R.drawable.close));
        actors1.add(new Actor("Marwan Kenzari", R.drawable.kenzari));
        actors1.add(new Actor("Christian Rubeck", R.drawable.rubeck));

        lista.add(new Movie(
                "What Happened to Monday",
                "Sci-Fi",
                "U svijetu gdje je dozvoljeno samo jedno dijete po porodici, sedam sestara se krije od vlade.",
                R.drawable.monday,
                7.6f,
                actors1
        ));

        // ======================
        // SHUTTER ISLAND
        // ======================

        List<Actor> actors2 = new ArrayList<>();
        actors2.add(new Actor("Leonardo DiCaprio", R.drawable.dicaprio));
        actors2.add(new Actor("Mark Ruffalo", R.drawable.ruffalo));
        actors2.add(new Actor("Ben Kingsley", R.drawable.kingsley));
        actors2.add(new Actor("Michelle Williams", R.drawable.williams));
        actors2.add(new Actor("Max von Sydow", R.drawable.sydow));

        lista.add(new Movie(
                "Shutter Island",
                "Thriller",
                "US marshal istrazuje nestanak pacijentice iz mentalne bolnice na izoliranom ostrvu.",
                R.drawable.shutter,
                8.2f,
                actors2
        ));

        // ======================
        // NOW YOU SEE ME
        // ======================

        List<Actor> actors3 = new ArrayList<>();
        actors3.add(new Actor("Jesse Eisenberg", R.drawable.eisenberg));
        actors3.add(new Actor("Woody Harrelson", R.drawable.harrelson));
        actors3.add(new Actor("Isla Fisher", R.drawable.fisher));
        actors3.add(new Actor("Dave Franco", R.drawable.franco));
        actors3.add(new Actor("Mark Ruffalo", R.drawable.ruffalo));

        lista.add(new Movie(
                "Now You See Me",
                "Crime",
                "Grupa iluzionista pljacka banke tokom svojih nastupa.",
                R.drawable.nowyou,
                7.3f,
                actors3
        ));

        // ======================
        // TITANIC
        // ======================

        List<Actor> actors4 = new ArrayList<>();
        actors4.add(new Actor("Leonardo DiCaprio", R.drawable.dicaprio));
        actors4.add(new Actor("Kate Winslet", R.drawable.winslet));
        actors4.add(new Actor("Billy Zane", R.drawable.zane));
        actors4.add(new Actor("Kathy Bates", R.drawable.bates));
        actors4.add(new Actor("Frances Fisher", R.drawable.frances));

        lista.add(new Movie(
                "Titanic",
                "Romance",
                "Ljubavna prica dvoje mladih na cuvenom brodu Titanic.",
                R.drawable.titanic,
                7.9f,
                actors4
        ));

        // ======================
        // FAST AND FURIOUS
        // ======================

        List<Actor> actors5 = new ArrayList<>();
        actors5.add(new Actor("Vin Diesel", R.drawable.diesel));
        actors5.add(new Actor("Paul Walker", R.drawable.walker));
        actors5.add(new Actor("Michelle Rodriguez", R.drawable.rodriguez));
        actors5.add(new Actor("Jordana Brewster", R.drawable.brewster));
        actors5.add(new Actor("Tyrese Gibson", R.drawable.tyrese));

        lista.add(new Movie(
                "Fast and Furious",
                "Action",
                "Film o ilegalnim ulicnim utrkama i kriminalu.",
                R.drawable.fast,
                7.0f,
                actors5
        ));

        return lista;

    }

}