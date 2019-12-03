package co.djurayev.daggerapplication.ui.login;

import android.util.Log;
import co.djurayev.daggerapplication.network.login.LoginApi;
import co.djurayev.daggerapplication.ui.base.BaseViewModel;
import javax.inject.Inject;

public class LoginViewModel extends BaseViewModel {
  private LoginApi loginApi;

  @Inject LoginViewModel(LoginApi loginApi) {
    this.loginApi = loginApi;
    Log.d("AXAXAX", "LOGIN VIEWMODEL worked");
  }
}
