package com.astra.notes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.astra.notes.R.id;
import com.google.firebase.firestore.FirebaseFirestore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 BÅ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f0\u0006\u0012\u001c\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u000bj\b\u0012\u0004\u0012\u00020\u000e`\f0\u0006\u0012\u001c\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\f0\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001c\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f0\u0006¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u000bj\b\u0012\u0004\u0012\u00020\u000e`\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"},
        d2 = {"Lcom/astra/notes/NoteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/astra/notes/NoteAdapter$ViewHolder;", "activity", "Landroid/app/Activity;", "names", "", "", "subitles", "colors", "products", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "amounts", "", "checks", "", "id", "idsnotas", "userIds", "(Landroid/app/Activity;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/util/List;Ljava/util/List;)V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"}
)
public final class NoteAdapter extends RecyclerView.Adapter {
    private final FirebaseFirestore db;
    private final Activity activity;
    private final List names;
    private final List subitles;
    private final List colors;
    private final List products;
    private final List amounts;
    private final List checks;
    private final int id;
    private final List idsnotas;
    private final List userIds;

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View layout = LayoutInflater.from(parent.getContext()).inflate(1300009, parent, false);
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        return new ViewHolder(layout);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
        return (RecyclerView.ViewHolder)this.onCreateViewHolder(var1, var2);
    }

    public int getItemCount() {
        return this.names.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final String name = (String)this.names.get(position);
        final String subtitle = (String)this.subitles.get(position);
        final String color = (String)this.colors.get(position);
        final ArrayList products_temp = (ArrayList)this.products.get(position);
        final ArrayList amounts_temp = (ArrayList)this.amounts.get(position);
        final ArrayList checks_temp = (ArrayList)this.checks.get(position);
        final String id2 = (String)this.idsnotas.get(position);
        final ArrayList userid = (ArrayList)this.userIds.get(position);
        ((CardView)holder.getLayout().findViewById(com.astra.notes.R.id.CardView)).setCardBackgroundColor(Color.parseColor(color));
        TextView var10000 = (TextView)holder.getLayout().findViewById(com.astra.notes.R.id.title_tv);
        Intrinsics.checkNotNullExpressionValue(var10000, "holder.layout.title_tv");
        var10000.setText((CharSequence)name);
        var10000 = (TextView)holder.getLayout().findViewById(com.astra.notes.R.id.subtitle_tv);
        Intrinsics.checkNotNullExpressionValue(var10000, "holder.layout.subtitle_tv");
        var10000.setText((CharSequence)subtitle);
        ((Button)holder.getLayout().findViewById(com.astra.notes.R.id.note_button)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)NoteAdapter.this.activity, NotesViewActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("color", color);
                intent.putExtra("subtitle", subtitle);
                intent.putExtra("products", (Serializable)products_temp);
                intent.putExtra("amounts", (Serializable)amounts_temp);
                intent.putExtra("checks", (Serializable)checks_temp);
                intent.putExtra("id", id2);
                intent.putExtra("iduser", (Serializable)userid);
                NoteAdapter.this.activity.startActivity(intent);
            }
        }));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
        this.onBindViewHolder((ViewHolder)var1, var2);
    }

    public NoteAdapter(@NotNull Activity activity, @NotNull List names, @NotNull List subitles, @NotNull List colors, @NotNull List products, @NotNull List amounts, @NotNull List checks, int id, @NotNull List idsnotas, @NotNull List userIds) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(subitles, "subitles");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(amounts, "amounts");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(idsnotas, "idsnotas");
        Intrinsics.checkNotNullParameter(userIds, "userIds");
        super();
        this.activity = activity;
        this.names = names;
        this.subitles = subitles;
        this.colors = colors;
        this.products = products;
        this.amounts = amounts;
        this.checks = checks;
        this.id = id;
        this.idsnotas = idsnotas;
        this.userIds = userIds;
        FirebaseFirestore var10001 = FirebaseFirestore.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseFirestore.getInstance()");
        this.db = var10001;
    }

    @Metadata(
            mv = {1, 7, 0},
            k = 1,
            d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
            d2 = {"Lcom/astra/notes/NoteAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "layout", "Landroid/view/View;", "(Landroid/view/View;)V", "getLayout", "()Landroid/view/View;", "app_debug"}
    )
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final View layout;

        @NotNull
        public final View getLayout() {
            return this.layout;
        }

        public ViewHolder(@NotNull View layout) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            super(layout);
            this.layout = layout;
        }
    }
}
