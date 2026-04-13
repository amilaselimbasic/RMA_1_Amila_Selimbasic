package ba.moviecatalog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Adapter povezuje listu filmova sa RecyclerView-om
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> implements Filterable {

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.naslov);
        holder.genre.setText(movie.zanr);
        holder.poster.setImageResource(movie.poster);

        // Klik otvara detalje i šalje indeks filma
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra("movie_index", position); // šaljemo indeks
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    // Pretraga po naslovu
    @Override
    public Filter getFilter() {
        return movieFilter;
    }

    private Filter movieFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Movie> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(MainActivity.movieList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Movie movie : MainActivity.movieList) {
                    if (movie.naslov.toLowerCase().contains(filterPattern)) {
                        filteredList.add(movie);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movieList.clear();
            movieList.addAll((List<Movie>) results.values);
            notifyDataSetChanged();
        }
    };

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title, genre;
        ImageView poster;

        MovieViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            genre = itemView.findViewById(R.id.movie_genre);
            poster = itemView.findViewById(R.id.movie_poster);
        }
    }
}
