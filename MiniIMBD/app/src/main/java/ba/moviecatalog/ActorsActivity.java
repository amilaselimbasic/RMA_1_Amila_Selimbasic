package ba.moviecatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Aktivnost koja prikazuje glumce
public class ActorsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ActorAdapter adapter;
    List<Actor> actorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);

        recyclerView = findViewById(R.id.recyclerActors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Napuni listu glumaca iz svih filmova
        actorList = new ArrayList<>();
        for (Movie movie : MainActivity.movieList) {
            actorList.addAll(movie.glumci);
        }

        adapter = new ActorAdapter(actorList);
        recyclerView.setAdapter(adapter);

        // Navigacija na dnu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_movies) {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            } else if (item.getItemId() == R.id.nav_actors) {
                return true; // već smo ovdje
            } else if (item.getItemId() == R.id.nav_favorites) {
                startActivity(new Intent(this, FavoritesActivity.class));
                return true;
            }
            return false;
        });
    }
}
