package com.blogspot.gihanmora.pirith;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements View.OnClickListener{

    TextView t;
    Button myButton;
    public Home() {
        // Required empty public constructor
    }



    public View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedinstanceState) {
        View myView = inflater.inflate(R.layout.fragment_home, container, false);
        myButton = (Button) myView.findViewById(R.id.button11);
        myButton.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View v) {

    }

}
