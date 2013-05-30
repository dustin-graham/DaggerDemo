package com.dustin.example.android.activity;

import com.dustin.example.android.service.PlaybackServiceClient;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 5/30/13
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */

@Module(injects = {MyActivity.class, MyActivityTest.class}, overrides = true, library = true, complete = false)
public class TestConsoleModule {
    @Provides
    @Singleton
    PlaybackServiceClient providePlaybackServiceClient() {
        return new TestPlaybackServiceClient();
    }
}
