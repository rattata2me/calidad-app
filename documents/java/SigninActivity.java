package com.astra.notes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
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
        d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"},
        d2 = {"Lcom/astra/notes/SignInActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "email", "Landroid/widget/EditText;", "loginbtn", "Landroid/widget/Button;", "password", "signupredirect", "Landroid/widget/TextView;", "load", "", "user", "Lcom/google/firebase/auth/FirebaseUser;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_debug"}
)
public final class SignInActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button loginbtn;
    private TextView signupredirect;
    private FirebaseAuth auth;
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300002);
        View view = this.findViewById(1000045);
        TextView textView = (TextView)this.findViewById(1000044);
        TextView textRegister = (TextView)this.findViewById(1000008);
        TextView textMail = (TextView)this.findViewById(1000002);
        TextView textPass = (TextView)this.findViewById(1000009);
        View viewImageDark = this.findViewById(1000061);
        View viewImageLight = this.findViewById(1000047);
        if (MainActivity.Companion.getGlobalDark()) {
            view.setBackgroundColor(Color.parseColor("#FF000000"));
            textView.setTextColor(Color.parseColor("#FFFFFFFF"));
            textRegister.setTextColor(Color.parseColor("#FFFFFFFF"));
            textMail.setTextColor(Color.parseColor("#FFFFFFFF"));
            textPass.setTextColor(Color.parseColor("#FFFFFFFF"));
            viewImageLight.setVisibility(8);
            viewImageDark.setVisibility(0);
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            textView.setTextColor(Color.parseColor("#FF000000"));
            textRegister.setTextColor(Color.parseColor("#FF000000"));
            textMail.setTextColor(Color.parseColor("#FF000000"));
            textPass.setTextColor(Color.parseColor("#FF000000"));
            viewImageLight.setVisibility(0);
            viewImageDark.setVisibility(8);
        }

        View var10001 = this.findViewById(1000002);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.Email)");
        this.email = (EditText)var10001;
        var10001 = this.findViewById(1000009);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.password)");
        this.password = (EditText)var10001;
        var10001 = this.findViewById(1000034);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.loginbtn)");
        this.loginbtn = (Button)var10001;
        var10001 = this.findViewById(1000008);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.noaccount)");
        this.signupredirect = (TextView)var10001;
        this.auth = AuthKt.getAuth(Firebase.INSTANCE);
        Button var10000 = this.loginbtn;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginbtn");
        }

        var10000.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                CharSequence var2 = (CharSequence)SignInActivity.access$getEmail$p(SignInActivity.this).getText().toString();
                if (var2.length() != 0) {
                    var2 = (CharSequence)SignInActivity.access$getPassword$p(SignInActivity.this).getText().toString();
                    if (var2.length() != 0) {
                        SignInActivity.access$getAuth$p(SignInActivity.this).signInWithEmailAndPassword(SignInActivity.access$getEmail$p(SignInActivity.this).getText().toString(), SignInActivity.access$getPassword$p(SignInActivity.this).getText().toString()).addOnCompleteListener((OnCompleteListener)(new OnCompleteListener() {
                            public final void onComplete(@NotNull Task it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (it.isSuccessful()) {
                                    FirebaseUser user = SignInActivity.access$getAuth$p(SignInActivity.this).getCurrentUser();
                                    SignInActivity.this.load(user);
                                } else {
                                    Toast.makeText((Context)SignInActivity.this, (CharSequence)String.valueOf(it.getException()), 0).show();
                                }

                            }
                        }));
                        return;
                    }
                }

                Toast.makeText((Context)SignInActivity.this, (CharSequence)"Please fill in both fields", 0).show();
            }
        }));
        TextView var9 = this.signupredirect;
        if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signupredirect");
        }

        var9.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)SignInActivity.this, RegisterActivity.class);
                SignInActivity.this.startActivity(intent);
            }
        }));
    }

    public void onStart() {
        super.onStart();
        FirebaseAuth var10000 = this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        FirebaseUser user = var10000.getCurrentUser();
        if (user != null) {
            this.load(user);
        }

    }

    private final void load(FirebaseUser user) {
        Toast.makeText((Context)this, (CharSequence)"Authentication successful", 0).show();
        Intent intent = new Intent((Context)this, MainActivity.class);
        this.startActivity(intent);
    }

    // $FF: synthetic method
    public static final EditText access$getEmail$p(SignInActivity $this) {
        EditText var10000 = $this.email;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setEmail$p(SignInActivity $this, EditText var1) {
        $this.email = var1;
    }

    // $FF: synthetic method
    public static final EditText access$getPassword$p(SignInActivity $this) {
        EditText var10000 = $this.password;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("password");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setPassword$p(SignInActivity $this, EditText var1) {
        $this.password = var1;
    }

    // $FF: synthetic method
    public static final FirebaseAuth access$getAuth$p(SignInActivity $this) {
        FirebaseAuth var10000 = $this.auth;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auth");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setAuth$p(SignInActivity $this, FirebaseAuth var1) {
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
