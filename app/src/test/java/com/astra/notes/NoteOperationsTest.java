package com.astra.notes;

import android.content.Intent;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class NoteOperationsTest {


    @Test
    public void testCopy(){
        assertEquals(NotesViewActivity.Companion.copyNote("Test", "null", new ArrayList<String>(),
                new ArrayList<Integer>(), new ArrayList<Boolean>(), "", new ArrayList<String>()).get("Name"), "Test- Copy");
    }


    @Test
    public void testCreation(){
        assertEquals(NotesViewActivity.Companion.noteHashMap("Test", "null", new ArrayList<String>(),
                new ArrayList<Integer>(), new ArrayList<Boolean>(), "", new ArrayList<String>()).get("Name"), "Test");
    }
}
