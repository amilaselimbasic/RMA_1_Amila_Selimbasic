package ba.moviecatalog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Aktivnost koja prikazuje favorite filmove
public class FavoritesActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerView = findViewById(R.id.recyclerFavorites);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // pravim novu listu samo za favorite
        ArrayList<Movie> favorites = new ArrayList<>();

        // prolazim kroz glavnu listu iz MainActivity
        // sad radi jer je movieList static
        for (Movie m : MainActivity.movieList) {
            if (m.favorit) {
                favorites.add(m); // dodajem samo one koji su favorit
            }
        }

        // prikazujem favorite u recycleru
        recyclerView.setAdapter(new MovieAdapter(this, favorites));
    }
}
