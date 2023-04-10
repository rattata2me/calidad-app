package com.astra.notes

import android.graphics.Color
import android.view.View
import android.widget.TextView

class ColorController {
    companion object{
        val BLACKCOLOR = "#FF000000";
        val WHITECOLOR = "#FFFFFFFF";
        val REDCOLOR = "#CB0900";
        val GREENCOLOR = "#328A10";
        fun setThemeDarkLight(color : Boolean, view : View?, textView : TextView?,
                              viewImageLight : View?, viewImageDark : View?){
            if(view != null){
                view.setBackgroundColor(Color.parseColor(if(color) BLACKCOLOR else WHITECOLOR))
            }
            if(textView != null){
                setThemeView(color, textView)
            }
            if(viewImageDark != null && viewImageLight != null){
               changeVisibility(color, viewImageLight, viewImageDark)
            }
        }

        fun setThemeView(color : Boolean, view : TextView){
            view.setTextColor(Color.parseColor(if(!color) BLACKCOLOR else WHITECOLOR))
        }
        fun changeVisibility(second : Boolean, view1 : View, view2 : View){
            view1.visibility = if(second) View.GONE else View.VISIBLE
            view2.visibility = if(!second) View.GONE else View.VISIBLE
        }
    }
}