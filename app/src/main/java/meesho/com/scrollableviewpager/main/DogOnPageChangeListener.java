package meesho.com.scrollableviewpager.main;

import android.support.v4.view.ViewPager;

/**
 * Created by root on 10/31/17.
 */

public class DogOnPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
    private int currentPage;

    @Override
    public void onPageSelected(int position) {
        currentPage = position;
    }

    public final int getCurrentPage() {
        return currentPage;
    }
}
