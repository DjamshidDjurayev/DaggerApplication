package co.djurayev.daggerapplication.ui.main;

import android.content.Intent;
import android.os.Bundle;
import co.djurayev.daggerapplication.R;
import co.djurayev.daggerapplication.ui.base.BaseActivity;
import co.djurayev.daggerapplication.ui.login.LoginActivity;
import co.djurayev.daggerapplication.util.Prefs;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject Prefs prefs;
  @Inject MainViewModel mainViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    startActivity(new Intent(MainActivity.this, LoginActivity.class));
  }
}
