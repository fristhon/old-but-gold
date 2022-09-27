package co.sokhanvar.app;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.RECEIVE_SMS;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import project.fragment.MapFragment;
import project.fragment.RemoteFragment;
import project.fragment.StatesFragment;
import project.widget.UTab;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyMainActivity extends AppCompatActivity {

  LocationManager locationManager;

  Context context;

  Handler handler;

  public static final int RequestPermissionCode = 2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tab);

    handler = new Handler();

    GlobalAppContextSingleton.getInstance().initialize(this);

    context = MyMainActivity.this;

    final UTab tab = new UTab(this, R.id.viewPager, R.id.tabLayout);
    tab.add(MapFragment.class, "نقشه", R.drawable.ic_location_on_black_24dp);
    tab.add(
      StatesFragment.class,
      "وضعیت",
      R.drawable.ic_lightbulb_outline_black_24dp
    );
    tab.add(
      RemoteFragment.class,
      "کنترل",
      R.drawable.ic_directions_car_black_24dp
    );

    ConnectivityManager conMgr = (ConnectivityManager) getSystemService(
      Context.CONNECTIVITY_SERVICE
    );
    NetworkInfo info = null;
    if (conMgr != null) {
      info = conMgr.getActiveNetworkInfo();
    }

    if (info != null && info.isConnected()) {
    } else {
      Toast
        .makeText(
          getApplicationContext(),
          "برای استفاده از نقشه دسترسی به اینترنت لازم است",
          Toast.LENGTH_LONG
        )
        .show();
    }
    // internet is not there.

    // If All permission is enabled successfully then this block will execute.
    if (CheckingPermissionIsEnabledOrNot()) {
      /*
      Toast.makeText(MyMainActivity.this, "مجوز ها با موفقیت دریافت شد", Toast.LENGTH_LONG).show();

*/

    }
    // If, If permission is not enabled then else condition will execute.
    else {
      //Calling method to enable permission.
      RequestMultiplePermission();
    }
  }

  private void RequestMultiplePermission() {
    // Creating String Array with Permissions.
    ActivityCompat.requestPermissions(
      MyMainActivity.this,
      new String[] { ACCESS_FINE_LOCATION, RECEIVE_SMS },
      RequestPermissionCode
    );
  }

  // Calling override method.
  @Override
  public void onRequestPermissionsResult(
    int requestCode,
    String permissions[],
    int[] grantResults
  ) {
    switch (requestCode) {
      case RequestPermissionCode:
        if (grantResults.length > 0) {
          boolean LocationPermission =
            grantResults[0] == PackageManager.PERMISSION_GRANTED;
          boolean ReceiveSMSPermission =
            grantResults[1] == PackageManager.PERMISSION_GRANTED;

          if (LocationPermission && ReceiveSMSPermission) {
            Toast
              .makeText(
                MyMainActivity.this,
                "مجوز ها تایید شد",
                Toast.LENGTH_LONG
              )
              .show();
          } else {
            Toast
              .makeText(
                MyMainActivity.this,
                "خطا در دریافت مجوز",
                Toast.LENGTH_LONG
              )
              .show();
          }
        }

        break;
    }
  }

  public boolean CheckingPermissionIsEnabledOrNot() {
    int FirstPermissionResult = ContextCompat.checkSelfPermission(
      getApplicationContext(),
      ACCESS_FINE_LOCATION
    );
    int SecondPermissionResult = ContextCompat.checkSelfPermission(
      getApplicationContext(),
      RECEIVE_SMS
    );

    return (
      FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
      SecondPermissionResult == PackageManager.PERMISSION_GRANTED
    );
  }

  public void getLocation() {
    if (
      ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
      ) !=
      PackageManager.PERMISSION_GRANTED &&
      ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
      ) !=
      PackageManager.PERMISSION_GRANTED
    ) {
      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
      return;
    }
    final Location location = locationManager.getLastKnownLocation(
      LocationManager.NETWORK_PROVIDER
    );

    if (location != null) {
      Smodel.setNet(true);

      Double latitude = location.getLatitude();
      Double longitude = location.getLongitude();

      Smodel.setUserLatitude(latitude);
      Smodel.setUserLongitude(longitude);
    }
  }

  private void showDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(MyMainActivity.this);

    builder.setMessage(
      ("موقعیت مکانی شما غیرفعال است.آیا مایلید آن را فعال کنید؟")
    );
    builder.setPositiveButton(
      "بله",
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          Intent intent3 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
          startActivity(intent3);
        }
      }
    );

    builder.setNegativeButton(
      "خیر",
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          Toast
            .makeText(
              getApplicationContext(),
              "برای استفاده از نقشه باید موقعیت یاب را فعال کنید.",
              Toast.LENGTH_LONG
            )
            .show();
        }
      }
    );

    AlertDialog dialog = builder.create();
    dialog.show();
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  private void checkGps() {
    //Check GPS isOnOrOff

    final LocationManager manager = (LocationManager) context.getSystemService(
      Context.LOCATION_SERVICE
    );

    if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
      Toast.makeText(context, "GPS is disable!", Toast.LENGTH_LONG).show();

      showDialog();
    } else {
      Toast.makeText(context, "GPS is Enable!", Toast.LENGTH_LONG).show();
      locationManager =
        (LocationManager) getSystemService(Context.LOCATION_SERVICE);
      getLocation();
    }
  }
}
