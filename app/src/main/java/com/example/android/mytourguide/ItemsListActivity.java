package com.example.android.mytourguide;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;


public class ItemsListActivity extends AppCompatActivity implements AttractionsFragment.OnItemSelectedListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        if (fragmentItemDetail != null) {
            AttractionsFragment fragmentItemsList = (AttractionsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentItemsList);
            fragmentItemsList.setActivateOnItemClick(true);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this,getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FavouriteActivity.items.isEmpty()==true) {
                    Toast toast= Toast.makeText(getApplicationContext(), "You have No Favourites right now!!", Toast.LENGTH_SHORT);
                    View view2=toast.getView();
                    view2.getBackground().setColorFilter(getResources().getColor(R.color.theme), PorterDuff.Mode.SRC_IN);
                    TextView textView=(TextView) view2.findViewById(android.R.id.message);
                    textView.setTextColor(getResources().getColor(R.color.text_color));
                    toast.show();
                }
                Intent i=new Intent(getApplicationContext(),FavouriteActivity.class);
                startActivity(i);
            }
        });

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }

    }


    @Override
    public void onItemSelected(Item item) {
        // separate activities
        // launch detail activity using intent
        Intent i = new Intent(this, ItemDetailActivity.class);
        i.putExtra("item", item);
        startActivity(i);
    }

}


