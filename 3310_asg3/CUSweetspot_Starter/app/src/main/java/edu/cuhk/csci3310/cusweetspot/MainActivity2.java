//Liu Kam Nam 1155109652
package edu.cuhk.csci3310.cusweetspot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    String choice,food;
    private boolean isFragmentDisplayed = false;
    private boolean isFragmentDisplayed2 = false;
    private boolean isFragmentDisplayed3 = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        choice = getIntent().getStringExtra("choice");
        food = getIntent().getStringExtra("food");
        //Toast.makeText(this, choice+"+"+food, Toast.LENGTH_LONG).show();
        int button = Integer.parseInt(choice);
        displayFragment();
        if(button==0) {
            displayFragment2();
        }
        else{
            displayFragment3();
        }
    }
    public String getChoice() {return choice;}
    public String getFood() {
        return food;
    }

    public void displayFragment() {
        BlankFragment blankFragment = BlankFragment.newInstance();
        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragment, blankFragment).addToBackStack(null).commit();
        // Set boolean flag to indicate fragment is open.
        isFragmentDisplayed = true;
    }
    public void displayFragment2() {
        BlankFragment2 blankFragment2 = BlankFragment2.newInstance();
        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragment2, blankFragment2).addToBackStack(null).commit();
        // Set boolean flag to indicate fragment is open.
        isFragmentDisplayed2 = true;
    }
    public void closeFragment2() {
        // Get the FragmentManager.
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Check to see if the fragment is already showing.
        BlankFragment2 blankFragment2 = (BlankFragment2) fragmentManager.findFragmentById(R.id.fragment2);
        if (blankFragment2 != null) {
            // Create and commit the transaction to remove the fragment.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(blankFragment2).commit();
        }
        // Set boolean flag to indicate fragment is closed.
        isFragmentDisplayed2 = false;
    }
    public void displayFragment3() {
        BlankFragment3 blankFragment3 = BlankFragment3.newInstance();
        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragment3, blankFragment3).addToBackStack(null).commit();
        // Set boolean flag to indicate fragment is open.
        isFragmentDisplayed3 = true;
    }
    public void closeFragment3() {
        // Get the FragmentManager.
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Check to see if the fragment is already showing.
        BlankFragment3 blankFragment3 = (BlankFragment3) fragmentManager.findFragmentById(R.id.fragment3);
        if (blankFragment3 != null) {
            // Create and commit the transaction to remove the fragment.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(blankFragment3).commit();
        }
        // Set boolean flag to indicate fragment is closed.
        isFragmentDisplayed3 = false;
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}