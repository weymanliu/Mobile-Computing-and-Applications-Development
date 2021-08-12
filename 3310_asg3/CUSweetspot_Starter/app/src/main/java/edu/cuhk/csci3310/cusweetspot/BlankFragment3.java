//Liu Kam Nam 1155109652
package edu.cuhk.csci3310.cusweetspot;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BlankFragment3 extends Fragment {

    public BlankFragment3() {
        // Required empty public constructor
    }

    public static BlankFragment3 newInstance() {
        return new BlankFragment3();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank3, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webview = (WebView) view.findViewById(R.id.webView);
        webview.setWebViewClient(new myWebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        MainActivity2 activity2 = (MainActivity2) getActivity();
        String food = activity2.getFood();
        int product = Integer.parseInt(food);
        if(product==0){
            webview.loadUrl("https://www.google.com/maps/dir/?api=1"+"&origin=22.4181788,114.2073441"+"&destination=22.416335102950256, 114.21093319746173"+"&travelmode=walking");
        }
        else if (product <= 3) {
            webview.loadUrl("https://www.google.com/maps/dir/?api=1"+"&origin=22.4181788,114.2073441"+"&destination=22.41966110010208, 114.20876598211828"+"&travelmode=walking");
        }
        else if (product <=6){
            webview.loadUrl("https://www.google.com/maps/dir/?api=1"+"&origin=22.4181788,114.2073441"+"&destination=22.415838639786624, 114.20763603910056"+"&travelmode=walking");
        }
        else{
            webview.loadUrl("https://www.google.com/maps/dir/?api=1"+"&origin=22.4181788,114.2073441"+"&destination=22.42251706328684, 114.20414718142911"+"&travelmode=walking");
        }
    }

    public class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}