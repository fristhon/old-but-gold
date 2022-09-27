package project.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import co.sokhanvar.app.R;
import project.fragment.MapFragment;
import project.fragment.RemoteFragment;
import project.fragment.StatesFragment;
import project.widget.UTab;

public class IconTabActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tab);

    final UTab tab = new UTab(this, R.id.viewPager, R.id.tabLayout);
    tab.add(MapFragment.class, R.drawable.ic_call_black_24dp);
    tab.add(StatesFragment.class, R.drawable.ic_message_black_24dp);
    tab.add(RemoteFragment.class, R.drawable.ic_people_black_24dp);
  }
}
