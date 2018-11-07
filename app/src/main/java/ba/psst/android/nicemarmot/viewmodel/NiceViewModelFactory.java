package ba.psst.android.nicemarmot.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import ba.psst.android.nicemarmot.auth.ui.AuthViewModel;
import ba.psst.android.nicemarmot.data.Repository;

public class NiceViewModelFactory implements ViewModelProvider.Factory {

    private Repository mRepository;

    public NiceViewModelFactory(Repository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(AuthViewModel.class)) {
            return modelClass.cast(new AuthViewModel(mRepository));

        } else {
            throw new IllegalArgumentException("ViewModel not found...");
        }
    }
}
