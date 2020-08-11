package com.example.android.mytourguide;

import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ItemDetailFragment extends Fragment {
	private Item item;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		item = (Item) getArguments().getSerializable("item");
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_item_detail, 
				container, false);
		ImageView tvImage = (ImageView) view.findViewById(R.id.tvImage);
		TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		TextView tvBody = (TextView) view.findViewById(R.id.tvBody);
		ImageView tvAddress1 = (ImageView) view.findViewById(R.id.tvAddress1);
		TextView tvAddress2 = (TextView) view.findViewById(R.id.tvAddress2);
		ImageView tvPhone1 = (ImageView) view.findViewById(R.id.tvPhone1);
		TextView tvPhone2 = (TextView) view.findViewById(R.id.tvPhone2);
		LinearLayout tvPhone = (LinearLayout) view.findViewById(R.id.tvPhone);
		ImageView tvTime1 = (ImageView) view.findViewById(R.id.tvTime1);
		TextView tvTime2 = (TextView) view.findViewById(R.id.tvTime2);
		LinearLayout tvTime = (LinearLayout) view.findViewById(R.id.tvTime);
		tvTitle.setText(item.getTitle());
		tvBody.setText(item.getBody());
		tvImage.setImageResource(item.getImageResourceId());
		tvAddress1.setImageResource(R.drawable.location_blue);
		tvAddress2.setText(item.getAddress());
		if(item.hasPhone())
		{
			tvPhone1.setImageResource(R.drawable.call_blue);
			tvPhone2.setText(item.getPhoneNo());
			tvPhone1.setVisibility(View.VISIBLE);
			tvPhone2.setVisibility(View.VISIBLE);

		}
		else{
			tvPhone.setVisibility(View.GONE);
			tvPhone1.setVisibility(View.GONE);
			tvPhone2.setVisibility(View.GONE);
		}
		if(item.hasTiming()){
			tvTime1.setImageResource(R.drawable.clock_blue);
			tvTime2.setText(item.getTiming());
			tvTime1.setVisibility(View.VISIBLE);
			tvTime2.setVisibility(View.VISIBLE);
		}else{
			tvTime.setVisibility(View.GONE);
			tvTime1.setVisibility(View.GONE);
			tvTime2.setVisibility(View.GONE);
		}
		FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabb);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String a;
				int c=0;
				for(int i=0;i<FavouriteActivity.items.size();i++) {
					if (item.getTitle().equals(FavouriteActivity.items.get(i).getTitle())) {
						Snackbar snackbar=Snackbar.make(view, "Removed from favourites", Snackbar.LENGTH_LONG).setAction("Action", null);
						snackbar.show();
						FavouriteActivity.items.remove(i);
						c++;
						break;
					}
				}
				if(c==0) {
					FavouriteActivity.items.add(new Item(item.getImageResourceId(), item.getTitle(), item.getBody(), item.getAddress(), item.getPhoneNo(), item.getTiming()));
					Snackbar snackbar2=Snackbar.make(view, "Added to favourites", Snackbar.LENGTH_LONG).setAction("Action", null);
					View view3=snackbar2.getView();
					view3.getBackground().setColorFilter(getResources().getColor(R.color.theme), PorterDuff.Mode.SRC_IN);
					snackbar2.show();
				}
			}
		});
		return view;
	}
    
    // ItemDetailFragment.newInstance(item)
    public static ItemDetailFragment newInstance(Item item) {
    	ItemDetailFragment fragmentDemo = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }
}
