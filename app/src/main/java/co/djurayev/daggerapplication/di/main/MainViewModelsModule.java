package co.djurayev.daggerapplication.di.main;

import androidx.lifecycle.ViewModel;
import co.djurayev.daggerapplication.di.ViewModelKey;
import co.djurayev.daggerapplication.ui.main.MainViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {
  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel.class)
  public abstract ViewModel bindMainViewModel(MainViewModel viewModel);
}
