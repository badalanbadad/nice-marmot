package ba.psst.android.nicemarmot.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ViewModelModule.class})
public interface AppComponent {

    Application application();
}
