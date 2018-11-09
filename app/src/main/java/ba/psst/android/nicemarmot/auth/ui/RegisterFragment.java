package ba.psst.android.nicemarmot.auth.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import ba.psst.android.nicemarmot.NiceMarmotApp;
import ba.psst.android.nicemarmot.util.BaseFragment;

public class RegisterFragment extends BaseFragment {

    private static final String TAG = RegisterFragment.class.getSimpleName();
    
    private ViewModel mViewModel;
    
    @Inject
    ViewModelProvider.Factory niceFactory;

    public static RegisterFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    public static String getTAG() {
        return TAG;
    }

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
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated: T#" + System.currentTimeMillis());
        super.onActivityCreated(savedInstanceState);
        
        mViewModel = ViewModelProviders.of(this, niceFactory)
                .get(AuthViewModel.class);
    }
}
