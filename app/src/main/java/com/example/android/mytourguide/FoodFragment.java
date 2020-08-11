package com.example.android.mytourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    private GridView listView;


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
    }
    public FoodFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items_list, container, false);

        final ArrayList<Item> items= new ArrayList<Item>();
        items.add(new Item(R.drawable.food1,getString(R.string.title_food1), getString(R.string.body_food1),getString(R.string.address_food1),getString(R.string.phone_food1),getString(R.string.time_food1)));
        items.add(new Item(R.drawable.food2,getString(R.string.title_food2), getString(R.string.body_food2),getString(R.string.address_food2),getString(R.string.phone_food2),getString(R.string.time_food2)));
        items.add(new Item(R.drawable.food3,getString(R.string.title_food3), getString(R.string.body_food3),getString(R.string.address_food3),getString(R.string.phone_food3),getString(R.string.time_food3)));
        items.add(new Item(R.drawable.food4,getString(R.string.title_food4), getString(R.string.body_food4),getString(R.string.address_food4),getString(R.string.phone_food4),getString(R.string.time_food4) ));
        items.add(new Item(R.drawable.food5,getString(R.string.title_food5), getString(R.string.body_food5),getString(R.string.address_food5),getString(R.string.phone_food5),getString(R.string.time_food5)));
        items.add(new Item(R.drawable.food6,getString(R.string.title_food6), getString(R.string.body_food6),getString(R.string.address_food6),getString(R.string.phone_food6),getString(R.string.time_food6)));
        items.add(new Item(R.drawable.food7,getString(R.string.title_food7), getString(R.string.body_food7),getString(R.string.address_food7),getString(R.string.phone_food7),getString(R.string.time_food7)));
        items.add(new Item(R.drawable.food8,getString(R.string.title_food8), getString(R.string.body_food8),getString(R.string.address_food8),getString(R.string.phone_food8),getString(R.string.time_food8)));
        items.add(new Item(R.drawable.food9,getString(R.string.title_food9), getString(R.string.body_food9),getString(R.string.address_food9),getString(R.string.phone_food9),getString(R.string.time_food9)));
        items.add(new Item(R.drawable.food10,getString(R.string.title_food10), getString(R.string.body_food10),getString(R.string.address_food10),getString(R.string.phone_food10),getString(R.string.time_food10)));
        TourListAdapter adapter = new TourListAdapter(getActivity(),items);

        listView = (GridView) rootView.findViewById(R.id.lvItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Item currentItem= items.get(position);
                Log.v("FoodFragment", "Current item: " + currentItem);
                // Fire selected event for item
                Intent foodIntent = new Intent(getActivity().getApplication(),HotelsDetailActivity.class);
                foodIntent.putExtra("item",currentItem);
                // Start the new activity
                startActivity(foodIntent);
            }

            // The code in this method will be executed when the numbers list item is clicked on.
        });
        listView.setClipToOutline(true);
        return rootView;
    }
    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        listView.setChoiceMode(
                activateOnItemClick ? GridView.CHOICE_MODE_SINGLE
                        : GridView.CHOICE_MODE_NONE);
    }
    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources
    }
}
