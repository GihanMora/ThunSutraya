package com.blogspot.gihanmora.pirith;

import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    static MediaPlayer mp;
    private AdView mAdView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    Button b1;
    Button b2;
    Button b3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(),"ca-app-pub-5202253201958912~4166368789");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);


        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Rathana());
                        fragmentTransaction.commit();
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Mangala());
                        fragmentTransaction.commit();
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Meththa());
                        fragmentTransaction.commit();
                    }
                }
        );
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.add(R.id.main_container,new Home());
        //fragmentTransaction.commit();

        navigationView =(NavigationView)findViewById(R.id.nevigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                switch (item.getItemId()){
                    case R.id.home:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Home());
                        if(mp!=null){mp.start();
                            mp.seekTo(0);
                            mp.pause();}
                        fragmentTransaction.commit();

                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.rathana:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Rathana());
                        fragmentTransaction.addToBackStack("Rathna");
                        if(mp!=null){mp.start();
                            mp.seekTo(0);
                            mp.pause();}
                        fragmentTransaction.commit();

                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.mangala:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Mangala());
                        fragmentTransaction.addToBackStack("මහා මංගල සූත්රය");
                        if(mp!=null){mp.start();
                            mp.seekTo(0);
                            mp.pause();}
                        fragmentTransaction.commit();

                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.meththa:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Meththa());
                        fragmentTransaction.addToBackStack("Meththa");
                        if(mp!=null){mp.start();
                        mp.seekTo(0);
                        mp.pause();}
                         fragmentTransaction.commit();

                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.exit:
                        System.exit(0);
                        break;


                }
                return false;
            }

        });
       }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }




}
