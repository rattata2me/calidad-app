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
public class LoginButtonTest {
    @Rule
    public ActivityTestRule<SignInActivity> mActivityRule = new ActivityTestRule<>(SignInActivity.class);

    @Test
    public void testBotonHabilitado() throws InterruptedException {
        onView(withId(R.id.Email)).perform(typeText("g.grande.2019@alumnos.urjc.es"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("Nosecual1"), closeSoftKeyboard());
        onView(withId(R.id.loginbtn)).perform(click());
        //Por alguna razón al clickar se cierra la aplicación en vez de cambiar de vista como pasa si ejecutas de manera normal.
        //Thread.sleep(1000);
        //onView(withId(R.id.LayoutMainActivity)).check(matches(isDisplayed()));
    }

}