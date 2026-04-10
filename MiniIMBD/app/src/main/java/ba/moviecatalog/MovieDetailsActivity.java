package ba.moviecatalog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class DetailActivity extends AppCompatActivity {

    ImageView poster;
    TextView title, genre, description, rating;
    RecyclerView actorsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        poster = findViewById(R.id.detailPoster);
        title = findViewById(R.id.detailTitle);
        genre = findViewById(R.id.detailGenre);
        description = findViewById(R.id.detailDescription);
        rating = findViewById(R.id.detailRating);
        actorsRecycler = findViewById(R.id.recyclerActors);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        poster.setImageResource(movie.poster);
        title.setText(movie.naslov);
        genre.setText(movie.zanr);
        description.setText(movie.opis);
        rating.setText("Rating: " + movie.rating);

        ActorAdapter actorAdapter = new ActorAdapter(this, movie.glumci);

        actorsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        actorsRecycler.setAdapter(actorAdapter);
    }
}