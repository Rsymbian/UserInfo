package com.app.rabia.myapplication;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.app.rabia.myapplication.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
public class EspressoUITests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestFirstPageLoaded()
    {
        ViewInteraction firstTitle = onView(withId(R.id.title_heading));
        firstTitle.check(matches(withText(containsString("Title"))));
    }


    @Test
    public void TestToVerifyWhenWeClickedOnTitleDtailsPageDisplayed() {

        ViewInteraction firstTitle = onView(
                allOf(withId(R.id.title), withText("provident vel ut sit ratione est"), isDisplayed()));
        firstTitle.perform(click());

        ViewInteraction detailImage = onView(withId(R.id.detial_image));
        detailImage.check(matches(isDisplayed()));


        ViewInteraction postTitle = onView(withId(R.id.title_txt));
        postTitle.check(matches(isDisplayed()));
        postTitle.check(matches(withText(containsString("Post Title"))));

        ViewInteraction description = onView(withId(R.id.body_txt));
        description.check(matches(isDisplayed()));
        description.check(matches(withText(containsString("Description"))));

        ViewInteraction totalComments = onView(withId(R.id.total_comments_txt));
        totalComments.check(matches(isDisplayed()));
        totalComments.check(matches(withText(containsString("Total Comments"))));

        pressBack();

    }
}
