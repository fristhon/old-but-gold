package co.sokhanvar.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.redmadrobot.inputmask.MaskedTextChangedListener;

public class SettingActivity extends AppCompatActivity {

  String extractValue;

  Button btnSubmitNumber, btnMask;
  EditText edtNum1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_setting);

    GlobalAppContextSingleton.getInstance().initialize(this);

    btnSubmitNumber = findViewById(R.id.btnSubmitNumber);

    final EditText editText = (EditText) findViewById(R.id.edtNum);

    final MaskedTextChangedListener listener = new MaskedTextChangedListener(
      "+98 ([000]) [000] [00] [00]",
      true,
      editText,
      null,
      new MaskedTextChangedListener.ValueListener() {
        @Override
        public void onTextChanged(
          boolean maskFilled,
          @NonNull final String extractedValue
        ) {
          extractValue = extractedValue;
        }
      }
    );

    editText.addTextChangedListener(listener);
    editText.setOnFocusChangeListener(listener);
    editText.setHint("لطفا شماره سیم کارت را بدون صفر وارد کنید");

    btnSubmitNumber.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (extractValue != null && extractValue.length() == 10) {
            showDialog();
          } else {
            Toast
              .makeText(
                getApplicationContext(),
                "لطفا شماره را صحیح وارد نمایید",
                Toast.LENGTH_LONG
              )
              .show();
          }
        }

        private void openMainActivity() {
          Intent intent2 = new Intent(
            SettingActivity.this,
            MyMainActivity.class
          );
          startActivity(intent2);
          finish();
        }

        private void showDialog() {
          AlertDialog.Builder builder = new AlertDialog.Builder(
            SettingActivity.this
          );
          builder.setTitle(
            "" +
            "آیا شماره" +
            "" +
            extractValue +
            "" +
            "" +
            "را تایید میکنید؟" +
            ""
          );
          builder.setPositiveButton(
            "تایید",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                String simNumber = "+98" + extractValue;

                SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

                sharedPreferenceHelper.setSharedPreferenceBoolean(
                  GlobalAppContextSingleton
                    .getInstance()
                    .getApplicationContext(),
                  "first",
                  false
                );

                sharedPreferenceHelper.setSharedPreferenceString(
                  SettingActivity.this,
                  "sim",
                  simNumber
                );

                openMainActivity();
              }
            }
          );

          builder.setNegativeButton(
            "ویرایش",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {}
            }
          );

          AlertDialog dialog = builder.create();
          dialog.show();
        }
      }
    );
  }
}
