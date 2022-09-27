package co.sokhanvar.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import project.fragment.StatesFragment;

public class SmsReciver extends BroadcastReceiver {

  private static String myBody = "";

  static String[] list;

  @Override
  public void onReceive(Context context, Intent intent) {
    processReciver(context, intent);
    Bundle pudsBundle = intent.getExtras();
    Object[] pdus = (Object[]) pudsBundle.get("pdus");
    SmsMessage messages = SmsMessage.createFromPdu((byte[]) pdus[0]);
  }

  public static String getMyBody() {
    return myBody;
  }

  public static void setMyBody(String myBody) {
    SmsReciver.myBody = myBody;
  }

  private static void processReciver(Context context, Intent intent) {
    Bundle extras = intent.getExtras();
    String body = "";
    String message = "";
    String address = "";

    if (extras != null) {
      Object[] smsExtras = (Object[]) extras.get("pdus");

      for (int i = 0; i < smsExtras.length; i++) {
        SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtras[i]);

        body = sms.getMessageBody();

        address = sms.getOriginatingAddress();

        message += "SMS from :" + address + "\n Body :" + body + "\n";

        if (address.equals(Smodel.getNumber())) {
          myBody = body;
          Smodel.setSms(true);

          list = myBody.split(",");

          if (list[0].equals("sv") && list[14].equals("sv")) {
            setModelFildes();

            StatesFragment statesFragment = new StatesFragment();

            statesFragment.setValueOnFildes();
            statesFragment.saveInSharedPreferences();
          }
        }
      }
    }
  }

  private static void setModelFildes() {
    Smodel.setLatitude(list[1]);
    Smodel.setLongitude(list[2]);

    Smodel.setCar(list[3]);
    Smodel.setDirection(list[4]);
    Smodel.setSpeed(list[5]);
    Smodel.setOil(list[6]);
    Smodel.setDoor(list[7]);
    Smodel.setAlarm(list[8]);
    Smodel.setHour(list[9]);
    Smodel.setMinute(list[10]);

    Smodel.setDay(list[11]);
    Smodel.setMonth(list[12]);
    Smodel.setYear(list[13]);
  }
}
