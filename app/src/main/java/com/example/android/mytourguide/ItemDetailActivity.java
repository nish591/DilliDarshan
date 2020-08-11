package com.example.android.mytourguide;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class ItemDetailActivity extends FragmentActivity {
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
