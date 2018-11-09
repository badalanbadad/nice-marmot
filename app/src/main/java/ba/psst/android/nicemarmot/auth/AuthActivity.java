package ba.psst.android.nicemarmot.auth;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

import ba.psst.android.nicemarmot.NiceMarmotApp;
import ba.psst.android.nicemarmot.R;
import ba.psst.android.nicemarmot.auth.ui.AuthViewModel;
import ba.psst.android.nicemarmot.auth.ui.LoginFragment;
import ba.psst.android.nicemarmot.main.MainActivity;
import ba.psst.android.nicemarmot.util.BaseActivity;

public class AuthActivity extends BaseActivity {

    private static final String TAG = AuthActivity.class.getSimpleName();

    private ViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory niceFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: T#" + System.currentTimeMillis());

        ((NiceMarmotApp) getApplication())
                .getAppComponent()
                .inject(this);

        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auth);

        mViewModel = ViewModelProviders.of(this, niceFactory)
                .get(AuthViewModel.class);

        if(((AuthViewModel) mViewModel).isSignedIn()) {

            startActivity(new Intent(AuthActivity.this, MainActivity.class));

        } else {

            if (savedInstanceState == null) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.root_activity_auth, new LoginFragment(), LoginFragment.getTAG())
                        .commitNow();
            }
        }
    }
}
