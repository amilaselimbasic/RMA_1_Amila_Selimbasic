package ba.moviecatalog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RatingBar;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;

// Aktivnost koja prikazuje detalje o filmu
public class MovieDetailsActivity extends AppCompatActivity {

    ImageView poster;
    TextView title, genre, description;
    RatingBar ratingBar;
    Button btnFavorite;
    RecyclerView recyclerActors;
    ActorAdapter actorAdapter;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        poster = findViewById(R.id.poster);
        title = findViewById(R.id.title);
        genre = findViewById(R.id.genre);
        description = findViewById(R.id.description);
        ratingBar = findViewById(R.id.ratingBar);
        btnFavorite = findViewById(R.id.btnFavorite);
        recyclerActors = findViewById(R.id.recyclerActorsDetails);

        // Dohvati indeks filma iz Intenta
        int index = getIntent().getIntExtra("movie_index", -1);
        movie = MainActivity.movieList.get(index); // radimo na originalnom objektu

        // Popuni podatke
        poster.setImageResource(movie.poster);
        title.setText(movie.naslov);
        genre.setText(movie.zanr);
        description.setText(movie.opis);
        ratingBar.setRating(movie.rating);

        // Lista glumaca
        recyclerActors.setLayoutManager(new LinearLayoutManager(this));
        actorAdapter = new ActorAdapter(movie.glumci);
        recyclerActors.setAdapter(actorAdapter);

        // Klik na dugme dodaje film u favorite
        btnFavorite.setOnClickListener(v -> {
            movie.favorit = true; // označi originalni objekt
            btnFavorite.setText("U favoritima");
        });

        // Navigacija na dnu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_movies) {
                startActivity(new Intent(this, MainActivity.class));
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
