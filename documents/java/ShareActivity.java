package com.astra.notes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.astra.notes.R.id;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\n¨\u0006("},
        d2 = {"Lcom/astra/notes/ShareActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "amounts", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAmounts", "()Ljava/util/ArrayList;", "setAmounts", "(Ljava/util/ArrayList;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "id", "getId", "setId", "noteName", "getNoteName", "setNoteName", "noteSubtitle", "getNoteSubtitle", "setNoteSubtitle", "products", "getProducts", "setProducts", "userID", "getUserID", "setUserID", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class ShareActivity extends AppCompatActivity {
    private final FirebaseFirestore db;
    private final FirebaseAuth auth;
    public String noteName;
    public String noteSubtitle;
    public String id;
    public String color;
    public ArrayList userID;
    public ArrayList products;
    public ArrayList amounts;
    private HashMap _$_findViewCache;

    @NotNull
    public final String getNoteName() {
        String var10000 = this.noteName;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noteName");
        }

        return var10000;
    }

    public final void setNoteName(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.noteName = var1;
    }

    @NotNull
    public final String getNoteSubtitle() {
        String var10000 = this.noteSubtitle;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noteSubtitle");
        }

        return var10000;
    }

    public final void setNoteSubtitle(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.noteSubtitle = var1;
    }

    @NotNull
    public final String getId() {
        String var10000 = this.id;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("id");
        }

        return var10000;
    }

    public final void setId(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.id = var1;
    }

    @NotNull
    public final String getColor() {
        String var10000 = this.color;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("color");
        }

        return var10000;
    }

    public final void setColor(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.color = var1;
    }

    @NotNull
    public final ArrayList getUserID() {
        ArrayList var10000 = this.userID;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userID");
        }

        return var10000;
    }

    public final void setUserID(@NotNull ArrayList var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.userID = var1;
    }

    @NotNull
    public final ArrayList getProducts() {
        ArrayList var10000 = this.products;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("products");
        }

        return var10000;
    }

    public final void setProducts(@NotNull ArrayList var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.products = var1;
    }

    @NotNull
    public final ArrayList getAmounts() {
        ArrayList var10000 = this.amounts;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("amounts");
        }

        return var10000;
    }

    public final void setAmounts(@NotNull ArrayList var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.amounts = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300005);
        View view = this.findViewById(1000021);
        TextView textTitle = (TextView)this.findViewById(1000037);
        TextView textView = (TextView)this.findViewById(1000011);
        View viewImageDark = this.findViewById(1000049);
        View viewImageLight = this.findViewById(1000048);
        if (MainActivity.Companion.getGlobalDark()) {
            view.setBackgroundColor(Color.parseColor("#FF000000"));
            textTitle.setTextColor(Color.parseColor("#FFFFFFFF"));
            textView.setTextColor(Color.parseColor("#FFFFFFFF"));
            viewImageLight.setVisibility(8);
            viewImageDark.setVisibility(0);
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            textTitle.setTextColor(Color.parseColor("#FF000000"));
            textView.setTextColor(Color.parseColor("#FF000000"));
            viewImageLight.setVisibility(0);
            viewImageDark.setVisibility(8);
        }

        ((ImageView)this._$_findCachedViewById(com.astra.notes.R.id.imageView8)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)ShareActivity.this, MainActivity.class);
                ShareActivity.this.startActivity(intent);
            }
        }));
        ((ImageView)this._$_findCachedViewById(com.astra.notes.R.id.imageView9)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)ShareActivity.this, MainActivity.class);
                ShareActivity.this.startActivity(intent);
            }
        }));
        Button add_btn = (Button)this.findViewById(1000025);
        add_btn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                EditText id_txt = (EditText)ShareActivity.this.findViewById(1000011);
                final Ref.ObjectRef id = new Ref.ObjectRef();
                Intrinsics.checkNotNullExpressionValue(id_txt, "id_txt");
                id.element = id_txt.getText().toString();
                ShareActivity.this.db.collection("Notes").document((String)id.element).get().addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1) {
                        this.onSuccess((DocumentSnapshot)var1);
                    }

                    public final void onSuccess(DocumentSnapshot note) {
                        ShareActivity var10000 = ShareActivity.this;
                        Object var10001 = note.get("UserID");
                        if (var10001 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
                        } else {
                            var10000.setUserID((ArrayList)var10001);
                            FirebaseUser var6 = ShareActivity.this.auth.getCurrentUser();
                            if (var6 != null) {
                                String var7 = var6.getUid();
                                if (var7 != null) {
                                    String var2 = var7;
                                    int var4 = false;
                                    ShareActivity.this.getUserID().add(var2);
                                }
                            }

                            var10000 = ShareActivity.this;
                            var10001 = note.get("Name");
                            if (var10001 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            } else {
                                var10000.setNoteName((String)var10001);
                                var10000 = ShareActivity.this;
                                var10001 = note.get("Color");
                                if (var10001 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                } else {
                                    var10000.setColor((String)var10001);
                                    var10000 = ShareActivity.this;
                                    var10001 = note.get("Subtitle");
                                    if (var10001 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    } else {
                                        var10000.setNoteSubtitle((String)var10001);
                                        var10000 = ShareActivity.this;
                                        var10001 = note.get("Products");
                                        if (var10001 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
                                        } else {
                                            var10000.setProducts((ArrayList)var10001);
                                            var10000 = ShareActivity.this;
                                            var10001 = note.get("Amount");
                                            if (var10001 == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Int> /* = java.util.ArrayList<kotlin.Int> */");
                                            } else {
                                                var10000.setAmounts((ArrayList)var10001);
                                                HashMap notex = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("Name", ShareActivity.this.getNoteName()), TuplesKt.to("Subtitle", ShareActivity.this.getNoteSubtitle()), TuplesKt.to("Products", ShareActivity.this.getProducts()), TuplesKt.to("Amount", ShareActivity.this.getAmounts()), TuplesKt.to("Color", ShareActivity.this.getColor()), TuplesKt.to("UserID", ShareActivity.this.getUserID())});
                                                ShareActivity.this.db.collection("Notes").document((String)id.element).set(notex).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                                    // $FF: synthetic method
                                                    // $FF: bridge method
                                                    public void onSuccess(Object var1) {
                                                        this.onSuccess((Void)var1);
                                                    }

                                                    public final void onSuccess(Void it) {
                                                        Toast.makeText((Context)ShareActivity.this, (CharSequence)"Changes saved", 0).show();
                                                    }
                                                })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                                    public final void onFailure(@NotNull Exception it) {
                                                        Intrinsics.checkNotNullParameter(it, "it");
                                                        Utils.INSTANCE.showError((Context)ShareActivity.this, String.valueOf(it.getMessage()));
                                                    }
                                                }));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }));
                Intent intent = new Intent((Context)ShareActivity.this, MainActivity.class);
                ShareActivity.this.startActivity(intent);
            }
        }));
    }

    public ShareActivity() {
        FirebaseFirestore var10001 = FirebaseFirestore.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseFirestore.getInstance()");
        this.db = var10001;
        FirebaseAuth var1 = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(var1, "FirebaseAuth.getInstance()");
        this.auth = var1;
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
