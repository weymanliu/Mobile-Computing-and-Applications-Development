//Name :Liu Kam Nam
//SID: 1155109652


package edu.cuhk.csci3310.fabpasscode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int mPasscode;
    private TextView mShowPasscode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowPasscode = (TextView) findViewById(R.id.passcodeView);
    }

    private int i=1;
    private String buttonText;

    public void updatePasscode(View view) {
        Button button = (Button) view;
        if (i==1) {
            buttonText = button.getText().toString();
            i++;
        }
        else {
            String buttonText2 = button.getText().toString();
            buttonText += buttonText2;
        }
        mShowPasscode.setText(buttonText);
    }
    /* To read user input and show it on screen*/


    public void check(View view) {
        cal(); /* To check is the passcode correct or not*/
        if (in==0){
            Toast toast = Toast.makeText(this, "Bingo!", Toast.LENGTH_SHORT);
            toast.show();
            ImageView image = (ImageView)findViewById(R.id.hidden_bird);
            image.setVisibility(1);
            Button button = (Button)findViewById(R.id.unlock);
            button.setText("Enjoy");
            disableButtons();
        } /* steps to do if the passcode entered is correct, show correct message, show hidden image, change unlock button to enjoy, disable all buttons*/
        else{
            Toast toast = Toast.makeText(this,  "Passcode Incorrect", Toast.LENGTH_SHORT);
            toast.show();
            buttonText="Passcode";
            i=1;
            in=0;
            mShowPasscode.setText("Passcode");
        } /* steps to do if the passcode entered is incorrect, show wrong message, reset the environment*/
    }

    private int in=0;
    private void cal(){
        int[]store=new int[10];
        int[]pw=new int[]{1,1,5,5,1,0,9,6,5,2};
        int x=0;

        if(buttonText.length()==11) {
            for (int i = 0; i < 10; i++) {
                char a = buttonText.charAt(i);
                store[i] = Character.getNumericValue(a);
                if (store[i] != pw[i]) {
                    in++;
                }
            }
            /* To check is the passcode entered same as my SID*/

            for (int j = 1; j <= 9; j += 2) {
                if (store[j] * 2 >= 10) {
                    store[j] = store[j] * 2 - 10 + 1;
                } else {
                    store[j] = store[j] * 2;
                }
            }
            for (int k = 0; k < 10; k++) {
                x += store[k];
            }
            x = x * 9 % 10;
            /* To calculate the Luhn check digit of the pass code*/

            char y = buttonText.charAt(10);
            int z = Character.getNumericValue(y);
            if (x != z) {
                in++;
            }
            /* To check is the passcode Luhn check digit is correct or not*/
        }
        else{
            in++;
        }
}
    private void disableButtons() {
        Button button = (Button)findViewById(R.id.button1);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button2);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button3);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button4);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button5);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button6);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button7);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button8);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button9);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.button0);
        button.setEnabled(false);
        button = (Button)findViewById(R.id.unlock);
        button.setEnabled(false);
    }
    /* disable all the buttons*/
}