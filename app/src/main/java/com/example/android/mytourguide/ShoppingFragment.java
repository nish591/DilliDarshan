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
public class ShoppingFragment extends Fragment {

    private GridView listView;
    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
    }
    public ShoppingFragment() {
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
        items.add(new Item(R.drawable.shop1,getString(R.string.title_shop1), getString(R.string.body_shop1),getString(R.string.address_shop1),"-1","-1"));
        items.add(new Item(R.drawable.shop2,getString(R.string.title_shop2), getString(R.string.body_shop2),getString(R.string.address_shop2),"-1","-1"));
        items.add(new Item(R.drawable.shop3,getString(R.string.title_shop3), getString(R.string.body_shop3),getString(R.string.address_shop3),"-1","-1"));
        items.add(new Item(R.drawable.shop4,getString(R.string.title_shop4), getString(R.string.body_shop4),getString(R.string.address_shop4),"-1","-1"));
        items.add(new Item(R.drawable.shop5,getString(R.string.title_shop5), getString(R.string.body_shop5),getString(R.string.address_shop5),"-1","-1"));
        items.add(new Item(R.drawable.shop6,getString(R.string.title_shop6), getString(R.string.body_shop6),getString(R.string.address_shop6),"-1","-1"));
        items.add(new Item(R.drawable.shop7,getString(R.string.title_shop7), getString(R.string.body_shop7),getString(R.string.address_shop7),"-1","-1"));
        items.add(new Item(R.drawable.shop8,getString(R.string.title_shop8), getString(R.string.body_shop8),getString(R.string.address_shop8),"-1","-1"));
        items.add(new Item(R.drawable.shop9,getString(R.string.title_shop9), getString(R.string.body_shop9),getString(R.string.address_shop9),"-1","-1"));
        items.add(new Item(R.drawable.shop10,getString(R.string.title_shop10), getString(R.string.body_shop10),getString(R.string.address_shop10),"-1","-1"));
        TourListAdapter adapter = new TourListAdapter(getActivity(),items);

        listView = (GridView) rootView.findViewById(R.id.lvItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Item currentItem= items.get(position);
                Log.v("ShoppingFragment", "Current item: " + currentItem);
                // Fire selected event for item
                Intent shoppingIntent = new Intent(getActivity().getApplication(),HotelsDetailActivity.class);
                shoppingIntent.putExtra("item",currentItem);
                // Start the new activity
                startActivity(shoppingIntent);
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
                        :GridView.CHOICE_MODE_NONE);
    }
    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources
    }
}
