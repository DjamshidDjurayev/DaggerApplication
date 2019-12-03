package co.djurayev.daggerapplication.di;


import co.djurayev.daggerapplication.di.login.LoginViewModelsModule;
import co.djurayev.daggerapplication.di.main.MainViewModelsModule;
import co.djurayev.daggerapplication.ui.login.LoginActivity;
import co.djurayev.daggerapplication.ui.main.MainActivity;
import co.djurayev.daggerapplication.di.login.LoginModule;
import co.djurayev.daggerapplication.di.login.LoginScope;
import co.djurayev.daggerapplication.di.main.MainModule;
import co.djurayev.daggerapplication.di.main.MainScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuildersModule {
    @MainScope
    @ContributesAndroidInjector(
        modules = {MainModule.class, MainViewModelsModule.class}
    )
    abstract MainActivity contributeMainActivity();

    @LoginScope
    @ContributesAndroidInjector(
        modules = {LoginModule.class, LoginViewModelsModule.class}
    )
    abstract LoginActivity contributeLoginActivity();
}