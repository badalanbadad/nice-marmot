package ba.psst.android.nicemarmot.data;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public interface FireCoreDao {

    boolean isSignedIn();

    void createUserWithEmailAndPassword
            (String email, String password, final OnCompleteListener<AuthResult> l);

    void signInWithEmailAndPassword
            (String email, String password, final OnCompleteListener<AuthResult> l);

    void singInAnonymously(final OnCompleteListener<AuthResult> l);
}
