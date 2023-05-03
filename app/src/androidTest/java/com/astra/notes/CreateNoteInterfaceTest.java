package com.astra.notes;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class CreateNoteInterfaceTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void signIn(){
        FirebaseAuth.getInstance().signOut();
        FirebaseAuth.getInstance().signInWithEmailAndPassword("g.grande.2019@alumnos.urjc.es", "Nosecual1");
    }

   @Test
    public void testNoteCreated() throws InterruptedException {
        Thread.sleep(1000);
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.title_tv)).perform(typeText("Nota nueva test espresso"), closeSoftKeyboard());
        onView(withId(R.id.subtitle_tv)).perform(typeText("Test"), closeSoftKeyboard());
        onView(withId(R.id.create_btn)).perform(click());
       Thread.sleep(5500);
        Thread.sleep(1500);
        onView(ViewMatchers.withText("Nota nueva test espresso")).check(matches(isDisplayed()));
    }

   @After
    public void deleteCreatedNote(){
       try {
           Thread.sleep(5500);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       onView(ViewMatchers.withText("Nota nueva test espresso")).perform(click());
       try {
           Thread.sleep(5500);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       onView(withContentDescription("More options")).perform(click());
       try {
           Thread.sleep(5500);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       onView(ViewMatchers.withText("Borrar")).perform(click());
       FirebaseAuth.getInstance().signOut();
   }

}
