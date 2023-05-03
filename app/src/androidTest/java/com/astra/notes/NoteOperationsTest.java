package com.astra.notes;

import android.content.Intent;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class NoteOperationsTest {

    @Rule
    public ActivityTestRule<NotesViewActivity> mActivityRule = new ActivityTestRule<>(NotesViewActivity.class, false, false);
    @Test
    public void testCopy(){
        Intent intent = new Intent();
        intent.putExtra("name", "Test");
        intent.putExtra("color", "black");
        intent.putExtra("subtitle", "Test");
        intent.putExtra("products", new ArrayList<String>());
        intent.putExtra("amounts", new ArrayList<Integer>());
        intent.putExtra("checks", new ArrayList<Boolean>());
        intent.putExtra("id", "9");
        intent.putExtra("iduser", new ArrayList<String>());
        mActivityRule.launchActivity(intent);
    }


    @Test
    public void testCreation(){
        assertEquals(NotesViewActivity.Companion.noteHashMap("Test", "null", new ArrayList<String>(),
                new ArrayList<Integer>(), new ArrayList<Boolean>(), "", new ArrayList<String>()).get("Name"), "Test");
    }
}
