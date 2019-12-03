package co.djurayev.daggerapplication.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import co.djurayev.daggerapplication.util.Constants;
import co.djurayev.daggerapplication.util.NetworkConnectionInterceptor;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
abstract class AppModule {

  @Singleton
  @Binds
  public abstract Interceptor bindNetworkInterceptor(NetworkConnectionInterceptor interceptor);

  @Singleton
  @Provides
  static OkHttpClient provideOkHttpClient(NetworkConnectionInterceptor interceptor) {
    OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    okHttpClient
        .connectTimeout(30L, TimeUnit.SECONDS)
        .writeTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(30L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addNetworkInterceptor(interceptor);

    return okHttpClient.build();
  }

  @Singleton
  @Provides
  static Retrofit provideRetrofitInstance(OkHttpClient okHttpClient){
    return new Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  @Singleton
  @Provides
  static SharedPreferences provideSharedPreferences(Application application) {
    return application.getSharedPreferences("DaggerApplicationPrefs", Context.MODE_PRIVATE);
  }
}
