package ba.moviecatalog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter koji prikazuje listu glumaca
public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    List<Actor> actorList;

    public ActorAdapter(List<Actor> actorList) {
        this.actorList = actorList;
    }

    @Override
    public ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_item, parent, false);
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActorViewHolder holder, int position) {

        Actor actor = actorList.get(position);

        holder.ime.setText(actor.ime);
        holder.slika.setImageResource(actor.slika);
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public static class ActorViewHolder extends RecyclerView.ViewHolder {

        ImageView slika;
        TextView ime;

        public ActorViewHolder(View itemView) {
            super(itemView);

            slika = itemView.findViewById(R.id.actor_slika);
            ime = itemView.findViewById(R.id.actor_ime);
        }
    }
}