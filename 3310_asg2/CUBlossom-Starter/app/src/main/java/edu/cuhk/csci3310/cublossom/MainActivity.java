/* Liu Kam Nam 1155109652*/
package edu.cuhk.csci3310.cublossom;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private FlowerListAdapter mAdapter;

    // Initially a list storing image path
    private LinkedList<String> mImagePathList = new LinkedList<>();
    private String mDrawableFilePath = "android.resource://edu.cuhk.csci3310.cublossom/drawable/";
    // You may define more data members as needed
    // ... Rest of MainActivity code ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readData();
        //genlist(); //in list.java
        //newlist(); //in list.java

        // Initially put random data into the image list, modify to pass correct info read from CSV
        //int num = (int) (Math.random()*5)+1;
        for(int i=1; i<=10; i++) {
            mImagePathList.addLast(mDrawableFilePath + flowers.get(i).getFilename());
        }

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed,
        // initially just a list of image path
        // Update as needed...
        mAdapter = new FlowerListAdapter(this, mImagePathList, flowers);

        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private List<Flowers> flowers=new ArrayList<>();
    private void readData() {
        InputStream is = getResources().openRawResource(R.raw.cu_flowers);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line="";
        try{
            while((line=reader.readLine())!=null) {
                String[] tokens = line.split(",");
                Flowers flower = new Flowers();
                flower.setFilename(tokens[0]);
                flower.setFlower_name(tokens[1]);
                flower.setGenus(tokens[2]);
                flower.setRichness(tokens[3]);
                flowers.add(flower);

            }
        } catch(IOException e){
            Log.wtf("MyActivity", "Error reading data file on line"+ line, e);
            e.printStackTrace();
        }

    }
    // read CSV
    // Overriding extra callbacks, e.g. onResume(), onActivityResult() etc. here


}
