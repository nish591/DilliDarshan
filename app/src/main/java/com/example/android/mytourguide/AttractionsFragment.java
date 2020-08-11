package com.example.android.mytourguide;

import android.content.Context;
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
public class AttractionsFragment extends Fragment {

    private GridView listView;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onItemSelected(Item i);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement AttractionsFragment.OnItemSelectedListener");
        }
    }
    public AttractionsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items_list, container, false);
        final ArrayList<Item> items= new ArrayList<Item>();
        items.add(new Item(R.drawable.spot1,getString(R.string.title_spot1), getString(R.string.body_spot1),getString(R.string.address_spot1),"-1",getString(R.string.time_spot1)));
        items.add(new Item(R.drawable.spot2,getString(R.string.title_spot2), getString(R.string.body_spot2),getString(R.string.address_spot2),"-1", getString(R.string.time_spot2)));
        items.add(new Item(R.drawable.spot3,getString(R.string.title_spot3), getString(R.string.body_spot3),getString(R.string.address_spot3),"-1", getString(R.string.time_spot3)));
        items.add(new Item(R.drawable.spot4,getString(R.string.title_spot4), getString(R.string.body_spot4),getString(R.string.address_spot4),"-1", getString(R.string.time_spot4)));
        items.add(new Item(R.drawable.spot5,getString(R.string.title_spot5), getString(R.string.body_spot5),getString(R.string.address_spot5),"-1", getString(R.string.time_spot5)));
        items.add(new Item(R.drawable.spot6,getString(R.string.title_spot6), getString(R.string.body_spot6),getString(R.string.address_spot6),"-1", getString(R.string.time_spot6)));
        items.add(new Item(R.drawable.spot7,getString(R.string.title_spot7), getString(R.string.body_spot7),getString(R.string.address_spot7),"-1", getString(R.string.time_spot7)));
        items.add(new Item(R.drawable.spot8,getString(R.string.title_spot8), getString(R.string.body_spot8),getString(R.string.address_spot8),"-1", getString(R.string.time_spot8)));
        items.add(new Item(R.drawable.spot9,getString(R.string.title_spot9), getString(R.string.body_spot9),getString(R.string.address_spot9),"-1", getString(R.string.time_spot9)));
        items.add(new Item(R.drawable.spot10,getString(R.string.title_spot10), getString(R.string.body_spot10),getString(R.string.address_spot10),"-1", getString(R.string.time_spot10)));
        items.add(new Item(R.drawable.spot11,getString(R.string.title_spot11), getString(R.string.body_spot11),getString(R.string.address_spot11),"-1", getString(R.string.time_spot11)));
        items.add(new Item(R.drawable.spot12,getString(R.string.title_spot12), getString(R.string.body_spot12),getString(R.string.address_spot12),"-1", getString(R.string.time_spot12)));
        items.add(new Item(R.drawable.spot14,getString(R.string.title_spot13), getString(R.string.body_spot13),getString(R.string.address_spot13),"-1", getString(R.string.time_spot13)));
        items.add(new Item(R.drawable.spot13,getString(R.string.title_spot14), getString(R.string.body_spot14),getString(R.string.address_spot14),"-1", getString(R.string.time_spot14)));
        TourListAdapter adapter = new TourListAdapter(getActivity(),items);

        listView = (GridView) rootView.findViewById(R.id.lvItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Item currentItem= items.get(position);
                Log.v("AttractionsFragment", "Current item: " + currentItem);
                // Fire selected event for item
                listener.onItemSelected(currentItem);
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
