package com.dustin.example.android.activity;

import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElectricHeater implements Heater {

    boolean heating;

    @Override
    public void on() {
        Log.d("CoffeeMaker", "heating");
        this.heating = true;
    }

    @Override
    public void off() {
        this.heating = false;
    }

    @Override
    public boolean isHot() {
        return heating;
    }
}
