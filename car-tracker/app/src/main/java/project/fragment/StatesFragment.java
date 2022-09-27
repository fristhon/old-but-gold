package project.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.sokhanvar.app.GlobalAppContextSingleton;
import co.sokhanvar.app.R;
import co.sokhanvar.app.SharedPreferenceHelper;
import co.sokhanvar.app.Smodel;
import com.dx.dxloadingbutton.lib.LoadingButton;
import com.github.lzyzsd.circleprogress.DonutProgress;
import de.mateware.snacky.Snacky;

public class StatesFragment extends Fragment {

  static DonutProgress prgOil;
  static TextView tvCar, tvDoor, tvOil, tvAlarm, tvTime, tvDate;
  static String direct;
  static LoadingButton lb;
  static CoordinatorLayout coordinatorLayout;

  static ImageView imgCar, imgDoor, imgAlarm;

  @Nullable
  @Override
  public View onCreateView(
    LayoutInflater inflater,
    @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState
  ) {
    View mView2 = inflater.inflate(R.layout.fragment_states, container, false);

    coordinatorLayout = mView2.findViewById(R.id.coordinatorLayout);

    tvCar = mView2.findViewById(R.id.tvCar);
    tvDoor = mView2.findViewById(R.id.tvDoor);
    tvOil = mView2.findViewById(R.id.tvOil);
    tvAlarm = mView2.findViewById(R.id.tvAlarm);
    tvTime = mView2.findViewById(R.id.tvTime);
    tvDate = mView2.findViewById(R.id.tvDate);
    prgOil = mView2.findViewById(R.id.prgOil);

    imgCar = mView2.findViewById(R.id.imgCar);
    imgDoor = mView2.findViewById(R.id.imgDoor);
    imgAlarm = mView2.findViewById(R.id.imgAlarm);

    SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

    String currentCarState = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "car" + Smodel.getCurrentSelect(),
      "نامشخص"
    );
    String currentDoorState = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "door" + Smodel.getCurrentSelect(),
      "نامشخص"
    );
    String currentAlarmState = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "alarm" + Smodel.getCurrentSelect(),
      "نامشخص"
    );
    tvCar.setText(currentCarState);
    tvDoor.setText(currentDoorState);
    tvAlarm.setText(currentAlarmState);

    if (currentCarState.equals("خودرو روشن است")) {
      imgCar.setImageResource(R.drawable.ic_use_car_onn);
    } else if (currentCarState.equals("خودرو خاموش است")) {
      imgCar.setImageResource(R.drawable.ic_garage);
    }

    if (currentDoorState.equals("درب ها بسته است")) {
      imgDoor.setImageResource(R.drawable.ic_lock_door_use);
    } else if (currentDoorState.equals("درب ها باز است")) {
      imgDoor.setImageResource(R.drawable.ic_use_car_open_doors_black);
    }

    if (currentAlarmState.equals("سیستم امنیتی فعال است")) {
      imgAlarm.setImageResource(R.drawable.ic_use_car_security_close_black);
    } else if (currentAlarmState.equals("سیستم امنیتی غیرفعال است")) {
      imgAlarm.setImageResource(R.drawable.ic_use_car_security_open_black);
    }

    String h = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "hour" + Smodel.getCurrentSelect(),
      "00"
    );
    String m = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "minute" + Smodel.getCurrentSelect(),
      "00"
    );

    String yy = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "year" + Smodel.getCurrentSelect(),
      "yy"
    );

    String mm = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "month" + Smodel.getCurrentSelect(),
      "mm"
    );
    String dd = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "day" + Smodel.getCurrentSelect(),
      "dd"
    );

    tvTime.setText(String.format("%s:%s", h, m));

    tvDate.setText(String.format("%s/%s/%s", yy, mm, dd));

    String oil = sharedPreferenceHelper.getSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "oil" + Smodel.getCurrentSelect(),
      "0"
    );
    prgOil.setProgress(Integer.parseInt(oil));

    lb = mView2.findViewById(R.id.loading_btn);
    lb.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          lb.startLoading(); //start loading

          sendSMS(Smodel.getNumber(), Smodel.getPassword() + "," + "last");
        }
      }
    );

    return mView2;
  }

  public void setValueOnFildes() {
    prgOil.setProgress(Integer.parseInt(Smodel.getOil()));

    SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "lat" + Smodel.getCurrentSelect(),
      Smodel.getLatitude()
    );
    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "long" + Smodel.getCurrentSelect(),
      Smodel.getLongitude()
    );

    lb.loadingSuccessful();

    tvTime.setText(
      String.format("%s:%s", Smodel.getHour(), Smodel.getMinute())
    );
    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "hour" + Smodel.getCurrentSelect(),
      Smodel.getHour()
    );
    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "minute" + Smodel.getCurrentSelect(),
      Smodel.getMinute()
    );

    tvDate.setText(
      String.format(
        "%s/%s/%s",
        Smodel.getYear(),
        Smodel.getMonth(),
        Smodel.getDay()
      )
    );

    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "year" + Smodel.getCurrentSelect(),
      Smodel.getYear()
    );
    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "month" + Smodel.getCurrentSelect(),
      Smodel.getMonth()
    );
    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "day" + Smodel.getCurrentSelect(),
      Smodel.getDay()
    );

    sharedPreferenceHelper.setSharedPreferenceString(
      GlobalAppContextSingleton.getInstance().getApplicationContext(),
      "oil" + Smodel.getCurrentSelect(),
      Smodel.getOil()
    );

    switch (Integer.parseInt(Smodel.getDoor())) {
      case 0:
        tvDoor.setText("درب ها بسته است");
        imgDoor.setImageResource(R.drawable.ic_lock_door_use);

        sharedPreferenceHelper.setSharedPreferenceString(
          GlobalAppContextSingleton.getInstance().getApplicationContext(),
          "door" + Smodel.getCurrentSelect(),
          "درب ها بسته است"
        );

        break;
      case 1:
        tvDoor.setText("درب ها باز است");
        imgDoor.setImageResource(R.drawable.ic_use_car_open_doors_black);
        sharedPreferenceHelper.setSharedPreferenceString(
          GlobalAppContextSingleton.getInstance().getApplicationContext(),
          "door" + Smodel.getCurrentSelect(),
          "درب ها باز است"
        );

        break;
    }

    switch (Integer.parseInt(Smodel.getCar())) {
      case 0:
        tvCar.setText("خودرو روشن است");
        imgCar.setImageResource(R.drawable.ic_use_car_onn);
        sharedPreferenceHelper.setSharedPreferenceString(
          GlobalAppContextSingleton.getInstance().getApplicationContext(),
          "car" + Smodel.getCurrentSelect(),
          "خودرو روشن است"
        );

        break;
      case 1:
        imgCar.setImageResource(R.drawable.ic_garage);
        tvCar.setText("خودرو خاموش است");
        sharedPreferenceHelper.setSharedPreferenceString(
          GlobalAppContextSingleton.getInstance().getApplicationContext(),
          "car" + Smodel.getCurrentSelect(),
          "خودرو خاموش است"
        );
        break;
    }

    switch (Integer.parseInt(Smodel.getAlarm())) {
      case 0:
        tvAlarm.setText("سیستم امنیتی فعال است");
        imgAlarm.setImageResource(R.drawable.ic_use_car_security_close_black);

        sharedPreferenceHelper.setSharedPreferenceString(
          GlobalAppContextSingleton.getInstance().getApplicationContext(),
          "alarm" + Smodel.getCurrentSelect(),
          "سیستم امنیتی فعال است"
        );

        break;
      case 1:
        tvAlarm.setText("سیستم امنیتی غیرفعال است");
        imgAlarm.setImageResource(R.drawable.ic_use_car_security_open_black);
        sharedPreferenceHelper.setSharedPreferenceString(
          GlobalAppContextSingleton.getInstance().getApplicationContext(),
          "alarm" + Smodel.getCurrentSelect(),
          "سیستم امنیتی غیرفعال است"
        );
        break;
    }

    switch (Integer.parseInt(Smodel.getDirection())) {
      case 0:
        direct = "شرق";
        break;
      case 1:
        direct = "شمال شرقی";
        break;
      case 2:
        direct = "شمال";
        break;
      case 3:
        direct = "شمال غربی";
        break;
      case 4:
        direct = "غرب";
        break;
      case 5:
        direct = "جنوب غربی";
        break;
      case 6:
        direct = "جنوب";
        break;
      case 7:
        direct = "جنوب شرقی";
        break;
    }

    String speed = "  " + Smodel.getSpeed() + "  ";
    String direction = " " + direct + " ";

    Snacky
      .builder()
      .setView(coordinatorLayout)
      .setText(
        "اتومبیل شما با سرعت" +
        speed +
        "کیلومتر بر ساعت در جهت" +
        direction +
        "در حال حرکت است."
      )
      .setDuration(Snacky.LENGTH_INDEFINITE)
      .setTextSize(14)
      .centerText()
      .build()
      .show();
  }

  private void sendSMS(String phoneNumber, String message) {
    SmsManager sms = SmsManager.getDefault();
    sms.sendTextMessage(phoneNumber, null, message, null, null);
  }

  public void saveInSharedPreferences() {}
}
