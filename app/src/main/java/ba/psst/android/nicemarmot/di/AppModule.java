package ba.psst.android.nicemarmot.di;

import android.app.Application;

import javax.inject.Singleton;

import ba.psst.android.nicemarmot.NiceMarmotApp;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final NiceMarmotApp app;

    public AppModule(NiceMarmotApp app) {
        this.app = app;
    }

    @Provides
    Application provideApp() {
        return app;
    }

    @Provides
    NiceMarmotApp provideNiceMarmotApp() {
        return app;
    }
}
