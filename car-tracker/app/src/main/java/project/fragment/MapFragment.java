package project.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;
import co.sokhanvar.app.R;
import co.sokhanvar.app.Smodel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

  public GoogleMap mMap;
  MarkerOptions markerOptions;
  Marker marker;

  Handler handler;

  ToggleButton tglMap;
  ImageView carNav;

  Switch mapSwitch;

  @Nullable
  @Override
  public View onCreateView(
    LayoutInflater inflater,
    @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState
  ) {
    View mapViewRoot = inflater.inflate(
      R.layout.fragment_map,
      container,
      false
    );
    handler = new Handler();
    markerOptions = new MarkerOptions();

    SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
      .findFragmentById(R.id.map_me);
    mapFragment.getMapAsync(this);

    mapSwitch = mapViewRoot.findViewById(R.id.mapSwitch);

    carNav = mapViewRoot.findViewById(R.id.carNav);
    carNav.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (Smodel.getSms()) {
            LatLng carPosition = new LatLng(
              Double.parseDouble(Smodel.getLatitude()),
              Double.parseDouble(Smodel.getLongitude())
            );

            markerOptions.position(carPosition).title("موقعیت خودرو شما");
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(carPosition, 16));
          } else {
            Toast
              .makeText(getActivity(), "نیاز به بروزرسانی", Toast.LENGTH_LONG)
              .show();
          }
        }
      }
    );

    return mapViewRoot;
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    mapSwitch.setOnCheckedChangeListener(
      new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(
          CompoundButton buttonView,
          boolean isChecked
        ) {
          if (mapSwitch.isChecked()) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
          } else {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
          }
        }
      }
    );
    /*LatLng iran = new LatLng(32.4279, 53.6880);


    markerOptions.position(iran).title("need update");
    mMap.addMarker(markerOptions);
    mMap.moveCamera(CameraUpdateFactory.newLatLng(iran));
*/

    /*final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {


        while (true) {

          try {

            markerOptions = new MarkerOptions();

            handler.post(new Runnable() {
              @Override
              public void run() {

                if (Smodel.getNet()) {


                  LatLng userPosition = new LatLng(Smodel.getUserLatitude(), Smodel.getUserLongitude());

                  markerOptions.position(userPosition).title("test");
                  mMap.addMarker(markerOptions);
                  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userPosition, 18));


                } else {


                  LatLng iran = new LatLng(32.4279, 53.6880);


                  markerOptions.position(iran).title("need update");
                  mMap.addMarker(markerOptions);
                  mMap.moveCamera(CameraUpdateFactory.newLatLng(iran));


                }


              }
            });


            Thread.sleep(5000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }


        }


      }


    });


    thread.start();*/
  }
}
