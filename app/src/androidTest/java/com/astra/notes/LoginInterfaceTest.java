package com.astra.notes;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LoginInterfaceTest {

    @Rule
    public ActivityScenarioRule<SignInActivity> activityScenarioRule = new ActivityScenarioRule<>(SignInActivity.class);

    @BeforeClass
    public static void setUp() {
        FirebaseAuth.getInstance().signOut();
    }

   @Test
    public void testLoginOk() throws InterruptedException {
       onView(withId(R.id.Email)).perform(typeText("g.grande.2019@alumnos.urjc.es"), closeSoftKeyboard());
       onView(withId(R.id.password)).perform(typeText("Nosecual1"), closeSoftKeyboard());
       onView(withId(R.id.loginbtn)).perform(click());
       Thread.sleep(1000);
       onView(withId(R.id.LayoutMainActivity)).check(matches(isDisplayed()));
    }

    @After
    public void signOut(){
       FirebaseAuth.getInstance().signOut();
    }
}
