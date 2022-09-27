package project.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import co.sokhanvar.app.R;
import project.fragment.MapFragment;
import project.fragment.RemoteFragment;
import project.fragment.StatesFragment;
import project.widget.UTab;

public class MixedTabActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tab);
  }
}
