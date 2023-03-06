package com.astra.notes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.astra.notes.R.id;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"},
        d2 = {"Lcom/astra/notes/CreateNote;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class CreateNote extends AppCompatActivity {
    private final FirebaseFirestore db;
    private final FirebaseAuth auth;
    private final FirebaseUser currentUser;
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300004);
        View view = this.findViewById(1000026);
        View viewImageDark = this.findViewById(1000050);
        View viewImageLight = this.findViewById(1000051);
        if (MainActivity.Companion.getGlobalDark()) {
            view.setBackgroundColor(Color.parseColor("#FF000000"));
            viewImageLight.setVisibility(8);
            viewImageDark.setVisibility(0);
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            viewImageLight.setVisibility(0);
            viewImageDark.setVisibility(8);
        }

        View var10000 = this.findViewById(1000030);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.create_btn)");
        Button create_btn = (Button)var10000;
        ((ImageView)this._$_findCachedViewById(id.imageView12)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)CreateNote.this, MainActivity.class);
                CreateNote.this.startActivity(intent);
            }
        }));
        ((ImageView)this._$_findCachedViewById(id.imageView13)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)CreateNote.this, MainActivity.class);
                CreateNote.this.startActivity(intent);
            }
        }));
        create_btn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                EditText var10000 = (EditText)CreateNote.this._$_findCachedViewById(id.title_tv);
                Intrinsics.checkNotNullExpressionValue(var10000, "title_tv");
                String noteName = var10000.getText().toString();
                var10000 = (EditText)CreateNote.this._$_findCachedViewById(id.subtitle_tv);
                Intrinsics.checkNotNullExpressionValue(var10000, "subtitle_tv");
                String noteSubtitle = var10000.getText().toString();
                ArrayList products = new ArrayList();
                ArrayList amount = new ArrayList();
                ArrayList checks = new ArrayList();
                ArrayList users = new ArrayList();
                FirebaseUser var11 = CreateNote.this.currentUser;
                if (var11 != null) {
                    String var12 = var11.getUid();
                    if (var12 != null) {
                        String var8 = var12;
                        int var10 = false;
                        users.add(var8);
                    }
                }

                HashMap note = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("Name", noteName), TuplesKt.to("Subtitle", noteSubtitle), TuplesKt.to("Products", products), TuplesKt.to("Amount", amount), TuplesKt.to("Checks", checks), TuplesKt.to("Color", "#F88B39"), TuplesKt.to("UserID", users)});
                CreateNote.this.db.collection("Notes").add(note).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1) {
                        this.onSuccess((DocumentReference)var1);
                    }

                    public final void onSuccess(DocumentReference it) {
                        Intent intent = new Intent((Context)CreateNote.this, MainActivity.class);
                        CreateNote.this.startActivity(intent);
                    }
                })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                    public final void onFailure(@NotNull Exception it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Utils.INSTANCE.showError((Context)CreateNote.this, String.valueOf(it.getMessage()));
                    }
                }));
            }
        }));
    }

    public CreateNote() {
        FirebaseFirestore var10001 = FirebaseFirestore.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseFirestore.getInstance()");
        this.db = var10001;
        FirebaseAuth var1 = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(var1, "FirebaseAuth.getInstance()");
        this.auth = var1;
        this.currentUser = this.auth.getCurrentUser();
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
