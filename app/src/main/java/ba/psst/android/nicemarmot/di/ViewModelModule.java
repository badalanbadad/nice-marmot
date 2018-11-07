package ba.psst.android.nicemarmot.di;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import ba.psst.android.nicemarmot.data.Repository;
import ba.psst.android.nicemarmot.viewmodel.NiceViewModelFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    @Singleton
    Repository provideRepository() {
        return new Repository();
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideNiceViewModelFactory(Repository repository) {
        return new NiceViewModelFactory(repository);
    }
}
