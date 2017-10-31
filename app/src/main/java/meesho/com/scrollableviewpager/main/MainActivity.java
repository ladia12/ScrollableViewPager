package meesho.com.scrollableviewpager.main;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import meesho.com.scrollableviewpager.R;

public class MainActivity extends AppCompatActivity {

    private static final long DELAY_MS = 4000;
    private static final long PERIOD_MS = 4000;

    private int currentPage = 0;
    @BindView(R.id.viewpager) ViewPager mViewPager;
    private DogViewPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAdapter = new DogViewPagerAdapter(this);
        mViewPager.setAdapter(mAdapter);
        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {

            public void run() {
                currentPage = mViewPager.getCurrentItem();
                if (mViewPager.getCurrentItem() == mAdapter.getCount() - 1) {
                    mViewPager.setCurrentItem(0, true);
                } else {
                    mViewPager.setCurrentItem(++currentPage, true);
                }

            }
        };

        new Timer().schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

    }

    @OnClick(R.id.addButton) public void onAddButtonClicked(View view) {

        mAdapter.add();
        mViewPager.setCurrentItem(mAdapter.getCount() -1, true);
    }

    @OnClick(R.id.removeButton) public void onRemoveButtonClicked(View view) {

        mAdapter.remove();
        mViewPager.setAdapter(null);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(mAdapter.getCount() -1, true);
    }
}
