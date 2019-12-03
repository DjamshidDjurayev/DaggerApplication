package co.djurayev.daggerapplication.di.main;

import co.djurayev.daggerapplication.network.main.MainApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

  @MainScope
  @Provides
  static MainApi provideMainApi(Retrofit retrofit) {
    return retrofit.create(MainApi.class);
  }
}
