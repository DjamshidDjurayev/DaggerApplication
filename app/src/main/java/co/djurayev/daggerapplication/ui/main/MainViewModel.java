package co.djurayev.daggerapplication.ui.main;

import android.util.Log;
import co.djurayev.daggerapplication.network.main.MainApi;
import co.djurayev.daggerapplication.ui.base.BaseViewModel;
import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {
  private MainApi mainApi;

  @Inject MainViewModel(MainApi mainApi) {
    this.mainApi = mainApi;
    Log.d("AXAXAX", "MAIN VIEWMODEL worked");
  }
}
