package co.djurayev.daggerapplication.di;

import android.app.Application;
import android.content.Context;
import co.djurayev.daggerapplication.MainApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class
    }
)
public interface AppComponent extends AndroidInjector<MainApplication> {
  @Component.Builder
  interface Builder{

    @BindsInstance
    Builder application(Application application);

    AppComponent build();
  }
}
