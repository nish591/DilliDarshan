package com.example.android.mytourguide;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class HotelsDetailActivity extends FragmentActivity{
    ItemDetailFragment fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Item item = (Item) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null) {
            fragmentItemDetail = ItemDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItemDetail);
            ft.commit();
        }
    }


}
