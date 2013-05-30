package com.dustin.example.android.module;

import com.dustin.example.android.activity.ElectricHeater;
import com.dustin.example.android.activity.Heater;
import com.dustin.example.android.activity.MyActivity;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Module(injects = MyActivity.class, includes = PumpModule.class, complete = false)
public class DripCoffeeModule {
    @Provides @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }
}
