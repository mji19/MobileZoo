package adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bloomfield.android.mobilezoo.R;
import com.bloomfield.android.mobilezoo.models.Animal;
import com.bumptech.glide.Glide;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder>{

    Context context;
    List<Animal> animals;

    public AnimalAdapter(Context context, List<Animal> movies) {
        this.context = context;
        this.animals = animals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("AnimalAdapter", "onCreateViewHolder");
        View animalView =  LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false);
        return new ViewHolder(animalView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("AnimalAdapter", "onBindHolder" + position);
        Animal animal = animals.get(position);
        holder.bind(animal);

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView tvName;
        TextView tvSpecies;
        ImageView ivPicture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSpecies = itemView.findViewById(R.id.tvSpecies);
            ivPicture = itemView.findViewById(R.id.ivPicture);

        }

        public void bind(Animal animal) {
            tvName.setText(animal.getName());
            tvSpecies.setText(animal.getSpecies());
            Glide.with(context).load(animal.getImagePath()).into(ivPicture);

        }
    }
}

