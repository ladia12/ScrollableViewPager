package meesho.com.scrollableviewpager.main;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import meesho.com.scrollableviewpager.R;

/**
 * Created by root on 10/30/17.
 */

public class DogViewPagerAdapter extends PagerAdapter {

    private int PAGE_COUNT = 0;
    private ArrayList<String> mData = new ArrayList<>();
    private ArrayList<String> mUrls = DogUrlProvider.getDogUrls();
    private int MAX_PAGE = mUrls.size();

    private Activity activity;

    public DogViewPagerAdapter(Activity activity) {
        this.activity = activity;
    }


    public void add() {
        if(PAGE_COUNT < MAX_PAGE) {
            mData.add(mUrls.get(PAGE_COUNT++));
            notifyDataSetChanged();

        }
    }

    public void remove() {
        if(PAGE_COUNT > 0) {
            mData.remove(mUrls.get(--PAGE_COUNT));
            notifyDataSetChanged();
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(activity);
        View itemView = inflater.inflate(R.layout.fragment_dog, container, false);

        ImageView imageView = itemView.findViewById(R.id.image);
        TextView textView = itemView.findViewById(R.id.index);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        Picasso.with(activity).load(mData.get(position)).resize(width,0).into(imageView);
        textView.setText("Index: " + position);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}
