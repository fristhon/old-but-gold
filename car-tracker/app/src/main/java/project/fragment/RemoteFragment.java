package project.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import co.sokhanvar.app.GlobalAppContextSingleton;
import co.sokhanvar.app.R;
import co.sokhanvar.app.Smodel;
import com.github.zagum.switchicon.SwitchIconView;
import info.hoang8f.widget.FButton;

public class RemoteFragment extends Fragment {

  String alarmString;
  String carString;
  String smsCommand;

  String dialogAlarmString;
  String dialogCarString;

  @Nullable
  @Override
  public View onCreateView(
    LayoutInflater inflater,
    @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState
  ) {
    View rView = inflater.inflate(R.layout.fragment_remote, container, false);

    final SwitchIconView switchSecurity;
    final SwitchIconView switchCar;

    TextView tvName;
    TextView tvSim;

    final ToggleButton tglSecurity = rView.findViewById(R.id.tglSecurity);
    final ToggleButton tglCar = rView.findViewById(R.id.tglCar);
    FButton fButton = rView.findViewById(R.id.fButton);

    switchSecurity = rView.findViewById(R.id.switchSecurity);
    switchCar = rView.findViewById(R.id.switchCar);

    tvName = rView.findViewById(R.id.tvName);
    tvName.setText(Smodel.getLocationName());

    tvSim = rView.findViewById(R.id.tvSim);
    tvSim.setText(Smodel.getNumber());

    tglSecurity.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          switchSecurity.switchState();
        }
      }
    );

    tglCar.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          switchCar.switchState();
        }
      }
    );

    fButton.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (tglSecurity.isChecked()) {
            dialogAlarmString = " " + "??????????????" + " ";

            alarmString = "1";
          } else {
            dialogAlarmString = " " + "????????" + " ";

            alarmString = "0";
          }

          if (tglCar.isChecked()) {
            dialogCarString = " " + "??????????" + " ";

            carString = "1";
          } else {
            dialogCarString = " " + "????????" + " ";

            carString = "0";
          }

          smsCommand = alarmString + carString;

          showDialog();
        }
      }
    );

    return rView;
  }

  private void showDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(
      GlobalAppContextSingleton.getInstance().getApplicationContext()
    );

    builder.setMessage(
      (
        "?????? ???????????????? ?????????? ????" +
        dialogCarString +
        "?? ?????????? ???????????? ????" +
        dialogAlarmString +
        "??????????"
      )
    );
    builder.setPositiveButton(
      "??????",
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          sendSMS(Smodel.getNumber(), Smodel.getPassword() + "," + smsCommand);

          Toast
            .makeText(
              GlobalAppContextSingleton.getInstance().getApplicationContext(),
              "???????? ???? ???????????? ?????????? ????",
              Toast.LENGTH_LONG
            )
            .show();
        }
      }
    );

    builder.setNegativeButton(
      "??????",
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {}
      }
    );

    AlertDialog dialog = builder.create();
    dialog.show();
  }

  private void sendSMS(String phoneNumber, String message) {
    SmsManager sms = SmsManager.getDefault();
    sms.sendTextMessage(phoneNumber, null, message, null, null);
  }
}
