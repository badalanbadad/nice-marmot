package ba.psst.android.nicemarmot;

import android.app.Application;

import ba.psst.android.nicemarmot.di.DaggerAppComponent;
import ba.psst.android.nicemarmot.di.AppComponent;
import ba.psst.android.nicemarmot.di.AppModule;
import ba.psst.android.nicemarmot.di.FirebaseModule;

public class NiceMarmotApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .firebaseModule(new FirebaseModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
