package ba.psst.android.nicemarmot.auth.ui;

import android.arch.lifecycle.ViewModel;

import ba.psst.android.nicemarmot.data.Repository;

public class AuthViewModel extends ViewModel {

    private final Repository mRepository;

    public AuthViewModel(Repository repository) {
        mRepository = repository;
    }
}
