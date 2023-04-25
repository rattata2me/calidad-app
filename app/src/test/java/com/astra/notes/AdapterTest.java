package com.astra.notes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;


public class AdapterTest {

    @SuppressLint("CheckResult")
    @Test
    public void testNote(){
        NoteAdapter n = new NoteAdapter(new Activity(), new ArrayList<String>(),
                new ArrayList<String>(), new ArrayList<String>(), new ArrayList<ArrayList<String>>(),
                new ArrayList<ArrayList<Integer>>(),  new ArrayList<ArrayList<Boolean>>(), 1, new ArrayList<String>(), new ArrayList<ArrayList<String>>());
        ViewGroup vg = Mockito.mock(ViewGroup.class);
        Context cont = Mockito.mock(Context.class);
        Mockito.mockStatic(LayoutInflater.class);
        Mockito.when(vg.getContext()).thenReturn(cont);
        Assert.assertEquals(n.onCreateViewHolder(vg, 2).getClass(), NoteAdapter.ViewHolder.class);
    }

    @Test
    public void error(){
        Context context = Mockito.mock(Context.class);
        Resources.Theme th  = Mockito.mock(Resources.Theme.class);
        Mockito.mockStatic(AlertDialog.Builder.class);
        Mockito.when(th.resolveAttribute(Mockito.anyInt(), Mockito.any(TypedValue.class), Mockito.anyBoolean())).thenReturn(true);
        Mockito.when(context.getTheme()).thenReturn(th);
        Assert.assertEquals(Utils.INSTANCE.showError(context, "Error"), false);
    }
}
