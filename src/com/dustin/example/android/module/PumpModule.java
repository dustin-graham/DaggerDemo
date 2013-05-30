package com.dustin.example.android.module;

import com.dustin.example.android.activity.Pump;
import com.dustin.example.android.activity.Thermosiphon;
import dagger.Module;
import dagger.Provides;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Module(complete = false, library = true)
public class PumpModule {
    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
