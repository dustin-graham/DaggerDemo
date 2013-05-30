package com.dustin.example.android.module;

import android.content.Context;
import android.location.LocationManager;
import com.dustin.example.android.AndroidMavenApplication;
import com.dustin.example.android.annotation.ForApplication;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Module(library = true)
public class AndroidModule {
    private final AndroidMavenApplication application;


    public AndroidModule(AndroidMavenApplication application) {
        this.application = application;
    }

    @Provides @Singleton @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
}
