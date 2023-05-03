package com.astra.notes;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RegisterInterfaceTest {

    @Rule
    public ActivityScenarioRule<SignInActivity> activityScenarioRule = new ActivityScenarioRule<>(SignInActivity.class);

    @BeforeClass
    public static void signOut(){
        FirebaseAuth.getInstance().signOut();
    }

    @Test
    public void testBotonHabilitado() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.noaccount)).perform(click());
        onView(withId(R.id.LayoutRegister)).check(matches(isDisplayed()));
        onView(withId(R.id.register_email)).perform(typeText("hola3@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.register_password)).perform(typeText("Hola1234"), closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.LayoutMainActivity)).check(matches(isDisplayed()));
    }

    @AfterClass
    public static void deleteUserCreated(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.delete();
    }

}

