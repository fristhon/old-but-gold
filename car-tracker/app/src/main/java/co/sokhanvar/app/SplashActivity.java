package co.sokhanvar.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

  private static int SPLASH_TIME = 3000;

  Handler handler;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    GlobalAppContextSingleton.getInstance().initialize(this);

    Toast
      .makeText(getApplicationContext(), "نسخه آزمایشی", Toast.LENGTH_SHORT)
      .show();

    handler = new Handler();
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        firstRunCheck();

        finish();
      }
    };

    handler.postDelayed(runnable, SPLASH_TIME);
  }

  private void firstRunCheck() {
    SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

    boolean isFirst = sharedPreferenceHelper.getSharedPreferenceBoolean(
      this,
      "first",
      true
    );

    if (isFirst) {
      openSettingActivity();
    } else {
      openMainActivity();
    }
  }

  private void openSettingActivity() {
    Intent intent = new Intent(SplashActivity.this, MultiActivity.class);
    startActivity(intent);
    finish();
  }

  private void openMainActivity() {
    Intent intent2 = new Intent(SplashActivity.this, MultiActivity.class);
    startActivity(intent2);
    finish();
  }
}
