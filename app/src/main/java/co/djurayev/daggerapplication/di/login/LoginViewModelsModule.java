package co.djurayev.daggerapplication.di.login;

import androidx.lifecycle.ViewModel;
import co.djurayev.daggerapplication.di.ViewModelKey;
import co.djurayev.daggerapplication.ui.login.LoginViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class LoginViewModelsModule {
  @Binds
  @IntoMap
  @ViewModelKey(LoginViewModel.class)
  public abstract ViewModel bindLoginViewModel(LoginViewModel viewModel);
}
