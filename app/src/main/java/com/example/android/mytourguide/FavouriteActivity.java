package com.example.android.mytourguide;

import android.os.Build;
import android.os.Bundle;

import android.widget.GridView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    static ArrayList<Item> items = new ArrayList<>();
    private GridView listView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_items_list);
        TourListAdapter adapter = new TourListAdapter(this,items);
        listView = (GridView)findViewById(R.id.lvItems);
        listView.setAdapter(adapter);
        listView.setClipToOutline(true);
    }
}
