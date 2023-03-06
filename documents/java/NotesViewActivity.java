package com.astra.notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.astra.notes.R.id;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.io.Serializable;
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
        d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u000201H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R*\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0004j\b\u0012\u0004\u0012\u00020\u0012`\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0004j\b\u0012\u0004\u0012\u00020\u0012`\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010\n¨\u00062"},
        d2 = {"Lcom/astra/notes/NotesViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "amounts", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAmounts", "()Ljava/util/ArrayList;", "setAmounts", "(Ljava/util/ArrayList;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "checks", "", "getChecks", "setChecks", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "id", "getId", "setId", "noteName", "getNoteName", "setNoteName", "noteSubtitle", "getNoteSubtitle", "setNoteSubtitle", "products", "getProducts", "setProducts", "userID", "getUserID", "setUserID", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "app_debug"}
)
public final class NotesViewActivity extends AppCompatActivity {
    private final FirebaseFirestore db;
    private final FirebaseAuth auth;
    public String noteName;
    public String noteSubtitle;
    public String id;
    public String color;
    public ArrayList userID;
    public ArrayList products;
    public ArrayList amounts;
    public ArrayList checks;
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

    @NotNull
    public final ArrayList getChecks() {
        ArrayList var10000 = this.checks;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checks");
        }

        return var10000;
    }

    public final void setChecks(@NotNull ArrayList var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.checks = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300010);
        View view = this.findViewById(1000059);
        View viewImageDark = this.findViewById(1000055);
        View viewImageLight = this.findViewById(1000054);
        if (MainActivity.Companion.getGlobalDark()) {
            view.setBackgroundColor(Color.parseColor("#FF000000"));
            viewImageLight.setVisibility(8);
            viewImageDark.setVisibility(0);
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            viewImageLight.setVisibility(0);
            viewImageDark.setVisibility(8);
        }

        Intent var10000 = this.getIntent();
        Intrinsics.checkNotNullExpressionValue(var10000, "intent");
        Bundle extras = var10000.getExtras();
        Intrinsics.checkNotNull(extras);
        this.noteName = String.valueOf(extras.getString("name"));
        this.noteSubtitle = String.valueOf(extras.getString("subtitle"));
        this.id = String.valueOf(extras.getString("id"));
        this.color = String.valueOf(extras.getString("color"));
        Object var10001 = extras.get("iduser");
        if (var10001 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
        } else {
            this.userID = (ArrayList)var10001;
            var10001 = extras.get("products");
            if (var10001 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            } else {
                this.products = (ArrayList)var10001;
                var10001 = extras.get("amounts");
                if (var10001 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Int> /* = java.util.ArrayList<kotlin.Int> */");
                } else {
                    this.amounts = (ArrayList)var10001;
                    var10001 = extras.get("checks");
                    if (var10001 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Boolean> /* = java.util.ArrayList<kotlin.Boolean> */");
                    } else {
                        this.checks = (ArrayList)var10001;
                        View var10 = this.findViewById(1000024);
                        Intrinsics.checkNotNullExpressionValue(var10, "findViewById(R.id.CardView)");
                        MaterialCardView card_vw = (MaterialCardView)var10;
                        String var12 = this.color;
                        if (var12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("color");
                        }

                        card_vw.setBackgroundColor(Color.parseColor(var12));
                        EditText var11 = (EditText)this._$_findCachedViewById(com.astra.notes.R.id.title_tv);
                        var12 = this.noteName;
                        if (var12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("noteName");
                        }

                        var11.setText((CharSequence)var12);
                        var11 = (EditText)this._$_findCachedViewById(com.astra.notes.R.id.subtitle_tv);
                        var12 = this.noteSubtitle;
                        if (var12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("noteSubtitle");
                        }

                        var11.setText((CharSequence)var12);
                        RecyclerView var7 = (RecyclerView)this._$_findCachedViewById(com.astra.notes.R.id.prod_rv);
                        int var9 = false;
                        var7.setHasFixedSize(true);
                        var7.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager((Context)this)));
                        ProductAdapter var13 = new ProductAdapter;
                        Activity var10003 = (Activity)this;
                        ArrayList var10004 = this.products;
                        if (var10004 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("products");
                        }

                        ArrayList var10005 = this.amounts;
                        if (var10005 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("amounts");
                        }

                        if (var10005 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Int> /* = java.util.ArrayList<kotlin.Int> */");
                        } else {
                            ArrayList var10006 = this.checks;
                            if (var10006 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("checks");
                            }

                            var13.<init>(var10003, var10004, var10005, var10006);
                            var7.setAdapter((RecyclerView.Adapter)var13);
                            ((ImageView)this._$_findCachedViewById(com.astra.notes.R.id.imageView4)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                                public final void onClick(View it) {
                                    Intent intent = new Intent((Context)NotesViewActivity.this, MainActivity.class);
                                    NotesViewActivity.this.startActivity(intent);
                                }
                            }));
                            ((ImageView)this._$_findCachedViewById(com.astra.notes.R.id.imageView5)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                                public final void onClick(View it) {
                                    Intent intent = new Intent((Context)NotesViewActivity.this, MainActivity.class);
                                    NotesViewActivity.this.startActivity(intent);
                                }
                            }));
                            ((ImageButton)this._$_findCachedViewById(com.astra.notes.R.id.add_btn)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                                public final void onClick(View it) {
                                    NotesViewActivity.this.getProducts().add("");
                                    NotesViewActivity.this.getAmounts().add(1);
                                    NotesViewActivity.this.getChecks().add(false);
                                    NotesViewActivity var10000 = NotesViewActivity.this;
                                    EditText var10001 = (EditText)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.title_tv);
                                    Intrinsics.checkNotNullExpressionValue(var10001, "title_tv");
                                    var10000.setNoteName(var10001.getText().toString());
                                    var10000 = NotesViewActivity.this;
                                    var10001 = (EditText)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.subtitle_tv);
                                    Intrinsics.checkNotNullExpressionValue(var10001, "subtitle_tv");
                                    var10000.setNoteSubtitle(var10001.getText().toString());
                                    int i = 0;
                                    RecyclerView var7 = (RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv);
                                    Intrinsics.checkNotNullExpressionValue(var7, "prod_rv");

                                    for(int var3 = var7.getChildCount(); i < var3; ++i) {
                                        ArrayList var8 = NotesViewActivity.this.getProducts();
                                        View var10002 = ((RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv)).getChildAt(i);
                                        Intrinsics.checkNotNullExpressionValue(var10002, "prod_rv.getChildAt(i)");
                                        EditText var11 = (EditText)var10002.findViewById(com.astra.notes.R.id.product_name);
                                        Intrinsics.checkNotNullExpressionValue(var11, "prod_rv.getChildAt(i).product_name");
                                        var8.set(i, var11.getText().toString());
                                        var8 = NotesViewActivity.this.getAmounts();
                                        var10002 = ((RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv)).getChildAt(i);
                                        Intrinsics.checkNotNullExpressionValue(var10002, "prod_rv.getChildAt(i)");
                                        var11 = (EditText)var10002.findViewById(com.astra.notes.R.id.amount_num);
                                        Intrinsics.checkNotNullExpressionValue(var11, "prod_rv.getChildAt(i).amount_num");
                                        String var4 = var11.getText().toString();
                                        var8.set(i, Integer.parseInt(var4));
                                        var8 = NotesViewActivity.this.getChecks();
                                        var10002 = ((RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv)).getChildAt(i);
                                        Intrinsics.checkNotNullExpressionValue(var10002, "prod_rv.getChildAt(i)");
                                        CheckBox var12 = (CheckBox)var10002.findViewById(com.astra.notes.R.id.product_check);
                                        Intrinsics.checkNotNullExpressionValue(var12, "prod_rv.getChildAt(i).product_check");
                                        var8.set(i, var12.isChecked());
                                    }

                                    HashMap note = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("Name", NotesViewActivity.this.getNoteName()), TuplesKt.to("Subtitle", NotesViewActivity.this.getNoteSubtitle()), TuplesKt.to("Products", NotesViewActivity.this.getProducts()), TuplesKt.to("Amount", NotesViewActivity.this.getAmounts()), TuplesKt.to("Checks", NotesViewActivity.this.getChecks()), TuplesKt.to("Color", NotesViewActivity.this.getColor()), TuplesKt.to("UserID", NotesViewActivity.this.getUserID())});
                                    CollectionReference var10 = NotesViewActivity.this.db.collection("Notes");
                                    String var9 = NotesViewActivity.this.getId();
                                    Intrinsics.checkNotNull(var9);
                                    var10.document(var9).set(note).addOnSuccessListener((OnSuccessListener)null.INSTANCE).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                        public final void onFailure(@NotNull Exception it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            Utils.INSTANCE.showError((Context)NotesViewActivity.this, String.valueOf(it.getMessage()));
                                        }
                                    }));
                                    Intent intent = new Intent((Context)NotesViewActivity.this, NotesViewActivity.class);
                                    intent.putExtra("name", NotesViewActivity.this.getNoteName());
                                    intent.putExtra("subtitle", NotesViewActivity.this.getNoteSubtitle());
                                    intent.putExtra("products", (Serializable)NotesViewActivity.this.getProducts());
                                    intent.putExtra("amounts", (Serializable)NotesViewActivity.this.getAmounts());
                                    intent.putExtra("checks", (Serializable)NotesViewActivity.this.getChecks());
                                    intent.putExtra("color", NotesViewActivity.this.getColor());
                                    intent.putExtra("id", NotesViewActivity.this.getId());
                                    intent.putExtra("iduser", (Serializable)NotesViewActivity.this.getUserID());
                                    NotesViewActivity.this.startActivity(intent);
                                }
                            }));
                            ((Button)this._$_findCachedViewById(com.astra.notes.R.id.save_btn)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                                public final void onClick(View it) {
                                    NotesViewActivity var10000 = NotesViewActivity.this;
                                    EditText var10001 = (EditText)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.title_tv);
                                    Intrinsics.checkNotNullExpressionValue(var10001, "title_tv");
                                    var10000.setNoteName(var10001.getText().toString());
                                    var10000 = NotesViewActivity.this;
                                    var10001 = (EditText)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.subtitle_tv);
                                    Intrinsics.checkNotNullExpressionValue(var10001, "subtitle_tv");
                                    var10000.setNoteSubtitle(var10001.getText().toString());
                                    int i = 0;
                                    RecyclerView var6 = (RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv);
                                    Intrinsics.checkNotNullExpressionValue(var6, "prod_rv");

                                    for(int var3 = var6.getChildCount(); i < var3; ++i) {
                                        ArrayList var7 = NotesViewActivity.this.getProducts();
                                        View var10002 = ((RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv)).getChildAt(i);
                                        Intrinsics.checkNotNullExpressionValue(var10002, "prod_rv.getChildAt(i)");
                                        EditText var10 = (EditText)var10002.findViewById(com.astra.notes.R.id.product_name);
                                        Intrinsics.checkNotNullExpressionValue(var10, "prod_rv.getChildAt(i).product_name");
                                        var7.set(i, var10.getText().toString());
                                        var7 = NotesViewActivity.this.getAmounts();
                                        var10002 = ((RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv)).getChildAt(i);
                                        Intrinsics.checkNotNullExpressionValue(var10002, "prod_rv.getChildAt(i)");
                                        var10 = (EditText)var10002.findViewById(com.astra.notes.R.id.amount_num);
                                        Intrinsics.checkNotNullExpressionValue(var10, "prod_rv.getChildAt(i).amount_num");
                                        String var4 = var10.getText().toString();
                                        var7.set(i, Integer.parseInt(var4));
                                        var7 = NotesViewActivity.this.getChecks();
                                        var10002 = ((RecyclerView)NotesViewActivity.this._$_findCachedViewById(com.astra.notes.R.id.prod_rv)).getChildAt(i);
                                        Intrinsics.checkNotNullExpressionValue(var10002, "prod_rv.getChildAt(i)");
                                        CheckBox var11 = (CheckBox)var10002.findViewById(com.astra.notes.R.id.product_check);
                                        Intrinsics.checkNotNullExpressionValue(var11, "prod_rv.getChildAt(i).product_check");
                                        var7.set(i, var11.isChecked());
                                    }

                                    HashMap note = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("Name", NotesViewActivity.this.getNoteName()), TuplesKt.to("Subtitle", NotesViewActivity.this.getNoteSubtitle()), TuplesKt.to("Products", NotesViewActivity.this.getProducts()), TuplesKt.to("Amount", NotesViewActivity.this.getAmounts()), TuplesKt.to("Checks", NotesViewActivity.this.getChecks()), TuplesKt.to("Color", NotesViewActivity.this.getColor()), TuplesKt.to("UserID", NotesViewActivity.this.getUserID())});
                                    CollectionReference var9 = NotesViewActivity.this.db.collection("Notes");
                                    String var8 = NotesViewActivity.this.getId();
                                    Intrinsics.checkNotNull(var8);
                                    var9.document(var8).set(note).addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                        // $FF: synthetic method
                                        // $FF: bridge method
                                        public void onSuccess(Object var1) {
                                            this.onSuccess((Void)var1);
                                        }

                                        public final void onSuccess(Void it) {
                                            Toast.makeText((Context)NotesViewActivity.this, (CharSequence)"Changes saved", 0).show();
                                        }
                                    })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                                        public final void onFailure(@NotNull Exception it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            Utils.INSTANCE.showError((Context)NotesViewActivity.this, String.valueOf(it.getMessage()));
                                        }
                                    }));
                                }
                            }));
                        }
                    }
                }
            }
        }
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.getMenuInflater().inflate(1400001, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String var10002;
        switch (item.getItemId()) {
            case 1000015:
                Intent intent = new Intent((Context)this, ChangeColorActivity.class);
                var10002 = this.id;
                if (var10002 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("id");
                }

                intent.putExtra("id", var10002);
                var10002 = this.noteName;
                if (var10002 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noteName");
                }

                intent.putExtra("name", var10002);
                var10002 = this.color;
                if (var10002 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("color");
                }

                intent.putExtra("color", var10002);
                var10002 = this.noteSubtitle;
                if (var10002 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noteSubtitle");
                }

                intent.putExtra("subtitle", var10002);
                ArrayList var6 = this.products;
                if (var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("products");
                }

                intent.putExtra("products", (Serializable)var6);
                var6 = this.amounts;
                if (var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("amounts");
                }

                intent.putExtra("amounts", (Serializable)var6);
                var6 = this.checks;
                if (var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checks");
                }

                intent.putExtra("checks", (Serializable)var6);
                var6 = this.userID;
                if (var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userID");
                }

                intent.putExtra("iduser", (Serializable)var6);
                this.startActivity(intent);
                break;
            case 1000038:
                CollectionReference var10000 = this.db.collection("Notes");
                String var10001 = this.id;
                if (var10001 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("id");
                }

                Intrinsics.checkNotNullExpressionValue(var10000.document(var10001).delete().addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1) {
                        this.onSuccess((Void)var1);
                    }

                    public final void onSuccess(Void it) {
                        Intent intent = new Intent((Context)NotesViewActivity.this, MainActivity.class);
                        NotesViewActivity.this.startActivity(intent);
                    }
                })).addOnFailureListener((OnFailureListener)(new OnFailureListener() {
                    public final void onFailure(@NotNull Exception it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Utils.INSTANCE.showError((Context)NotesViewActivity.this, String.valueOf(it.getMessage()));
                    }
                })), "db.collection(\"Notes\").d…())\n                    }");
                break;
            case 1000042:
                Intent var3 = new Intent();
                int var5 = false;
                var3.setAction("android.intent.action.SEND");
                var10002 = this.id;
                if (var10002 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("id");
                }

                var3.putExtra("android.intent.extra.TEXT", var10002);
                var3.setType("text/plain");
                this.startActivity(var3);
        }

        return super.onOptionsItemSelected(item);
    }

    public NotesViewActivity() {
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
