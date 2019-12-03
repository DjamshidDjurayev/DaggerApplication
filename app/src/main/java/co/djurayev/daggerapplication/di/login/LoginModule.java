package co.djurayev.daggerapplication.di.login;

import co.djurayev.daggerapplication.network.login.LoginApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class LoginModule {
  @LoginScope
  @Provides
  static LoginApi provideLoginApi(Retrofit retrofit) {
    return retrofit.create(LoginApi.class);
  }
}
