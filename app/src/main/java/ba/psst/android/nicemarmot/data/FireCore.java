package ba.psst.android.nicemarmot.data;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireCore implements FireCoreDao {

    private static final FireCore instance = new FireCore();

    private DatabaseReference fireRef;
    private FirebaseAuth fireAuth;
    private FirebaseUser fireUser;


    private FireCore() {

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        fireRef = FirebaseDatabase.getInstance().getReference();

        fireAuth = FirebaseAuth.getInstance();

        if(fireAuth.getCurrentUser() != null) {
            fireUser = fireAuth.getCurrentUser();
        }

    }

    public static FireCore getInstance() {
        return instance;
    }

    public FireCoreDao fireCoreDao() {
        return this;
    }

    @Override
    public boolean isSignedIn() {
        return fireUser != null;
    }

    @Override
    public void createUserWithEmailAndPassword(String email, String password, OnCompleteListener<AuthResult> l) {

        fireAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                createUser -> {

                    l.onComplete(createUser);

                    if (createUser.isSuccessful()) {
                        fireUser = fireAuth.getCurrentUser();
                    }
                }
        );
    }

    @Override
    public void signInWithEmailAndPassword(String email, String password, OnCompleteListener<AuthResult> l) {

        fireAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                signIn -> {

                    l.onComplete(signIn);

                    if(signIn.isSuccessful()) {
                        fireUser = fireAuth.getCurrentUser();
                    }
                }
        );
    }

    @Override
    public void singInAnonymously(OnCompleteListener<AuthResult> l) {

        fireAuth.signInAnonymously().addOnCompleteListener(
                signInAnonymously -> {

                    l.onComplete(signInAnonymously);

                    if(signInAnonymously.isSuccessful()) {
                        fireUser = fireAuth.getCurrentUser();
                    }
                }
        );
    }
}
