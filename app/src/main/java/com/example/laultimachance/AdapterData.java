package com.example.laultimachance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolderData>{

    ArrayList<String> listDatos;

    public AdapterData(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido,null,false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        TextView dato;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            dato= (TextView) itemView.findViewById(R.id.idPedido);
        }

        public void asignarDatos(String s) {
        dato.setText(s);
        }
    }

}
