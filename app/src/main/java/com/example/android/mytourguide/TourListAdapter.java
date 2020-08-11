package com.example.android.mytourguide;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class TourListAdapter extends ArrayAdapter<Item> {

    public TourListAdapter(Activity context, ArrayList<Item> items) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, items);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Item currentItem = getItem(position);
        ImageView image_view = (ImageView) listItemView.findViewById(R.id.image_view);
        image_view.setImageResource(currentItem.getImageResourceId());
        image_view.setClipToOutline(true);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentItem.getTitle());
        RelativeLayout ln= (RelativeLayout)listItemView.findViewById(R.id.text_container);
        ln.setClipToOutline(true);
        return listItemView;
    }

}
