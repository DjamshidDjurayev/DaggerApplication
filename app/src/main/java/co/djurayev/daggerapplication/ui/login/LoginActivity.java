package co.djurayev.daggerapplication.ui.login;

import android.os.Bundle;
import androidx.annotation.Nullable;
import co.djurayev.daggerapplication.ui.base.BaseActivity;
import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

  @Inject LoginViewModel loginViewModel;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
