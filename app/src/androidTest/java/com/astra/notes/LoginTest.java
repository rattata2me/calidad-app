package com.astra.notes;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.concurrent.Executor;

@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<SignInActivity> mActivityRule = new ActivityTestRule<>(SignInActivity.class, false, false);

    @Test
    public void testLogin() {
        Task<AuthResult> task = new TaskCompletionSource<AuthResult>().getTask();

        FirebaseAuth mockFirebaseAuth = Mockito.mock(FirebaseAuth.class);
        FirebaseAuth spyFireBaseAuth = Mockito.spy(mockFirebaseAuth);
        Mockito.doReturn(task).when(spyFireBaseAuth).signInWithEmailAndPassword("tes@test", "test");

        Mockito.verify(spyFireBaseAuth).signInWithEmailAndPassword("tes@test", "test");
    }
}
