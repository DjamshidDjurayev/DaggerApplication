package co.djurayev.daggerapplication.ui.base;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {
  private CompositeDisposable compositeDisposable;

  protected BaseViewModel() {
    this.compositeDisposable = new CompositeDisposable();
  }

  public void addDisposable(Disposable disposable) {
    compositeDisposable.add(disposable);
  }

  @Override protected void onCleared() {
    super.onCleared();
    clearCompositeDisposable();
  }

  private void clearCompositeDisposable() {
    if (compositeDisposable != null && compositeDisposable.size() > 0) {
      compositeDisposable.clear();
    }
  }
}
