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

    List<Movie> movieList;
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

        filteredList = new ArrayList<>(movieList);

        // recycler view layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MovieAdapter(this, filteredList);
        recyclerView.setAdapter(adapter);

        // SEARCH funkcija
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filteredList.clear();

                for (Movie m : movieList) {

                    if (m.naslov.toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(m);
                    }

                }

                adapter.notifyDataSetChanged();

                return true;
            }
        });

    }
}