package ba.moviecatalog;

import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import java.util.List;

// Glavna aktivnost – prikazuje sve filmove
public class MainActivity extends AppCompatActivity {

    public static List<Movie> movieList; // globalna lista filmova
    RecyclerView recyclerView;
    MovieAdapter adapter;
    SearchView searchView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMovies);
        searchView = findViewById(R.id.searchMovies);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Kreiraj listu samo jednom – da se ne resetuje kad se otvori nova aktivnost
        if (movieList == null) {
            movieList = MovieData.getMovies();
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MovieAdapter(this, movieList);
        recyclerView.setAdapter(adapter);

        // Pretraga
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        // Navigacija
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_movies) {
                return true;
            } else if (item.getItemId() == R.id.nav_actors) {
                startActivity(new Intent(this, ActorsActivity.class));
                return true;
            } else if (item.getItemId() == R.id.nav_favorites) {
                startActivity(new Intent(this, FavoritesActivity.class));
                return true;
            }
            return false;
        });
    }
}
