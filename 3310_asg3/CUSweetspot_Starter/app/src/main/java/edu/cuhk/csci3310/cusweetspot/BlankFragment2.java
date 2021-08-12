//Liu Kam Nam 1155109652
package edu.cuhk.csci3310.cusweetspot;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BlankFragment2 extends Fragment {

    public BlankFragment2() {
        // Required empty public constructor
    }

    public static BlankFragment2 newInstance() {
        return new BlankFragment2();
    }

    MapView mMapView;
    private GoogleMap googleMap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blank2, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                MainActivity2 activity2 = (MainActivity2) getActivity();
                String food = activity2.getFood();
                int product = Integer.parseInt(food);

                if(product==0){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.416335102950256, 114.21093319746173);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Frozen Yogur").snippet("Milano Fresh Cafe"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }

                else if(product==1){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.41966110010208, 114.20876598211828);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Cake").snippet("Med Can"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else if(product==2){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.41966110010208, 114.20876598211828);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Lemon Pie").snippet("Med Can"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else if(product==3){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.41966110010208, 114.20876598211828);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Peach Crisp").snippet("Med Can"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else if(product==4){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.415838639786624, 114.20763603910056);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Cheese Cake").snippet("Orchid Lodge"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else if(product==5){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.415838639786624, 114.20763603910056);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Fresh Toast").snippet("Orchid Lodge"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else if(product==6){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.415838639786624, 114.20763603910056);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Hokkaido Milk Pudding").snippet("Orchid Lodge"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else if(product==7){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.42251706328684, 114.20414718142911);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Chocolate Fondue").snippet("Cafe Tolo"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else if(product==8){
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.42251706328684, 114.20414718142911);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Toast Jenga").snippet("Cafe Tolo"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
                else{
                    // For dropping a marker at a point on the Map
                    LatLng place = new LatLng(22.42251706328684, 114.20414718142911);
                    googleMap.addMarker(new MarkerOptions().position(place).title("Waffle").snippet("Cafe Tolo"));
                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(place).zoom(20).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}

