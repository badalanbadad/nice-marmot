package ba.psst.android.nicemarmot.di;

import android.app.Application;

import javax.inject.Singleton;

import ba.psst.android.nicemarmot.auth.AuthActivity;
import ba.psst.android.nicemarmot.auth.ui.LoginFragment;
import ba.psst.android.nicemarmot.auth.ui.RegisterFragment;
import ba.psst.android.nicemarmot.data.Repository;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ViewModelModule.class, FirebaseModule.class})
public interface AppComponent {

    void inject(AuthActivity authActivity);
    void inject(LoginFragment loginFragment);
    void inject(RegisterFragment registerFragment);

}
