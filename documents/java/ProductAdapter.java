package com.astra.notes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import com.astra.notes.R.id;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\b¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"},
        d2 = {"Lcom/astra/notes/ProductAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/astra/notes/ProductAdapter$ViewHolder;", "activity", "Landroid/app/Activity;", "products", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "amounts", "", "checks", "", "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"}
)
public final class ProductAdapter extends RecyclerView.Adapter {
    private final Activity activity;
    private final ArrayList products;
    private final ArrayList amounts;
    private final ArrayList checks;

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View layout = LayoutInflater.from(parent.getContext()).inflate(1300000, parent, false);
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        return new ViewHolder(layout);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
        return (RecyclerView.ViewHolder)this.onCreateViewHolder(var1, var2);
    }

    public int getItemCount() {
        return this.products.size();
    }

    public void onBindViewHolder(@NotNull final ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object var10000 = this.products.get(position);
        Intrinsics.checkNotNullExpressionValue(var10000, "products[position]");
        String product = (String)var10000;
        var10000 = this.amounts.get(position);
        Intrinsics.checkNotNullExpressionValue(var10000, "amounts[position]");
        int amount = ((Number)var10000).intValue();
        var10000 = this.checks.get(position);
        Intrinsics.checkNotNullExpressionValue(var10000, "checks[position]");
        boolean checked = (Boolean)var10000;
        ((EditText)holder.getLayout().findViewById(id.product_name)).setText((CharSequence)product);
        ((EditText)holder.getLayout().findViewById(id.amount_num)).setText((CharSequence)String.valueOf(amount));
        CheckBox var9 = (CheckBox)holder.getLayout().findViewById(id.product_check);
        Intrinsics.checkNotNullExpressionValue(var9, "holder.layout.product_check");
        var9.setChecked(checked);
        var9 = (CheckBox)holder.getLayout().findViewById(id.product_check);
        Intrinsics.checkNotNullExpressionValue(var9, "holder.layout.product_check");
        if (var9.isChecked()) {
            EditText var6 = (EditText)holder.getLayout().findViewById(id.product_name);
            int var8 = false;
            var6.setPaintFlags(var6.getPaintFlags() | 16);
        }

        ((CheckBox)holder.getLayout().findViewById(id.product_check)).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton $noName_0, boolean isChecked) {
                EditText var3;
                boolean var5;
                if (isChecked) {
                    var3 = (EditText)holder.getLayout().findViewById(id.product_name);
                    var5 = false;
                    var3.setPaintFlags(var3.getPaintFlags() | 16);
                } else {
                    var3 = (EditText)holder.getLayout().findViewById(id.product_name);
                    var5 = false;
                    var3.setPaintFlags(var3.getPaintFlags() & ~16);
                }

            }
        }));
        ((ImageButton)holder.getLayout().findViewById(id.delete_prod)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                ProductAdapter.this.products.remove(position);
                ProductAdapter.this.amounts.remove(position);
                ProductAdapter.this.checks.remove(position);
                ProductAdapter.this.notifyDataSetChanged();
            }
        }));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
        this.onBindViewHolder((ViewHolder)var1, var2);
    }

    public ProductAdapter(@NotNull Activity activity, @NotNull ArrayList products, @NotNull ArrayList amounts, @NotNull ArrayList checks) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(amounts, "amounts");
        Intrinsics.checkNotNullParameter(checks, "checks");
        super();
        this.activity = activity;
        this.products = products;
        this.amounts = amounts;
        this.checks = checks;
    }

    @Metadata(
            mv = {1, 7, 0},
            k = 1,
            d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
            d2 = {"Lcom/astra/notes/ProductAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "layout", "Landroid/view/View;", "(Landroid/view/View;)V", "getLayout", "()Landroid/view/View;", "app_debug"}
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
