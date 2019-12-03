package co.djurayev.daggerapplication.util;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import javax.inject.Inject;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkConnectionInterceptor implements Interceptor {

  private Context mContext;

  @Inject NetworkConnectionInterceptor(Application Application) {
    mContext = Application;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    if (!isOnline()) {
      throw new NoConnectivityException();
    }

    Request.Builder builder = chain.request().newBuilder();
    return chain.proceed(builder.build());
  }

  private boolean isOnline() {
    ConnectivityManager connectivityManager =
        (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
    return (netInfo != null && netInfo.isConnected());
  }

  public class NoConnectivityException extends IOException {
    @Override
    public String getMessage() {
      return "Network Connection exception";
    }
  }
}