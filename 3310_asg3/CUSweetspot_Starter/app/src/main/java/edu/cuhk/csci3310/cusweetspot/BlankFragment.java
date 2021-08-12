//Liu Kam Nam 1155109652
package edu.cuhk.csci3310.cusweetspot;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor
    }

    private static final int location = 0;
    private static final int route = 1;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        final View rootView =
                inflater.inflate(R.layout.fragment_blank, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);

        MainActivity2 activity2 = (MainActivity2) getActivity();
        int select = Integer.parseInt(activity2.getChoice());
        ((RadioButton)radioGroup.getChildAt(select)).setChecked(true);

        //Set the radioGroup onCheckedChanged listener.
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                switch (index) {
                    case location: // User chose "location"
                        activity2.closeFragment3();
                        activity2.displayFragment2();
                        break;
                    case route: // User chose "route"
                        activity2.closeFragment2();
                        activity2.displayFragment3();
                        break;
                    default:
                        break;
                }
            }
        });
        // Return the View for the fragment's UI. return rootView;
        return rootView;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}