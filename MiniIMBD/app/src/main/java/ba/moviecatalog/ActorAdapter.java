package ba.moviecatalog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter za prikaz glumaca u RecyclerView-u
public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private List<Actor> actorList;

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
        holder.name.setText(actor.ime);
        holder.photo.setImageResource(actor.slika);
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    class ActorViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView photo;

        ActorViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.actor_ime);
            photo = itemView.findViewById(R.id.actor_slika);
        }
    }
}
