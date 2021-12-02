package com.example.laultimachance;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.MyViewHolder> {

    Context context;
    ArrayList<Cart> list;

    public AdapterCart(Context context, ArrayList<Cart> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Cart cart = list.get(position);
    holder.name.setText(cart.getProduct());
    holder.price.setText(cart.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, price;
        //ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nombre_carrito);
            price = itemView.findViewById(R.id.precio_carrito);
          //  image = (ImageView) itemView.findViewById(R.id.imgcarrito);

        }
    }
}