package ba.psst.android.nicemarmot.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import ba.psst.android.nicemarmot.auth.ui.AuthViewModel;
import ba.psst.android.nicemarmot.data.Repository;

@Singleton
public class NiceViewModelFactory implements ViewModelProvider.Factory {

    private final Repository mRepository;

    @Inject
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
