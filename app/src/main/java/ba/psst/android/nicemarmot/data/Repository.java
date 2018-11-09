package ba.psst.android.nicemarmot.data;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import javax.inject.Inject;

public class Repository {

    private final FireCoreDao mFireCoreDao;

    @Inject
    public Repository(FireCoreDao mFireCoreDao) {
        this.mFireCoreDao = mFireCoreDao;
    }

    public boolean isSignedIn() {

        return mFireCoreDao.isSignedIn();
    }

    public void createUserWithEmailAndPassword
            (String email, String password, OnCompleteListener<AuthResult> l) {

        mFireCoreDao.createUserWithEmailAndPassword(email, password, l);
    }

    public void signInWithEmailAndPassword
            (String email, String password, OnCompleteListener<AuthResult> l) {

        mFireCoreDao.signInWithEmailAndPassword(email, password, l);
    }

    public void signInAnonymously(OnCompleteListener<AuthResult> l) {

        mFireCoreDao.singInAnonymously(l);
    }
}
