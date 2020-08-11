package com.example.android.mytourguide;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private int[] imageResId = { R.drawable.round_location_on_white_24dp, R.drawable.baseline_restaurant_white_24dp,R.drawable.baseline_shopping_cart_white_24dp,R.drawable.baseline_hotel_white_24dp };
    private int[] iconColor = { R.color.attractions,R.color.food,R.color.shopping,R.color.hotels };
    private Context mContext;
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(getPageTitle(position));
        ImageView img = (ImageView) v.findViewById(R.id.imgView);
        img.setImageResource(imageResId[position]);
        RelativeLayout rl= (RelativeLayout) v.findViewById(R.id.icon_back);
        rl.setBackgroundResource(iconColor[position]);
        RelativeLayout r= (RelativeLayout) v.findViewById(R.id.icon_round);
        r.setClipToOutline(true);
        return v;
    }
    @Override
    public Fragment getItem(int pos) {
        if (pos == 0) {
            return new AttractionsFragment();
        } else if (pos == 1){
            return new FoodFragment();
        } else if (pos == 2){
            return new ShoppingFragment();
        } else {
            return new HotelsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return mContext.getString(R.string.category_attractions);
        } else if (position == 1) {
            return mContext.getString(R.string.category_food);
        } else if (position == 2) {
            return mContext.getString(R.string.category_shopping);
        } else {
            return mContext.getString(R.string.category_hotels);
        }
    }
}