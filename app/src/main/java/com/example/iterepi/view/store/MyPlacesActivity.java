package com.example.iterepi.view.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.iterepi.R;
import com.example.iterepi.adapter.PlacesAdapter;
import com.example.iterepi.controller.store.MyPlacesController;

public class MyPlacesActivity extends SellerNavigationDrawerActivity {

    private MyPlacesController controller;
    private ListView myPlacesList;
    private PlacesAdapter adapter;
    private ImageButton addMethodBtn;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_my_places, null, false);
        getDrawerLayout().addView(contentView, 0);

        this.myPlacesList = findViewById(R.id.myCategoriesList);
        this.addMethodBtn = findViewById(R.id.addMethodBtn);
        this.backBtn = findViewById(R.id.backBtn);

        this.adapter = new PlacesAdapter(this);
        this.myPlacesList.setAdapter(adapter);

        this.controller = new MyPlacesController(this);
    }

    public ListView getMyPlacesList() {
        return myPlacesList;
    }

    public PlacesAdapter getAdapter() {
        return adapter;
    }

    public ImageButton getAddMethodBtn() {
        return addMethodBtn;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }


}
