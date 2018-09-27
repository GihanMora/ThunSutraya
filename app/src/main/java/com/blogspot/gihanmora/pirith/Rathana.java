package com.blogspot.gihanmora.pirith;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.blogspot.gihanmora.pirith.MainActivity.mp;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rathana extends Fragment implements View.OnClickListener{
    //static MediaPlayer mp1;
    MediaPlayer bc;
    SeekBar seek_bar1;
    FragmentTransaction fragmentTransaction;
    private static final String TAG = "MainActivity";

    private AdView mAdView;

    public Rathana() {
        // Required empty public constructor
    }
    Handler seekHandler= new Handler();
    Runnable run =new Runnable() {
        @Override
        public void run() {
            seekUpdation();
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_rathana, container, false);

        MobileAds.initialize(getActivity().getApplicationContext(),"ca-app-pub-5202253201958912~4166368789");
        mAdView = (AdView) v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView.loadAd(adRequest);
        Button b2 = (Button) v.findViewById(R.id.button9);
        Button st2 = (Button) v.findViewById(R.id.button11);
        Button pa2 = (Button) v.findViewById(R.id.button12);
        Button stp2 = (Button) v.findViewById(R.id.gohome);
        bc= MediaPlayer.create(getActivity(),R.raw.s);
        seek_bar1=(SeekBar)v.findViewById(R.id.seekBar);
        mp=MediaPlayer.create(getActivity(),R.raw.rathna);
        seekUpdation();
        st2.setOnClickListener(this);
        pa2.setOnClickListener(this);
        stp2.setOnClickListener(this);
        b2.setOnClickListener(this);

        return v;
    }


    public void seekUpdation(){
        seek_bar1.setProgress(mp.getCurrentPosition());
        seekHandler.postDelayed(run,1000);
        seek_bar1.setMax(mp.getDuration());
        seek_bar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seek_bar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seek_bar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seek_bar, int progress, boolean fromUser) {
                if(fromUser){
                    mp.seekTo(progress);
                    seek_bar.setProgress(progress);
                }

            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    mp.seekTo(0);
                    mp.pause();
                    fragmentTransaction=getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container,new Home());
                    fragmentTransaction.commit();

                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.button9){
            bc.start();
            mp.start();

        }
        if(v.getId()==R.id.button11){
            bc.start();
            mp.pause();

        }
        if(v.getId()==R.id.button12){
            bc.start();

            mp.seekTo(0);
            mp.pause();

        }
        if(v.getId()==R.id.gohome){
            bc.start();
            mp.seekTo(0);
            mp.pause();
            fragmentTransaction=getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,new Home());
            fragmentTransaction.commit();

        }

    }

}
