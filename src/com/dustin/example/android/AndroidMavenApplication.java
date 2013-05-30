package com.dustin.example.android;

import android.app.Application;
import com.dustin.example.android.module.AndroidModule;
import dagger.ObjectGraph;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class AndroidMavenApplication extends Application implements InjectibleApplication {


    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
    }

    public List<Object> getModules() {
        return Arrays.<Object>asList(new AndroidModule(this));
    }

    public ObjectGraph getApplicationGraph() {
        return graph;
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
