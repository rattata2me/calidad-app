package com.astra.notes

import android.content.Context
import androidx.appcompat.app.AlertDialog

public object Utils {
    public fun showError(context: Context, message: String): Boolean {
        if (context.applicationContext != null){
            AlertDialog.Builder(context).apply {
                setTitle("Error")
                setMessage(message)
                setPositiveButton("Aceptar", null)
            }.show();
            return true;
        }else
            return false;
    }
}