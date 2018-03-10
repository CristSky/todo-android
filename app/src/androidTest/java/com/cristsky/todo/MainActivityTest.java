package com.cristsky.todo;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public IntentsTestRule<MainActivity> rule = new IntentsTestRule<MainActivity>(MainActivity.class, true, false);
    @Test
    public void aoClicarNoBotaoIncluir_deveAbrirUIDeInclusaoDeTarefa() throws Exception {
        rule.launchActivity(new Intent());

//        Intent intent = new Intent();
//        intent.putExtra()

        Espresso.onView(ViewMatchers.withId(R.id.fabNovaTarefa)).perform(ViewActions.click());
        Intents.intended(IntentMatchers.hasComponent(NovaTarefaActivity.class.getName()));
        Espresso.onView(ViewMatchers.withId(R.id.edtNovaTarefa)).perform(ViewActions.typeText("Teste Inserted"));
        Espresso.onView(ViewMatchers.withId(R.id.btnSave)).perform(ViewActions.click());

        Thread.sleep(30000);
    }
}