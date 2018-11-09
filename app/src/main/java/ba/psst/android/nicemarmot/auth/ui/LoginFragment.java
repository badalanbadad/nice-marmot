package ba.psst.android.nicemarmot.auth.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import javax.inject.Inject;

import ba.psst.android.nicemarmot.NiceMarmotApp;
import ba.psst.android.nicemarmot.R;
import ba.psst.android.nicemarmot.main.MainActivity;
import ba.psst.android.nicemarmot.util.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginFragment extends BaseFragment {

    public static final String TAG = LoginFragment.class.getSimpleName();

    public static String getTAG() {
        return TAG;
    }

    private AuthViewModel mViewModel;

    //Butter knife
    @BindView(R.id.edit_text_fragment_login_email)
    EditText eTxtEmail;

    @BindView(R.id.edit_text_fragment_login_password)
    EditText eTxtPassword;

    private Unbinder unbinder;

    //Dagger
    @Inject
    ViewModelProvider.Factory niceFactory;

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach: T#" + System.currentTimeMillis());

        ((NiceMarmotApp) getActivity().getApplication())
                .getAppComponent()
                .inject(this);

        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: T#" + System.currentTimeMillis());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: T#" + System.currentTimeMillis());
        
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated: T#" + System.currentTimeMillis());
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this, niceFactory)
                .get(AuthViewModel.class);
    }

    @OnClick(R.id.button_fragment_login_sign_in)
    public void onSignInClicked() {

        String email = eTxtEmail.getText().toString();
        String password = eTxtPassword.getText().toString();

        if(!email.isEmpty() && !password.isEmpty()) {

            mViewModel.signInWithEmailAndPassword(email, password,
                    signIn -> {

                        if(signIn.isSuccessful()) {

                            Toast.makeText(
                                    getActivity(),
                                    R.string.toast_fragment_login_sign_in_successfull,
                                    Toast.LENGTH_LONG
                            ).show();

                            startActivity(new Intent(getActivity(), MainActivity.class));

                        } else {

                            Toast.makeText(
                                    getActivity(),
                                    R.string.toast_fragment_login_sign_in_failed,
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                    }
            );

        } else {

            Toast.makeText(
                    getActivity(),
                    R.string.toast_fragment_login_data_empty,
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    @OnClick(R.id.button_fragment_login_sign_in_anonymously)
    public void onSignInAnonymouslyClicked() {

        mViewModel.signInAnonymously(
                signInAnonymously -> {

                    if(signInAnonymously.isSuccessful()) {

                        Toast.makeText(
                                getActivity(),
                                R.string.toast_fragment_login_sign_in_anonymously_successfull,
                                Toast.LENGTH_LONG
                        ).show();

                        startActivity(new Intent(getActivity(), MainActivity.class));

                    } else {

                        Toast.makeText(
                                getActivity(),
                                R.string.toast_fragment_login_sign_in_anonymously_failed,
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }

    @OnClick(R.id.button_fragment_login_register)
    public void onRegisterClicked() {

        Fragment registerFragment
                = getFragmentManager().findFragmentByTag(RegisterFragment.getTAG());

        if(registerFragment == null) {
            registerFragment = RegisterFragment.newInstance();
        }

        getFragmentManager().beginTransaction()
                .replace(
                        ((ViewGroup) getView().getParent()).getId(),
                        registerFragment,
                        RegisterFragment.getTAG())
                .addToBackStack(RegisterFragment.getTAG())
                .commit();
    }
}
