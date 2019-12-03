package co.djurayev.daggerapplication.util;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Prefs {
  private static final String USER_TOKEN = "USER_TOKEN";

  private SharedPreferences sharedPreferences;

  @Inject Prefs(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  public void saveUserToken(String userToken) {
    sharedPreferences.edit().putString(USER_TOKEN, userToken).apply();
  }

  public String getUserToken() {
    return sharedPreferences.getString(USER_TOKEN, null);
  }
}
