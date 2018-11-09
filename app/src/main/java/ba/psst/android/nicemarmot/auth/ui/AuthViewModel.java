package ba.psst.android.nicemarmot.auth.ui;

import android.arch.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import ba.psst.android.nicemarmot.data.Repository;

public class AuthViewModel extends ViewModel {

    private final Repository mRepository;

    public AuthViewModel(Repository repository) {
        mRepository = repository;
    }

    public boolean isSignedIn() {

        return mRepository.isSignedIn();
    }

    void createUserWithEmailAndPassword(String email, String password,
                                        OnCompleteListener<AuthResult> l) {

        mRepository.createUserWithEmailAndPassword(email, password, l);
    }

    void signInWithEmailAndPassword(String email, String password,
                                    OnCompleteListener<AuthResult> l) {

        mRepository.signInWithEmailAndPassword(email, password, l);
    }

    void signInAnonymously(OnCompleteListener<AuthResult> l) {

        mRepository.signInAnonymously(l);
    }
}
