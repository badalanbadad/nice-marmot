package ba.psst.android.nicemarmot.di;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import ba.psst.android.nicemarmot.data.FireCore;
import ba.psst.android.nicemarmot.data.FireCoreDao;
import ba.psst.android.nicemarmot.data.Repository;
import ba.psst.android.nicemarmot.viewmodel.NiceViewModelFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    private final FireCore mFireCore;

    public FirebaseModule() {
        mFireCore = FireCore.getInstance();
    }

    @Provides
    @Singleton
    FireCore provideFireCore() {
        return mFireCore;
    }

    @Provides
    @Singleton
    FireCoreDao provideFireCoreDao() {
        return mFireCore.fireCoreDao();
    }

    @Provides
    @Singleton
    public Repository provideRepository(FireCoreDao fireCoreDao) {
        return new Repository(fireCoreDao);
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory provideNiceViewModelFactory(Repository repository) {
        return new NiceViewModelFactory(repository);
    }
}
