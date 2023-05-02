package com.astra.notes;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LoginIntegrationTest {

    @Rule
    public ActivityScenarioRule<SignInActivity> activityScenarioRule = new ActivityScenarioRule<>(SignInActivity.class);

    @BeforeClass
    public static void setUp() {
        FirebaseAuth.getInstance().signOut();
    }

    @Test
    public  void testLogin(){
        onView(withId(R.id.Email)).perform(typeText("s.s.2018@alumnos.urjc.es"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("contraseña"), closeSoftKeyboard());
        onView(withId(R.id.loginbtn)).perform(click());
        assertEquals(FirebaseAuth.getInstance().getCurrentUser().getEmail(),"s.s.2018@alumnos.urjc.es");
    }
    @After
    public static void logOut() {
        FirebaseAuth.getInstance().signOut();
    }
}