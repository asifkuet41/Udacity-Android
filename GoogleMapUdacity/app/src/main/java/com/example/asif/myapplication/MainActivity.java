package com.example.asif.myapplication;

import android.content.res.Configuration;
import android.graphics.Color;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,OnStreetViewPanoramaReadyCallback{

    GoogleMap m_map;
    StreetViewPanorama m_StreetViewPanorama;
    boolean mapReady = false;

    LatLng office = new LatLng(23.834253, 90.367312);
    LatLng house = new LatLng(23.7903538,90.3741375);
    LatLng busStop = new LatLng(23.8280217,90.3630401);

//    MarkerOptions office;
//    MarkerOptions house;
//    MarkerOptions busStop;

    static final CameraPosition MIRPUR = new CameraPosition.Builder()
            .target(new LatLng(23.8104659,90.327261))
            .zoom(15)
            .bearing(0)
            .tilt(90)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        office = new MarkerOptions().position(new LatLng(23.834253, 90.367312)).title("Office").icon());
//        house = new MarkerOptions().position(new LatLng(23.7903538,90.3741375)).title("House");
//        busStop = new MarkerOptions().position(new LatLng(23.8280217,90.3630401)).title("Bus Stop");

//        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

        StreetViewPanoramaFragment streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.map);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

    }

//    private List<LatLng> getPolyLineList(){
//        List<LatLng> demo = new ArrayList<>();
//        double lat[]={23.860407,23.860376,23.860352,23.86006,23.859436,23.859085,23.858393,23.857634,23.855875,23.854616,23.853613,23.852455,23.850981,23.850134,23.84868,23.848654,23.84861,23.84831,23.848009,23.847857,23.84783,23.847818,23.84771,23.84762,23.847597,23.847616,23.847647,23.84767,23.847658,23.847555,23.847021,23.846254,23.845526,23.844069,23.843262,23.842527,23.841822,23.841196,23.840574,23.840055,23.839556,23.839159,23.838503,23.837807,23.836916,23.836267,23.835546,23.834696,23.834589,23.834326,23.833986,23.833517,23.832878,23.832193,23.831352,23.830469,23.829155,23.82855,23.828253,23.827576,23.826872,23.826525,23.826384,23.826256,23.826181,23.825979,23.825693,23.825075,23.824324,23.823328,23.822519,23.821716,23.820755,23.819738,23.818161,23.816994,
//                23.814665,23.812857,23.812067,23.811325,23.80932,23.808264,23.804037,23.80282,23.801935,23.801086,23.80007,23.798943,23.797449,23.796587,23.795881,23.795135,23.794237,23.793991,23.793777,23.793554,23.793432,23.793396,23.793394,23.793375,23.793375,23.793365,23.793364,23.793352,23.793406,23.793427,23.793432,23.793442,23.793459,23.793432,23.793434,23.793406,23.793442,23.793451,23.793493,23.793596,23.793543,23.793406,23.79339,23.793364,23.79328,23.793203,23.793152,23.793097,23.793009,23.79299,23.792978};
//        double lng[]={90.264061,90.26403,90.264,90.263512,90.262939,90.262688,90.262268,90.261864,90.260902,90.26017,90.259621,90.259209,90.25869,90.258423,90.257927,90.257927,90.257896,90.257759,90.257652,90.257637,90.257637,90.257622,90.257568,90.257576,90.257568,90.257599 ,90.257607,90.257607,90.257652,90.25753 ,90.257317,90.257057,90.256813,90.256615,90.256737,90.256897,90.257118,90.257294,90.2575,90.257668,90.257851,90.257927,90.258125,90.258354,90.258606,90.258812,90.258942,90.259071,90.259087 ,90.259117 ,90.259117,90.259117,90.259071,90.25901,90.258911 ,90.25882,90.25869 ,90.258583,90.258553,90.258484,90.258385 ,90.258369,90.258339,90.258331,90.258324,90.258278 ,90.25824,90.258148 ,90.258018 ,90.257851 ,90.257729 ,90.257629,90.257568 ,90.257545,90.2575 ,90.257446,90.257393,90.257362,90.257484,90.257744 ,90.258873,90.259491,90.261688,90.262291,90.262611,90.262856 ,90.263123,90.263405,90.264076,90.264709,90.265404,90.266289,90.267822,90.268425,90.26902,90.269745 ,90.27047 ,90.270874,90.270927,90.270935,90.270973,90.271049 ,90.271126,90.271454,90.271667,90.271629,90.271606,90.271584,90.271568,90.271568,90.271599,90.27179,90.272148,90.27256,90.272926,90.273506,90.273796,90.273582,90.273537,90.273369,90.272972,90.272491,90.271797,90.271278,90.270905,90.270653,90.270332};
//        for(int i=0;i<lat.length-1;i++){
//
//            Location a = new Location("a");
//            a.setLatitude(lat[i]);
//            a.setLongitude(lng[i]);
//            Location b = new Location("b");
//            b.setLatitude(lat[i+1]);
//            b.setLongitude(lng[i+1]);
//
//            if(a.distanceTo(b)>10)
//                demo.add(new LatLng(lat[i],lng[i]));
//        }
//
//        return demo;
//
//    }
//
//
//    private void createRoute() {
//        if (bangaloreRoute == null) {
//            bangaloreRoute = new ArrayList<>();
//        } else {
//            bangaloreRoute.clear();
//        }
//
//        bangaloreRoute = getPolyLineList();
//    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
//            @Override
//            public void onMapLoaded() {
//                LatLngBounds.Builder builder = new LatLngBounds.Builder();
//                builder.include(POINT_A);
//                builder.include(POINT_B);
//                LatLngBounds bounds = builder.build();
//                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 200);
//
//                mMap.moveCamera(cu);
//               // mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
//
//                startAnim();
//            }
//        });
        m_map = googleMap;
        flyTo(MIRPUR);
        mapReady = true;
        m_map.addCircle(new CircleOptions().center(house).radius(100).strokeColor(Color.BLUE));
        m_map.addCircle(new CircleOptions().center(office).radius(100).strokeColor(Color.BLUE));
        m_map.addCircle(new CircleOptions().center(busStop).radius(1000).strokeColor(Color.BLUE).fillColor(Color.argb(64,0,255,0)));

//        m_map.addMarker(office);
//        m_map.addMarker(house);
//        m_map.addMarker(busStop);


    }

    private void flyTo(CameraPosition target){
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        m_StreetViewPanorama = streetViewPanorama;
        m_StreetViewPanorama.setPosition(new LatLng(36.0579667,-112.1430996));
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
        m_StreetViewPanorama.animateTo(camera,1000);
    }

//    private void startAnim(){
//        if(mMap != null) {
//            MapAnimator.getInstance().animateRoute(mMap, bangaloreRoute);
//        } else {
//            Toast.makeText(getApplicationContext(), "Map not ready", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public void resetAnimation(View view){
//        startAnim();
//    }
}
