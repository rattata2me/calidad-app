package com.astra.notes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.astra.notes.R.id;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"},
        d2 = {"Lcom/astra/notes/ChangeColorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class ChangeColorActivity extends AppCompatActivity {
    private final FirebaseFirestore db;
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300008);
        View view = this.findViewById(1000043);
        View textView = this.findViewById(1000017);
        View viewImageDark = this.findViewById(1000013);
        View viewImageLight = this.findViewById(1000052);
        if (MainActivity.Companion.getGlobalDark()) {
            view.setBackgroundColor(Color.parseColor("#FF000000"));
            textView.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            viewImageLight.setVisibility(8);
            viewImageDark.setVisibility(0);
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            textView.setBackgroundColor(Color.parseColor("#FF000000"));
            viewImageLight.setVisibility(0);
            viewImageDark.setVisibility(8);
        }

        ((ImageView)this._$_findCachedViewById(id.imageView10)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)ChangeColorActivity.this, MainActivity.class);
                ChangeColorActivity.this.startActivity(intent);
            }
        }));
        ((ImageView)this._$_findCachedViewById(id.imageView11)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)ChangeColorActivity.this, MainActivity.class);
                ChangeColorActivity.this.startActivity(intent);
            }
        }));
        View var10000 = this.findViewById(1000022);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.red_btn)");
        Button Red = (Button)var10000;
        var10000 = this.findViewById(1000032);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.blue_btn)");
        Button Blue = (Button)var10000;
        var10000 = this.findViewById(1000053);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.yellow_btn)");
        Button Yellow = (Button)var10000;
        var10000 = this.findViewById(1000014);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.green_btn)");
        Button Green = (Button)var10000;
        Intent var17 = this.getIntent();
        Intrinsics.checkNotNullExpressionValue(var17, "intent");
        Bundle extras = var17.getExtras();
        final String noteId = extras != null ? extras.getString("id") : null;
        final String noteName = extras != null ? extras.getString("name") : null;
        Object var18 = extras != null ? extras.get("iduser") : null;
        if (var18 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
        } else {
            final ArrayList userID = (ArrayList)var18;
            final String noteSubtitle = extras != null ? extras.getString("subtitle") : null;
            var18 = extras != null ? extras.get("products") : null;
            if (var18 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            } else {
                final ArrayList products = (ArrayList)var18;
                var18 = extras.get("amounts");
                if (var18 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Int> /* = java.util.ArrayList<kotlin.Int> */");
                } else {
                    final ArrayList amounts = (ArrayList)var18;
                    Red.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                        public final void onClick(View it) {
                            ChangeColorActivity.this.db.collection("Notes").document(String.valueOf(noteId)).update("Color", "#CB0900", new Object[0]).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                // $FF: synthetic method
                                // $FF: bridge method
                                public void onSuccess(Object var1) {
                                    this.onSuccess((Void)var1);
                                }

                                public final void onSuccess(Void it) {
                                    Intent intent = new Intent((Context)ChangeColorActivity.this, NotesViewActivity.class);
                                    intent.putExtra("name", noteName);
                                    intent.putExtra("subtitle", noteSubtitle);
                                    intent.putExtra("products", (Serializable)products);
                                    intent.putExtra("amounts", (Serializable)amounts);
                                    intent.putExtra("color", "#CB0900");
                                    intent.putExtra("iduser", (Serializable)userID);
                                    ChangeColorActivity.this.startActivity(intent);
                                }
                            })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                public final void onFailure(@NotNull Exception it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    Utils.INSTANCE.showError((Context)ChangeColorActivity.this, String.valueOf(it.getMessage()));
                                }
                            }));
                        }
                    }));
                    Blue.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                        public final void onClick(View it) {
                            ChangeColorActivity.this.db.collection("Notes").document(String.valueOf(noteId)).update("Color", "#074AA3", new Object[0]).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                // $FF: synthetic method
                                // $FF: bridge method
                                public void onSuccess(Object var1) {
                                    this.onSuccess((Void)var1);
                                }

                                public final void onSuccess(Void it) {
                                    Intent intent = new Intent((Context)ChangeColorActivity.this, NotesViewActivity.class);
                                    intent.putExtra("name", noteName);
                                    intent.putExtra("subtitle", noteSubtitle);
                                    intent.putExtra("products", (Serializable)products);
                                    intent.putExtra("amounts", (Serializable)amounts);
                                    intent.putExtra("color", "#074AA3");
                                    intent.putExtra("iduser", (Serializable)userID);
                                    ChangeColorActivity.this.startActivity(intent);
                                }
                            })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                public final void onFailure(@NotNull Exception it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    Utils.INSTANCE.showError((Context)ChangeColorActivity.this, String.valueOf(it.getMessage()));
                                }
                            }));
                        }
                    }));
                    Yellow.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                        public final void onClick(View it) {
                            ChangeColorActivity.this.db.collection("Notes").document(String.valueOf(noteId)).update("Color", "#F0D804", new Object[0]).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                // $FF: synthetic method
                                // $FF: bridge method
                                public void onSuccess(Object var1) {
                                    this.onSuccess((Void)var1);
                                }

                                public final void onSuccess(Void it) {
                                    Intent intent = new Intent((Context)ChangeColorActivity.this, NotesViewActivity.class);
                                    intent.putExtra("name", noteName);
                                    intent.putExtra("subtitle", noteSubtitle);
                                    intent.putExtra("products", (Serializable)products);
                                    intent.putExtra("amounts", (Serializable)amounts);
                                    intent.putExtra("color", "#F0D804");
                                    intent.putExtra("iduser", (Serializable)userID);
                                    ChangeColorActivity.this.startActivity(intent);
                                }
                            })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                public final void onFailure(@NotNull Exception it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    Utils.INSTANCE.showError((Context)ChangeColorActivity.this, String.valueOf(it.getMessage()));
                                }
                            }));
                        }
                    }));
                    Green.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                        public final void onClick(View it) {
                            ChangeColorActivity.this.db.collection("Notes").document(String.valueOf(noteId)).update("Color", "#328A10", new Object[0]).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                // $FF: synthetic method
                                // $FF: bridge method
                                public void onSuccess(Object var1) {
                                    this.onSuccess((Void)var1);
                                }

                                public final void onSuccess(Void it) {
                                    Intent intent = new Intent((Context)ChangeColorActivity.this, NotesViewActivity.class);
                                    intent.putExtra("name", noteName);
                                    intent.putExtra("subtitle", noteSubtitle);
                                    intent.putExtra("products", (Serializable)products);
                                    intent.putExtra("amounts", (Serializable)amounts);
                                    intent.putExtra("color", "#328A10");
                                    intent.putExtra("iduser", (Serializable)userID);
                                    ChangeColorActivity.this.startActivity(intent);
                                }
                            })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                public final void onFailure(@NotNull Exception it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    Utils.INSTANCE.showError((Context)ChangeColorActivity.this, String.valueOf(it.getMessage()));
                                }
                            }));
                        }
                    }));
                }
            }
        }
    }

    public ChangeColorActivity() {
        FirebaseFirestore var10001 = FirebaseFirestore.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseFirestore.getInstance()");
        this.db = var10001;
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
