//Liu Kam Nam 1155109652
package edu.cuhk.csci3310.cusweetspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    // Resource ID for the dessert images
    static int[] dissertImageIds = {
            R.drawable.p0_frozen_yogur_milano_fresh_cafe,
            R.drawable.p1_cake_med_can,
            R.drawable.p1_lemon_pie_med_can,
            R.drawable.p1_peach_crisp_med_can,
            R.drawable.p2_cheese_cake_orchid_lodge,
            R.drawable.p2_fresh_toast_orchid_lodge,
            R.drawable.p2_hokkaido_milk_pudding_orchid_lodge,
            R.drawable.p3_chocolate_fondue_cafe_tolo,
            R.drawable.p3_toast_jenga_cafe_tolo,
            R.drawable.p3_waffle_cafe_tolo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up GridView and its adaptor
        GridView gallery = (GridView) findViewById(R.id.gridview);
        ImageAdaptor mImageAdaptor = new ImageAdaptor(this, dissertImageIds);
        gallery.setAdapter(mImageAdaptor);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}