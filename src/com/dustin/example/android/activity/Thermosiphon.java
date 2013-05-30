package com.dustin.example.android.activity;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Thermosiphon implements Pump {
    private final Heater heater;

    @Inject
    public Thermosiphon(Heater heater) {
        this.heater = heater;
    }


    @Override
    public void pump() {
        if (heater.isHot()) {
            System.out.println("pumping");
        }
    }
}
