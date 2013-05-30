package com.dustin.example.android.activity;

import android.test.mock.MockApplication;
import com.dustin.example.android.InjectibleApplication;
import com.dustin.example.android.module.AndroidModule;
import dagger.ObjectGraph;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 5/30/13
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class MockDaggerApplication extends MockApplication implements InjectibleApplication {

    private ObjectGraph graph;

    @Override
    public void onCreate() {
        graph = ObjectGraph.create(getModules().toArray());
    }

    @Override
    public ObjectGraph getApplicationGraph() {
        return graph;
    }

    @Override
    public void inject(Object object) {
        graph.inject(object);
    }

    @Override
    public List<Object> getModules() {
        return Arrays.<Object>asList(new TestConsoleModule());
    }
}
