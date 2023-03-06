// SplashScreenActivity$onCreate$$inlined$timerTask$1.java
package com.astra.notes;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        xi = 48,
        d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"},
        d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}
)
@SourceDebugExtension({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n+ 2 SplashScreenActivity.kt\ncom/astra/notes/SplashScreenActivity\n*L\n1#1,148:1\n18#2:149\n*E\n"})
public final class SplashScreenActivity$onCreate$$inlined$timerTask$1 extends TimerTask {
    // $FF: synthetic field
    final SplashScreenActivity this$0;

    public SplashScreenActivity$onCreate$$inlined$timerTask$1(SplashScreenActivity var1) {
        this.this$0 = var1;
    }

    public void run() {
        TimerTask $this$timerTask = (TimerTask)this;
        int var2 = false;
        this.this$0.load();
    }
}
// SplashScreenActivity.java
package com.astra.notes;

        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import androidx.appcompat.app.AppCompatActivity;
        import java.util.HashMap;
        import java.util.Timer;
        import java.util.TimerTask;
        import kotlin.Metadata;
        import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 7, 0},
        k = 1,
        d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"},
        d2 = {"Lcom/astra/notes/SplashScreenActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "load", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@SuppressLint({"CustomSplashScreen"})
public final class SplashScreenActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300003);
        (new Timer()).schedule((TimerTask)(new SplashScreenActivity$onCreate$$inlined$timerTask$1(this)), 1500L);
    }

    public final void load() {
        Intent intent = new Intent((Context)this, SignInActivity.class);
        this.startActivity(intent);
        this.finish();
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
