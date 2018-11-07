package ba.psst.android.nicemarmot.auth.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ba.psst.android.nicemarmot.R;
import ba.psst.android.nicemarmot.main.MainActivity;
import ba.psst.android.nicemarmot.util.BaseFragment;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginFragment extends BaseFragment {

    public static final String TAG = LoginFragment.class.getSimpleName();

    public static String getTAG() {
        return TAG;
    }

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @OnClick(R.id.button_fragment_login)
    public void goToMainActivity(Button button) {

        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}
