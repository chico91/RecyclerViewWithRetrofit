package com.example.recyclerviewwithretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {

private ArrayList<CarsModel> carsModels;
private Context context;

    public CarsAdapter(ArrayList<CarsModel> carsModels, Context context) {
        this.carsModels = carsModels;
        this.context = context;
    }

    @NonNull
    @Override
    public CarsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cars_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsAdapter.ViewHolder holder, int position) {
        holder.car_name.setText(carsModels.get(position).getName());
        holder.car_desc.setText(carsModels.get(position).getDesc());

        Picasso.get().load(carsModels.get(position).getImage()).into(holder.car_image);

    }

    @Override
    public int getItemCount() {
        return carsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView car_image;
        private TextView car_name, car_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            car_image =(ImageView) itemView.findViewById(R.id.car_image);
            car_name = (TextView) itemView.findViewById((R.id.car_name));
            car_desc = (TextView) itemView.findViewById((R.id.car_desc));
        }
    }
}
