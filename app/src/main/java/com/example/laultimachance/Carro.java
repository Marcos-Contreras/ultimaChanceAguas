package com.example.laultimachance;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Carro#newInstance} factory method to
 * create an instance of this fragment.
 */


public class Carro extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView id_recycler;
    DatabaseReference data;
    AdapterCart adapterCart;
    ArrayList<Cart> list;
    double precioTotal = 0;
    TextView precio_total;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Carro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Carro.
     */
    // TODO: Rename and change types and number of parameters
    public static Carro newInstance(String param1, String param2) {
        Carro fragment = new Carro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carro, container, false);
        Button btnToCheckout = (Button) view.findViewById(R.id.comprar_carrito);
        Button carrito_eliminar = (Button) view.findViewById(R.id.carrito_eliminar);



        carrito_eliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                data.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Carro.this.getContext(), "Productos eliminados correctamente", Toast.LENGTH_SHORT).show();
                        Intent refrescar = new Intent(getActivity(), PaginaPrincipal.class);
                        startActivity(refrescar);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Carro.this.getContext(), "No hay elemento en el carrito", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

        btnToCheckout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent toCheckout = new Intent(getActivity(), Checkout.class);
                toCheckout.putExtra("preciototal", precioTotal);
                startActivity(toCheckout);
            }

        });
        precio_total = view.findViewById(R.id.precio_total);
        RecyclerView id_recycler = view.findViewById(R.id.id_recycler);
        data = FirebaseDatabase.getInstance().getReference("Cart");
        id_recycler.setHasFixedSize(true);
        id_recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));

        list = new ArrayList<>();
        adapterCart = new AdapterCart(this.getContext(),list);
        id_recycler.setAdapter(adapterCart);

        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                precioTotal = 0;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Cart cart = dataSnapshot.getValue(Cart.class);
                    list.add(cart);
                    precioTotal += Double.parseDouble(cart.getPrice().toString());
                }
                adapterCart.notifyDataSetChanged();
                precio_total.setText("" + precioTotal);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
    /*public void btnToCheckout(View v)
    {
        Intent toCheckout = new Intent(getActivity(), Checkout.class);
        startActivity(toCheckout);
    }*/
}