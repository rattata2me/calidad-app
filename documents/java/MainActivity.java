package com.astra.notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.astra.notes.R.id;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"},
        d2 = {"Lcom/astra/notes/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "app_debug"}
)
public final class MainActivity extends AppCompatActivity {
    private final FirebaseFirestore db;
    private final FirebaseAuth auth;
    private static boolean globalDark = true;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300001);
        View view = this.findViewById(1000010);
        if (globalDark) {
            view.setBackgroundColor(Color.parseColor("#FF000000"));
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }

        View var10000 = this.findViewById(1000064);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.floatingActionButton)");
        FloatingActionButton add_btn = (FloatingActionButton)var10000;
        add_btn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)MainActivity.this, CreateNote.class);
                MainActivity.this.startActivity(intent);
            }
        }));
        var10000 = this.findViewById(1000012);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.swrly)");
        final SwipeRefreshLayout swipeRefresh = (SwipeRefreshLayout)var10000;
        final <undefinedtype> $fun$load$2 = new Function0() {
            // $FF: synthetic method
            // $FF: bridge method
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                MainActivity.this.db.collection("Notes").get().addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                    // $FF: synthetic method
                    // $FF: bridge method
                    public void onSuccess(Object var1) {
                        this.onSuccess((QuerySnapshot)var1);
                    }

                    public final void onSuccess(QuerySnapshot notes) {
                        final List ids_documentos = (List)(new ArrayList());
                        final List names = (List)(new ArrayList());
                        final List subtitles = (List)(new ArrayList());
                        final List colors = (List)(new ArrayList());
                        final List products = (List)(new ArrayList());
                        final List amounts = (List)(new ArrayList());
                        final List checks = (List)(new ArrayList());
                        final List ids = (List)(new ArrayList());
                        FirebaseUser var10000 = MainActivity.this.auth.getCurrentUser();
                        final String currentUserId = var10000 != null ? var10000.getUid() : null;
                        int T = 0;
                        Iterator var13 = notes.iterator();

                        while(var13.hasNext()) {
                            QueryDocumentSnapshot note = (QueryDocumentSnapshot)var13.next();
                            ++T;
                            Intrinsics.checkNotNullExpressionValue(note, "note");
                            String var10001 = note.getId();
                            Intrinsics.checkNotNullExpressionValue(var10001, "note.id");
                            ids_documentos.add(var10001);
                        }

                        final Ref.ObjectRef ids_documentos_final = new Ref.ObjectRef();
                        ids_documentos_final.element = (List)(new ArrayList());
                        final int i = 0;

                        for(int var14 = T; i < var14; ++i) {
                            MainActivity.this.db.collection("Notes").document((String)ids_documentos.get(i)).get().addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
                                // $FF: synthetic method
                                // $FF: bridge method
                                public void onSuccess(Object var1) {
                                    this.onSuccess((DocumentSnapshot)var1);
                                }

                                public final void onSuccess(DocumentSnapshot note) {
                                    Object var10000 = note.get("UserID");
                                    if (var10000 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
                                    } else {
                                        ArrayList userIDS = (ArrayList)var10000;
                                        Iterator var4 = userIDS.iterator();

                                        while(var4.hasNext()) {
                                            String a = (String)var4.next();
                                            if (Intrinsics.areEqual(a, currentUserId)) {
                                                ((List)ids_documentos_final.element).add(ids_documentos.get(i));
                                                List var8 = names;
                                                Object var10001 = note.get("Name");
                                                if (var10001 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                }

                                                var8.add((String)var10001);
                                                var8 = colors;
                                                var10001 = note.get("Color");
                                                if (var10001 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                }

                                                var8.add((String)var10001);
                                                var8 = subtitles;
                                                var10001 = note.get("Subtitle");
                                                if (var10001 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                }

                                                var8.add((String)var10001);
                                                var8 = products;
                                                var10001 = note.get("Products");
                                                if (var10001 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
                                                }

                                                var8.add((ArrayList)var10001);
                                                var8 = amounts;
                                                var10001 = note.get("Amount");
                                                if (var10001 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Int> /* = java.util.ArrayList<kotlin.Int> */");
                                                }

                                                var8.add((ArrayList)var10001);
                                                if (note.get("Checks") != null) {
                                                    var8 = checks;
                                                    var10001 = note.get("Checks");
                                                    if (var10001 == null) {
                                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Boolean> /* = java.util.ArrayList<kotlin.Boolean> */");
                                                    }

                                                    var8.add((ArrayList)var10001);
                                                }

                                                var8 = ids;
                                                var10001 = note.get("UserID");
                                                if (var10001 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
                                                }

                                                var8.add((ArrayList)var10001);
                                                RecyclerView var5 = (RecyclerView)MainActivity.this._$_findCachedViewById(id.rv);
                                                int var7 = false;
                                                var5.setHasFixedSize(true);
                                                var5.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager((Context)MainActivity.this)));
                                                var5.setAdapter((RecyclerView.Adapter)(new NoteAdapter((Activity)MainActivity.this, names, subtitles, colors, products, amounts, checks, i, (List)ids_documentos_final.element, ids)));
                                            }
                                        }

                                    }
                                }
                            }));
                        }

                    }
                }));
            }
        };
        $fun$load$2.invoke();
        swipeRefresh.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener)(new SwipeRefreshLayout.OnRefreshListener() {
            public final void onRefresh() {
                $fun$load$2.invoke();
                swipeRefresh.setRefreshing(false);
            }
        }));
    }

    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.getMenuInflater().inflate(1400000, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intent intent;
        switch (item.getItemId()) {
            case 1000004:
                intent = new Intent((Context)this, ShareActivity.class);
                this.startActivity(intent);
                break;
            case 1000019:
                intent = new Intent((Context)this, SettingsActivity.class);
                this.startActivity(intent);
                break;
            case 1000038:
                this.auth.signOut();
                intent = new Intent((Context)this, SignInActivity.class);
                this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public MainActivity() {
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

    @Metadata(
            mv = {1, 7, 0},
            k = 1,
            d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"},
            d2 = {"Lcom/astra/notes/MainActivity$Companion;", "", "()V", "globalDark", "", "getGlobalDark", "()Z", "setGlobalDark", "(Z)V", "app_debug"}
    )
    public static final class Companion {
        public final boolean getGlobalDark() {
            return MainActivity.globalDark;
        }

        public final void setGlobalDark(boolean var1) {
            MainActivity.globalDark = var1;
        }

        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
