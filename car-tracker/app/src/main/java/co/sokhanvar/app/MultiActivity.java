package co.sokhanvar.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.lid.lib.LabelButtonView;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MultiActivity extends AppCompatActivity {

  View selectedView;
  View editSelected;

  LabelButtonView btn1, btn2, btn3, btn4, btn5, btn6, btn7;
  ImageButton btnEdit1, btnEdit2, btnEdit3, btnEdit4, btnEdit5, btnEdit6, btnEdit7;

  AlertDialog dialog;
  String extractValue;

  AlertDialog edtDialog;
  String editExtractValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multi);

    GlobalAppContextSingleton.getInstance().initialize(this);

    final SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

    final boolean isFirst1 = sharedPreferenceHelper.getSharedPreferenceBoolean(
      MultiActivity.this,
      "first1",
      true
    );
    final boolean isFirst2 = sharedPreferenceHelper.getSharedPreferenceBoolean(
      MultiActivity.this,
      "first2",
      true
    );
    final boolean isFirst3 = sharedPreferenceHelper.getSharedPreferenceBoolean(
      MultiActivity.this,
      "first3",
      true
    );
    final boolean isFirst4 = sharedPreferenceHelper.getSharedPreferenceBoolean(
      MultiActivity.this,
      "first4",
      true
    );
    final boolean isFirst5 = sharedPreferenceHelper.getSharedPreferenceBoolean(
      MultiActivity.this,
      "first5",
      true
    );
    final boolean isFirst6 = sharedPreferenceHelper.getSharedPreferenceBoolean(
      MultiActivity.this,
      "first6",
      true
    );

    btn1 = findViewById(R.id.btnHome1);
    btn2 = findViewById(R.id.btnHome2);
    btn3 = findViewById(R.id.btnHome3);
    btn4 = findViewById(R.id.btnHome4);
    btn5 = findViewById(R.id.btnHome5);
    btn6 = findViewById(R.id.btnHome6);
    btn7 = findViewById(R.id.btnHome7);

    btnEdit1 = findViewById(R.id.btnEdit1);
    btnEdit2 = findViewById(R.id.btnEdit2);
    btnEdit3 = findViewById(R.id.btnEdit3);
    btnEdit4 = findViewById(R.id.btnEdit4);
    btnEdit5 = findViewById(R.id.btnEdit5);
    btnEdit6 = findViewById(R.id.btnEdit6);
    btnEdit7 = findViewById(R.id.btnEdit7);

    btn1.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name1",
        "خانه"
      )
    );
    btn2.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name2",
        null
      )
    );
    btn3.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name3",
        null
      )
    );
    btn4.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name4",
        null
      )
    );
    btn5.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name5",
        null
      )
    );
    btn6.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name6",
        null
      )
    );
    btn7.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name7",
        "هفتم"
      )
    );

    final View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        selectedView = view;

        switch (selectedView.getTag().toString()) {
          case "1":
            if (isFirst1) {
              showCustomAddLocationDialog();
            } else {
              String activeName = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "name1",
                null
              );
              String activeNumber = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "num1",
                null
              );
              String activePassword = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "pass1",
                null
              );

              Smodel.setLocationName(activeName);
              Smodel.setNumber(activeNumber);
              Smodel.setPassword(activePassword);

              Smodel.setCurrentSelect("1");

              openMyMain();
            }

            break;
          case "2":
            if (isFirst2) {
              showCustomAddLocationDialog();
            } else {
              String activeName = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "name2",
                null
              );
              String activeNumber = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "num2",
                null
              );
              String activePassword = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "pass2",
                null
              );

              Smodel.setLocationName(activeName);
              Smodel.setNumber(activeNumber);
              Smodel.setPassword(activePassword);

              Smodel.setCurrentSelect("2");

              openMyMain();
            }

            break;
          case "3":
            if (isFirst3) {
              showCustomAddLocationDialog();
            } else {
              String activeName = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "name3",
                null
              );
              String activeNumber = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "num3",
                null
              );
              String activePassword = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "pass3",
                null
              );

              Smodel.setLocationName(activeName);
              Smodel.setNumber(activeNumber);
              Smodel.setPassword(activePassword);

              Smodel.setCurrentSelect("3");

              openMyMain();
            }

            break;
          case "4":
            if (isFirst4) {
              showCustomAddLocationDialog();
            } else {
              String activeName = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "name4",
                null
              );
              String activeNumber = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "num4",
                null
              );
              String activePassword = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "pass4",
                null
              );

              Smodel.setLocationName(activeName);
              Smodel.setNumber(activeNumber);
              Smodel.setPassword(activePassword);

              Smodel.setCurrentSelect("4");

              openMyMain();
            }

            break;
          case "5":
            if (isFirst5) {
              showCustomAddLocationDialog();
            } else {
              String activeName = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "name5",
                null
              );
              String activeNumber = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "num5",
                null
              );
              String activePassword = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "pass5",
                null
              );

              Smodel.setLocationName(activeName);
              Smodel.setNumber(activeNumber);
              Smodel.setPassword(activePassword);

              Smodel.setCurrentSelect("5");

              openMyMain();
            }

            break;
          case "6":
            if (isFirst6) {
              showCustomAddLocationDialog();
            } else {
              String activeName = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "name6",
                null
              );
              String activeNumber = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "num6",
                null
              );
              String activePassword = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "pass6",
                null
              );

              Smodel.setLocationName(activeName);
              Smodel.setNumber(activeNumber);
              Smodel.setPassword(activePassword);

              Smodel.setCurrentSelect("6");

              openMyMain();
            }

            break;
          case "7":
            if (isFirst6) {
              showCustomAddLocationDialog();
            } else {
              String activeName = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "name7",
                null
              );
              String activeNumber = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "num7",
                null
              );
              String activePassword = sharedPreferenceHelper.getSharedPreferenceString(
                MultiActivity.this,
                "pass7",
                null
              );

              Smodel.setLocationName(activeName);
              Smodel.setNumber(activeNumber);
              Smodel.setPassword(activePassword);

              Smodel.setCurrentSelect("7");

              openMyMain();
            }

            break;
        }
      }
    };

    btn1.setOnClickListener(listener);
    btn2.setOnClickListener(listener);
    btn3.setOnClickListener(listener);
    btn4.setOnClickListener(listener);
    btn5.setOnClickListener(listener);
    btn6.setOnClickListener(listener);

    final View.OnClickListener editListener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        editSelected = view;

        showCustomEditLocationDialog();
      }
    };

    btnEdit1.setOnClickListener(editListener);
    btnEdit2.setOnClickListener(editListener);
    btnEdit3.setOnClickListener(editListener);
    btnEdit4.setOnClickListener(editListener);
    btnEdit5.setOnClickListener(editListener);
    btnEdit6.setOnClickListener(editListener);
    btnEdit7.setOnClickListener(editListener);
  }

  private void showCustomAddLocationDialog() {
    AlertDialog.Builder dBuilder = new AlertDialog.Builder(MultiActivity.this);
    final View dView = getLayoutInflater()
      .inflate(R.layout.custom_add_dialog, null);
    dBuilder.setView(dView);

    final EditText edtName, edtNumber, edtPass;

    edtName = dView.findViewById(R.id.edtName);
    edtNumber = dView.findViewById(R.id.edtNumber);
    edtPass = dView.findViewById(R.id.edtPass);

    Button btnAddLocation;
    btnAddLocation = dView.findViewById(R.id.btnAddLocation);

    final MaskedTextChangedListener listener = new MaskedTextChangedListener(
      "+98 ([000]) [000] [00] [00]",
      true,
      edtNumber,
      null,
      new MaskedTextChangedListener.ValueListener() {
        @Override
        public void onTextChanged(
          boolean maskFilled,
          @NonNull final String extractedValue
        ) {
          Log.d(MyMainActivity.class.getSimpleName(), extractedValue);

          Log.d(
            MyMainActivity.class.getSimpleName(),
            String.valueOf(maskFilled)
          );

          extractValue = extractedValue;
        }
      }
    );

    edtNumber.addTextChangedListener(listener);
    edtNumber.setOnFocusChangeListener(listener);

    btnAddLocation.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          String name = edtName.getText().toString();
          String number = "+98" + extractValue;
          String password = edtPass.getText().toString();

          String shFirst = "first" + selectedView.getTag();
          String shName = "name" + selectedView.getTag();
          String shNum = "num" + selectedView.getTag();
          String shPass = "pass" + selectedView.getTag();

          if (
            extractValue != null &&
            extractValue.length() == 10 &&
            password.length() == 4 &&
            name.length() >= 1
          ) {
            Toast
              .makeText(
                getApplicationContext(),
                "راه اندازی مجدد برنامه",
                Toast.LENGTH_LONG
              )
              .show();

            SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

            sharedPreferenceHelper.setSharedPreferenceBoolean(
              MultiActivity.this,
              shFirst,
              false
            );
            sharedPreferenceHelper.setSharedPreferenceString(
              GlobalAppContextSingleton.getInstance().getApplicationContext(),
              shName,
              name
            );
            sharedPreferenceHelper.setSharedPreferenceString(
              GlobalAppContextSingleton.getInstance().getApplicationContext(),
              shNum,
              number
            );
            sharedPreferenceHelper.setSharedPreferenceString(
              GlobalAppContextSingleton.getInstance().getApplicationContext(),
              shPass,
              password
            );

            /*Smodel.setLocationName(name);
          Smodel.setNumber(number);
          Smodel.setPassword(password);*/

            Intent i = getBaseContext()
              .getPackageManager()
              .getLaunchIntentForPackage(getBaseContext().getPackageName());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(i);
          } else {
            Toast
              .makeText(
                getApplicationContext(),
                "لطفا تمامی فیلد ها را به درستی پر نمایید",
                Toast.LENGTH_LONG
              )
              .show();
          }
        }
      }
    );

    dialog = dBuilder.create();
    dialog.show();
  }

  private void showCustomEditLocationDialog() {
    AlertDialog.Builder dBuilder = new AlertDialog.Builder(MultiActivity.this);
    final View dView = getLayoutInflater()
      .inflate(R.layout.custom_edit_dialog, null);
    dBuilder.setView(dView);

    final EditText edtName, edtNumber, edtPass;

    edtName = dView.findViewById(R.id.edtNameEdit);
    edtNumber = dView.findViewById(R.id.edtNumberEdit);
    edtPass = dView.findViewById(R.id.edtPassEdit);

    SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

    edtName.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "name" + editSelected.getTag(),
        ""
      )
    );
    edtNumber.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "num" + editSelected.getTag(),
        ""
      )
    );
    edtPass.setText(
      sharedPreferenceHelper.getSharedPreferenceString(
        MultiActivity.this,
        "pass" + editSelected.getTag(),
        ""
      )
    );

    Button btnAddLocation;
    btnAddLocation = dView.findViewById(R.id.btnEditLocation);

    final MaskedTextChangedListener listener = new MaskedTextChangedListener(
      "+98 ([000]) [000] [00] [00]",
      true,
      edtNumber,
      null,
      new MaskedTextChangedListener.ValueListener() {
        @Override
        public void onTextChanged(
          boolean maskFilled,
          @NonNull final String extractedValue
        ) {
          Log.d(MyMainActivity.class.getSimpleName(), extractedValue);

          Log.d(
            MyMainActivity.class.getSimpleName(),
            String.valueOf(maskFilled)
          );

          editExtractValue = extractedValue;
        }
      }
    );

    edtNumber.addTextChangedListener(listener);
    edtNumber.setOnFocusChangeListener(listener);

    btnAddLocation.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          String name = edtName.getText().toString();
          String number = "+98" + editExtractValue;
          String password = edtPass.getText().toString();
          String shFirst = "first" + editSelected.getTag();
          String shName = "name" + editSelected.getTag();
          String shNum = "num" + editSelected.getTag();
          String shPass = "pass" + editSelected.getTag();

          if (
            editExtractValue != null &&
            editExtractValue.length() == 10 &&
            password.length() == 4 &&
            name.length() >= 1
          ) {
            Toast
              .makeText(
                getApplicationContext(),
                "راه اندازی مجدد برنامه",
                Toast.LENGTH_LONG
              )
              .show();

            SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper();

            sharedPreferenceHelper.setSharedPreferenceBoolean(
              MultiActivity.this,
              shFirst,
              false
            );
            sharedPreferenceHelper.setSharedPreferenceString(
              GlobalAppContextSingleton.getInstance().getApplicationContext(),
              shName,
              name
            );
            sharedPreferenceHelper.setSharedPreferenceString(
              GlobalAppContextSingleton.getInstance().getApplicationContext(),
              shNum,
              number
            );
            sharedPreferenceHelper.setSharedPreferenceString(
              GlobalAppContextSingleton.getInstance().getApplicationContext(),
              shPass,
              password
            );

            Intent i = getBaseContext()
              .getPackageManager()
              .getLaunchIntentForPackage(getBaseContext().getPackageName());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(i);
          } else {
            Toast
              .makeText(
                getApplicationContext(),
                "لطفا تمامی فیلد ها را به درستی پر نمایید",
                Toast.LENGTH_LONG
              )
              .show();
          }
        }
      }
    );

    edtDialog = dBuilder.create();
    edtDialog.show();
  }

  private void openMyMain() {
    Intent intent = new Intent(MultiActivity.this, MyMainActivity.class);
    startActivity(intent);
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }
}
