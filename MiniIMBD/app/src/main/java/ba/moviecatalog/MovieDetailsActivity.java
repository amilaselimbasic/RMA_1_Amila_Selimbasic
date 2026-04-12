package ba.moviecatalog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    // elementi iz XML-a
    ImageView poster;
    TextView title, genre, description;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // povezujem sa XML fajlom (mora se zvati activity_detail.xml u res/layout)
        setContentView(R.layout.activity_movie_details);

        // povezujem varijable sa elementima iz XML-a
        poster = findViewById(R.id.detailPoster);
        title = findViewById(R.id.detailTitle);
        genre = findViewById(R.id.detailGenre);
        description = findViewById(R.id.detailDescription);
        ratingBar = findViewById(R.id.detailRating);

        // dobijam podatke iz Intenta
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // uzimam podatke koje sam poslala iz druge aktivnosti
            int posterRes = extras.getInt("poster");
            String movieTitle = extras.getString("title");
            String movieGenre = extras.getString("genre");
            String movieDesc = extras.getString("description");
            float movieRating = extras.getFloat("rating");

            // postavljam podatke u elemente
            poster.setImageResource(posterRes);
            title.setText(movieTitle);
            genre.setText(movieGenre);
            description.setText(movieDesc);
            ratingBar.setRating(movieRating);
        }
    }
}
