package com.dustin.example.android.activity;

import android.util.Log;
import dagger.Lazy;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoffeeMaker {

    @Inject
    Lazy<Heater> heater;
    @Inject
    Pump pump;


    public void brew() {
        heater.get().on();
        pump.pump();
        Log.d("CoffeeMaker", "coffee!");
        heater.get().off();
    }
}
