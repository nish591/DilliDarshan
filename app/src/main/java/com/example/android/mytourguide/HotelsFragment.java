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
public class HotelsFragment extends Fragment {

    private GridView listView;


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

    }
    public HotelsFragment() {
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
        items.add(new Item(R.drawable.hotel1,getString(R.string.title_hotel1), getString(R.string.body_hotel1),getString(R.string.address_hotel1),getString(R.string.phone_hotel1),"-1"));
        items.add(new Item(R.drawable.hotel2,getString(R.string.title_hotel2), getString(R.string.body_hotel2),getString(R.string.address_hotel2),getString(R.string.phone_hotel2),"-1"));
        items.add(new Item(R.drawable.hotel3,getString(R.string.title_hotel3), getString(R.string.body_hotel3),getString(R.string.address_hotel3),getString(R.string.phone_hotel3),"-1"));
        items.add(new Item(R.drawable.hotel4,getString(R.string.title_hotel4), getString(R.string.body_hotel4),getString(R.string.address_hotel4),getString(R.string.phone_hotel4),"-1"));
        items.add(new Item(R.drawable.hotel5,getString(R.string.title_hotel5), getString(R.string.body_hotel5),getString(R.string.address_hotel5),getString(R.string.phone_hotel5),"-1"));
        items.add(new Item(R.drawable.hotel7,getString(R.string.title_hotel6), getString(R.string.body_hotel6),getString(R.string.address_hotel6),getString(R.string.phone_hotel6),"-1"));
        items.add(new Item(R.drawable.hotel8,getString(R.string.title_hotel7), getString(R.string.body_hotel7),getString(R.string.address_hotel7),getString(R.string.phone_hotel7),"-1"));
        items.add(new Item(R.drawable.hotel9,getString(R.string.title_hotel8), getString(R.string.body_hotel8),getString(R.string.address_hotel8),getString(R.string.phone_hotel8),"-1"));
        items.add(new Item(R.drawable.hotel10,getString(R.string.title_hotel9), getString(R.string.body_hotel9),getString(R.string.address_hotel9),getString(R.string.phone_hotel9),"-1"));
        items.add(new Item(R.drawable.hotel11,getString(R.string.title_hotel10), getString(R.string.body_hotel10),getString(R.string.address_hotel10),getString(R.string.phone_hotel10),"-1"));
        TourListAdapter adapter = new TourListAdapter(getActivity(),items);

        listView = (GridView) rootView.findViewById(R.id.lvItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Item currentItem= items.get(position);
                Log.v("HotelsFragment", "Current item: " + currentItem);
                // Fire selected event for item
                Intent hotelsIntent = new Intent(getActivity().getApplication(),HotelsDetailActivity.class);
                hotelsIntent.putExtra("item",currentItem);
                // Start the new activity
                startActivity(hotelsIntent);

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
