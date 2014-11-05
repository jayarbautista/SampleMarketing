package com.example.marketingsdksample;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public static class PlaceholderFragment extends Fragment {

        private Button pressButton;
        
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.main_fragment, container,
                    false);

            Chartboost.startWithAppId(this.getActivity(), getResources()
                    .getString(R.string.appId),
                    getResources().getString(R.string.appSignature));

            pressButton = (Button) rootView.findViewById(R.id.button1);
            pressButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Chartboost.showInterstitial(CBLocation.LOCATION_LEADERBOARD);
                }
            });

            return rootView;
        }

        @Override
        public void onStart() {
            super.onStart();
            Chartboost.onStart(this.getActivity());
        }

        @Override
        public void onResume() {
            super.onResume();
            Chartboost.onResume(this.getActivity());
        }

        @Override
        public void onPause() {
            super.onPause();
            Chartboost.onPause(this.getActivity());
        }

        @Override
        public void onStop() {
            super.onStop();
            Chartboost.onStop(this.getActivity());
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Chartboost.onDestroy(this.getActivity());
        }
    }

    //Makes ad request and loads ad
    public static class AdFragment extends Fragment {

        private AdView mAdView;

        public AdFragment() {
        }

        @Override
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);

            mAdView = (AdView) getView().findViewById(R.id.adView);

            AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
            mAdView.loadAd(adRequest);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            return inflater.inflate(R.layout.ad_fragment, container, false);
        }
    }
}
