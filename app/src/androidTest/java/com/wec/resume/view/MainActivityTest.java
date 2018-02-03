package com.wec.resume.view;

import android.app.Instrumentation;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.wec.resume.R;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.Intents.times;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Pawel Raciborski on 02.02.2018.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void cantNavigateToLinkedInPageBeforeSelectingSocialButton() throws Exception {
        Intents.init();

        Matcher<Intent> expectedIntent = allOf(IntentMatchers.hasAction(Intent.ACTION_VIEW), hasData("https://www.linkedin.com/in/pawelraciborski"));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0,null));

        onView(withId(R.id.fab_linkedin)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_linkedin)).perform(click());

        intended(expectedIntent, times(0));
        Intents.release();
    }

    @Test
    public void navigateToLinkedInPage() throws Exception {
        Intents.init();

        Matcher<Intent> expectedIntent = allOf(IntentMatchers.hasAction(Intent.ACTION_VIEW), hasData("https://www.linkedin.com/in/pawelraciborski"));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0,null));

        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.fab_linkedin)).perform(click());

        intended(expectedIntent);
        Intents.release();
    }
}