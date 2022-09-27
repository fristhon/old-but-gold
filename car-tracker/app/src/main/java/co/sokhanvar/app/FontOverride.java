package co.sokhanvar.app;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by MRJ on 18/02/2018.
 */

public class FontOverride extends Application {


  public void onCreate()
  {
    super.onCreate();
    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
      .setDefaultFontPath("font/Vazir-Light-FD-WOL.ttf")
      .setFontAttrId(R.attr.fontPath)
      .build());

  }


}
