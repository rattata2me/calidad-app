package com.astra.notes;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.junit.Before;
import org.junit.Rule;

public class CreateNoteIntegrationTest {
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
            Thread.sleep(1500);
            onView(ViewMatchers.withText("Nota nueva test espresso")).check(matches(isDisplayed()));
            CollectionReference notesRef = FirebaseFirestore.getInstance().collection("Notes");
            Query query = notesRef.whereEqualTo("title_tv","Nota nueva test espresso");
            query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null && !querySnapshot.isEmpty()) {
                            // Se encontró al menos una nota con el nombre "Hola"
                        } else {
                            // No se encontró ninguna nota con el nombre "Hola"
                        }
                    } else {
                        // Error al ejecutar la consulta
                    }
                }
            });




        }
}

