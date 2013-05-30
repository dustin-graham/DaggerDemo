package com.dustin.example.android.module;

import com.dustin.example.android.activity.MyActivity;
import com.dustin.example.android.service.DefaultPlaybackServiceClient;
import com.dustin.example.android.service.PlaybackServiceClient;
import dagger.Module;
import dagger.Provides;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Module(injects = MyActivity.class, library = true)
public class ConsoleModule {

    @Provides
    PlaybackServiceClient providePlaybackServiceClient() {
        return new DefaultPlaybackServiceClient();
    }
}
