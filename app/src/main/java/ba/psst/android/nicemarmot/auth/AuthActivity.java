package ba.psst.android.nicemarmot.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ba.psst.android.nicemarmot.R;
import ba.psst.android.nicemarmot.auth.ui.LoginFragment;
import ba.psst.android.nicemarmot.util.BaseActivity;

public class AuthActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auth);

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_activity_auth, new LoginFragment(), LoginFragment.getTAG())
                    .commitNow();
        }
    }
}
