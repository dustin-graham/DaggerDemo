package com.dustin.example.android;

import dagger.ObjectGraph;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 5/30/13
 * Time: 1:09 AM
 * To change this template use File | Settings | File Templates.
 */
public interface InjectibleApplication {
    ObjectGraph getApplicationGraph();
    void inject(Object object);
    List<Object> getModules();
}
