package edu.cuhk.csci3310.cublossom;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    private TextView flowerName;
    private TextView familyEntry;
    private TextView number;
    private ImageView Fpic;
    private String str1,str2,str3,str4,str5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        flowerName = findViewById(R.id.name);
        str1 = intent.getStringExtra("FName");
        flowerName.setText(str1);

        familyEntry = findViewById(R.id.family);
        str2 = intent.getStringExtra("FEntry");
        familyEntry.setText(str2);

        number = findViewById(R.id.abundance);
        str3 = intent.getStringExtra("Abd");
        if(str3.equals("3")){
            number.setText("hill-full");
        }
        else if(str3.equals("2")){
            number.setText("clustered");
        }
        else if(str3.equals("1")){
            number.setText("scattered");
        }

        Fpic = findViewById(R.id.pic);
        str4 = intent.getStringExtra("photo");
        Uri uri = Uri.parse(str4);
        Fpic.setImageURI(uri);

        str5 = intent.getStringExtra("pos");
    }

    public void minus1(View view) {
        if(number.getText().equals("hill-full")){
            number.setText("clustered");
            return;
        }
        else if(number.getText().equals("clustered")){
            number.setText("scattered");
            return;
        }
    }
    public void plus1(View view) {
        if(number.getText().equals("scattered")){
            number.setText("clustered");
            return;
        }
        else if(number.getText().equals("clustered")){
            number.setText("hill-full");
            return;
        }
    }
    public void cancel1(View view) {
        flowerName.setText(str1);
        familyEntry.setText(str2);
        if(str3.equals("3")){
            number.setText("hill-full");
        }
        else if(str3.equals("2")){
            number.setText("clustered");
        }
        else if(str3.equals("1")){
            number.setText("scattered");
        }
    }
    public void save1(View view) {
        /*
        String a = Integer.parseInt(str5);
        String b = str4.replaceAll("android.resource://edu.cuhk.csci3310.cublossom/drawable/", "");;
        String c = (String) flowerName.getText();
        String d = (String) familyEntry.getText();
        String e = (String) number.getText();
        renewlist(a,b,c,d,e);
        */
        //in list.java
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
    //incorporate retaining states in a config change, such as device rotation
}