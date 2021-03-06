package com.example.iterepi.view.store;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.iterepi.R;
import com.example.iterepi.adapter.ItemsAdapter;
import com.example.iterepi.controller.store.seeCategoryController;
import com.example.iterepi.model.Category;
import com.google.android.material.textfield.TextInputLayout;

public class SeeCategoryActivity extends SellerNavigationDrawerActivity {

    private seeCategoryController controller;

    private TextView categoryNameTV;
    private TextInputLayout categoryNameTF;
    private ListView myItemsList;

    private Button updateDataBtn;
    private ImageButton backBtn;

    private Category category;
    private String placeId;
    private String categoryId;

    private ItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_see_category, null, false);
        getDrawerLayout().addView(contentView, 0);

        this.placeId = (String) getIntent().getExtras().getSerializable("placeId");
        this.categoryId = (String) getIntent().getExtras().getSerializable("categoryId");

        this.myItemsList = findViewById(R.id.myItemsList);
        this.updateDataBtn = findViewById(R.id.updateDataBtn);
        this.backBtn = findViewById(R.id.backBtn);
        this.categoryNameTV = findViewById(R.id.categoryNameTV);
        this.categoryNameTF = findViewById(R.id.categoryNameTF);

        this.controller = new seeCategoryController(this);
    }

    public TextView getCategoryNameTV() {
        return categoryNameTV;
    }

    public TextInputLayout getCategoryNameTF() {
        return categoryNameTF;
    }

    public ListView getMyItemsList() {
        return myItemsList;
    }

    public Button getUpdateDataBtn() {
        return updateDataBtn;
    }

    public ImageButton getBackBtn() {
        return backBtn;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category=category;
        this.adapter = new ItemsAdapter(this,category.getItems());
        this.myItemsList.setAdapter(adapter);
    }
}
