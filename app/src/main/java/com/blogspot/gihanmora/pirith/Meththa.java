package com.blogspot.gihanmora.pirith;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.blogspot.gihanmora.pirith.MainActivity.mp;


/**
 * A simple {@link Fragment} subclass.
 */
public class Meththa extends Fragment  implements  View.OnClickListener {
    MediaPlayer bc;
    SeekBar seek_bar;
    FragmentTransaction fragmentTransaction1;
    private static final String TAG = "MainActivity";

    private AdView mAdView1;
    public Meththa() {
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

        View v1 = inflater.inflate(R.layout.fragment_meththa, container, false);

        MobileAds.initialize(getActivity().getApplicationContext(),"ca-app-pub-5202253201958912~4166368789");
        mAdView1 = (AdView) v1.findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView1.loadAd(adRequest);

        Button b = (Button) v1.findViewById(R.id.button);
        Button st = (Button) v1.findViewById(R.id.button4);
        Button pa = (Button) v1.findViewById(R.id.button7);
        Button stp = (Button) v1.findViewById(R.id.button8);
        bc= MediaPlayer.create(getActivity(),R.raw.s);
        seek_bar=(SeekBar)v1.findViewById(R.id.seekBar4);
        mp=MediaPlayer.create(getActivity(),R.raw.meththa);
        seekUpdation();
        st.setOnClickListener(this);
        pa.setOnClickListener(this);
        stp.setOnClickListener(this);
        b.setOnClickListener(this);

        return v1;
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

                    fragmentTransaction1=getFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.main_container,new Home());
                    fragmentTransaction1.commit();

                    return true;
                }
                return false;
            }
        });
    }
    public void seekUpdation(){
        seek_bar.setProgress(mp.getCurrentPosition());
        seekHandler.postDelayed(run,1000);
        seek_bar.setMax(mp.getDuration());
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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
    public void onClick(View v) {


        if(v.getId()==R.id.button4){
            bc.start();
            mp.start();

        }
        if(v.getId()==R.id.button7){
            bc.start();
            mp.pause();

        }
        if(v.getId()==R.id.button8){
            bc.start();

            mp.seekTo(0);
            mp.pause();

        }
        if(v.getId()==R.id.button){
            bc.start();
            mp.seekTo(0);
            mp.pause();
            fragmentTransaction1=getFragmentManager().beginTransaction();
            fragmentTransaction1.replace(R.id.main_container,new Home());
            fragmentTransaction1.commit();

        }

    }






}
