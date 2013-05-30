package com.dustin.example.android.module;

import android.content.Context;
import com.dustin.example.android.activity.BaseActivity;
import com.dustin.example.android.annotation.ForActivity;
import com.dustin.example.android.activity.MyActivity;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */

@Module ( injects = {MyActivity.class}, complete = false, library = true )
public class ActivityModule {
    private final BaseActivity activity;


    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides @Singleton @ForActivity
    Context povideActivityContext() {
        return activity;
    }

}
