package meesho.com.scrollableviewpager.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import meesho.com.scrollableviewpager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DogFragment extends Fragment {


    @BindView(R.id.index) TextView mIndexTv;
    @BindView(R.id.image) ImageView mImage;

    public DogFragment() {
        // Required empty public constructor
    }

    public static DogFragment newInstance(int position, String url) {

        Bundle args = new Bundle();
        args.putInt("index", position);
        args.putString("url", url);

        DogFragment fragment = new DogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dog, container, false);
        ButterKnife.bind(this,view);

        int index = getArguments().getInt("index");
        String url = getArguments().getString("url");

        mIndexTv.setText("Index: " + index);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;


        return view;
    }

}
