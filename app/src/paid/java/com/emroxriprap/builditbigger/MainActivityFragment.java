package com.emroxriprap.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    @BindView(R.id.b_tell_joke)
    Button mTellJoke;
    private Activity mActivity;


    public interface JokeRequestListener {
        void requestMade();
    }


    public MainActivityFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,root);

        return root;
    }

    @OnClick(R.id.b_tell_joke)
    void tellJoke(){

        //change fragment to loading fragment
        try{
            ((JokeRequestListener)mActivity).requestMade();
        }catch (ClassCastException exception){
            Log.e(LOG_TAG,"Activity not implenting callback");
        }

        new JokesTask(getActivity()).execute();
    }
}
