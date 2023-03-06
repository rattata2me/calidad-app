package com.astra.notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.astra.notes.R.id;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ktx.AuthKt;
import com.google.firebase.ktx.Firebase;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"},
        d2 = {"Lcom/astra/notes/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "createAccount", "", "email", "", "password", "errorMessage", "Landroid/widget/TextView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_debug"}
)
public final class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private HashMap _$_findViewCache;

    protected void onStart() {
        super.onStart();
        FirebaseAuth var10000 = this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        FirebaseUser currentUser = var10000.getCurrentUser();
        if (currentUser != null) {
        }

    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300006);
        View view = this.findViewById(1000065);
        TextView textView1 = (TextView)this.findViewById(1000062);
        TextView textView2 = (TextView)this.findViewById(1000020);
        TextView textView3 = (TextView)this.findViewById(1000031);
        TextView textRegisterMail = (TextView)this.findViewById(1000063);
        TextView textRegisterPass = (TextView)this.findViewById(1000016);
        if (MainActivity.Companion.getGlobalDark()) {
            view.setBackgroundColor(Color.parseColor("#FF000000"));
            textView1.setTextColor(Color.parseColor("#FFFFFFFF"));
            textView2.setTextColor(Color.parseColor("#FFFFFFFF"));
            textView3.setTextColor(Color.parseColor("#FFFFFFFF"));
            textRegisterMail.setTextColor(Color.parseColor("#FFFFFFFF"));
            textRegisterPass.setTextColor(Color.parseColor("#FFFFFFFF"));
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            textView1.setTextColor(Color.parseColor("#FF000000"));
            textView2.setTextColor(Color.parseColor("#FF000000"));
            textView3.setTextColor(Color.parseColor("#FF000000"));
            textRegisterMail.setTextColor(Color.parseColor("#FF000000"));
            textRegisterPass.setTextColor(Color.parseColor("#FF000000"));
        }

        this.auth = AuthKt.getAuth(Firebase.INSTANCE);
        final TextView errorMessage = (TextView)this.findViewById(1000040);
        Intrinsics.checkNotNullExpressionValue(errorMessage, "errorMessage");
        errorMessage.setVisibility(8);
        final EditText emailInput = (EditText)this.findViewById(1000063);
        final EditText passwordInput = (EditText)this.findViewById(1000016);
        Button registerButton = (Button)this.findViewById(1000027);
        registerButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                RegisterActivity var10000 = RegisterActivity.this;
                EditText var10001 = emailInput;
                Intrinsics.checkNotNullExpressionValue(var10001, "emailInput");
                String var2 = var10001.getText().toString();
                EditText var10002 = passwordInput;
                Intrinsics.checkNotNullExpressionValue(var10002, "passwordInput");
                String var3 = var10002.getText().toString();
                TextView var10003 = errorMessage;
                Intrinsics.checkNotNullExpressionValue(var10003, "errorMessage");
                var10000.createAccount(var2, var3, var10003);
            }
        }));
        ((Button)this._$_findCachedViewById(id.login_button)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)RegisterActivity.this, SignInActivity.class);
                RegisterActivity.this.startActivity(intent);
            }
        }));
    }

    private final void createAccount(String email, String password, final TextView errorMessage) {
        FirebaseAuth var10000 = this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        var10000.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity)this, (OnCompleteListener)(new OnCompleteListener() {
            public final void onComplete(@NotNull Task task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    errorMessage.setVisibility(8);
                    FirebaseUser user = RegisterActivity.access$getAuth$p(RegisterActivity.this).getCurrentUser();
                    Intent intent = new Intent((Context)RegisterActivity.this, MainActivity.class);
                    RegisterActivity.this.startActivity(intent);
                } else {
                    errorMessage.setVisibility(0);
                }

            }
        }));
    }

    // $FF: synthetic method
    public static final FirebaseAuth access$getAuth$p(RegisterActivity $this) {
        FirebaseAuth var10000 = $this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setAuth$p(RegisterActivity $this, FirebaseAuth var1) {
        $this.auth = var1;
    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }
}
