package knf.moisestest.Adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import knf.moisestest.R;
import knf.moisestest.Utils.ContentFactory;
import knf.moisestest.Utils.OpenHelper;

/**
 * Created by Jordy on 19/05/2017.
 */

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {
    private List<ContentFactory.Animal> animals = new ArrayList<>();
    private Activity context;

    public AnimalListAdapter(Activity context, ContentFactory.AnimalType type) {
        this.context = context;
        this.animals = ContentFactory.get(type);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false));
    }

    @Override
    public void onBindViewHolder(final AnimalListAdapter.ViewHolder holder, int position) {
        final ContentFactory.Animal animal = animals.get(holder.getAdapterPosition());
        holder.img.setImageResource(animal.res_img);
        holder.name.setText(animal.name);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenHelper.open(context, animal, holder.img, holder.name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        CardView card;

        private ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            card = (CardView) itemView.findViewById(R.id.card);
        }
    }
}
