package ba.moviecatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

// Glavna aktivnost aplikacije
// prikazuje listu svih filmova
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieAdapter adapter;

    // Ovdje sam stavio static da bi se moglo koristiti iz druge aktivnosti
    // znam da to nije najbolje rješenje, ali radi posao za sad :)
    public static List<Movie> movieList;

    List<Movie> filteredList;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // povezivanje layout elemenata
        recyclerView = findViewById(R.id.recyclerMovies);
        searchView = findViewById(R.id.searchMovies);

        // dohvatanje liste filmova
        movieList = MovieData.getMovies();

        // pravim kopiju liste da mogu filtrirati
        filteredList = new ArrayList<>(movieList);

        // recycler view layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MovieAdapter(this, filteredList);
        recyclerView.setAdapter(adapter);

        // SEARCH funkcija
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false; // ne koristim submit
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                // brišem staru listu
                filteredList.clear();

                // prolazim kroz sve filmove
                for (Movie m : movieList) {
                    // ako naslov sadrži tekst koji sam upisao
                    if (m.naslov.toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(m); // dodaj ga u filtriranu listu
                    }
                }

                // kažem adapteru da se podaci promijenili
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}
