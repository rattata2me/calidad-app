package com.astra.notes;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegisterTest {
    @Rule
    public ActivityTestRule<SignInActivity> mActivityRule = new ActivityTestRule<>(SignInActivity.class);

    @Test
    public void testBotonHabilitado() throws InterruptedException {
        onView(withId(R.id.noaccount)).perform(click());
        //Esto carga bien la vista register
        onView(withId(R.id.LayoutRegister)).check(matches(isDisplayed()));
        onView(withId(R.id.register_email)).perform(typeText("hola@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.register_password)).perform(typeText("Hola1234"), closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        //Sin embargo esto sigue fallando por el firebase y no llega a MainActivity.
        onView(withId(R.id.LayoutMainActivity)).check(matches(isDisplayed()));
    }

}

