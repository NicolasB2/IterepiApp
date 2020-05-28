package com.example.iterepi.view.store;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iterepi.R;
import com.example.iterepi.adapter.SaleItemAdapter;
import com.example.iterepi.model.Seller;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SaleFragment extends Fragment implements View.OnClickListener {

    private View view;
    private SaleItemAdapter saleItemAdapter;
    private ArrayList<Seller> saleItems;
    private RecyclerView listOrderRV;
    private ImageView emptyOrderIV;
    private TextView emptyOrderTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        view = inflater.inflate(R.layout.fragment_store_order, container, false);
        listOrderRV = view.findViewById(R.id.listOrderRV);
        listOrderRV.setLayoutManager(new LinearLayoutManager(getContext()));
        emptyOrderIV = view.findViewById(R.id.emptyOrder);
        emptyOrderTV = view.findViewById(R.id.emptyOrderTV);
        emptyOrderIV.setVisibility(View.GONE);
        emptyOrderTV.setVisibility(View.GONE);

        saleItems = new ArrayList<>();

        Query query= FirebaseDatabase.getInstance().getReference().child("sellers").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Seller s = dataSnapshot.getValue(Seller.class);
                loadItems(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }


    public void loadItems(Seller s){

        if(s!=null){
            //arreglo debe ser los clientes
            Log.e(">>>","Cargo el vendedor"+s.getName());
            if(s.getSalesID()!=null){
                Log.e(">>>","Id de su primer venta"+s.getSalesID());
            }

        }


    }


    @Override
    public void onClick(View v) {

    }
}