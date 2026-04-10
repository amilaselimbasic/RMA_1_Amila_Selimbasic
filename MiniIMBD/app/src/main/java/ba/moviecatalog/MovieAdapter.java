package ba.moviecatalog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter koji prikazuje filmove u RecyclerView listi
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    List<Movie> movieList;

    // Konstruktor
    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    // Kreira izgled svakog itema
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    // Postavlja podatke za svaki film
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        Movie movie = movieList.get(position);

        holder.naslov.setText(movie.naslov);
        holder.zanr.setText(movie.zanr);
        holder.poster.setImageResource(movie.poster);
        holder.ratingBar.setRating(movie.rating);

        // klik na film otvara detalje
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra("film", movie);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    // ViewHolder klasa
    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView naslov;
        TextView zanr;
        RatingBar ratingBar;

        public MovieViewHolder(View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.poster);
            naslov = itemView.findViewById(R.id.naslov);
            zanr = itemView.findViewById(R.id.zanr);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}