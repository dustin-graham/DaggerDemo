package com.dustin.example.android.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.dustin.example.android.AndroidMavenApplication;
import com.dustin.example.android.InjectibleApplication;
import com.dustin.example.android.module.ActivityModule;
import com.dustin.example.android.module.DripCoffeeModule;
import dagger.ObjectGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseActivity extends FragmentActivity {

    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.

        InjectibleApplication application = (InjectibleApplication) getApplication();
        activityGraph = application.getApplicationGraph().plus(getModules().toArray());

        activityGraph.inject(this);
    }


    /**
     * A list of modules to use for the individual activity graph. Subclasses can override this
     * method to provide additional modules provided they call and include the modules returned by
     * calling {@code super.getModules()}.
     */
    protected List<Object> getModules() {
        List<Object> modules = new ArrayList<Object>();
        modules.add(new ActivityModule(this));
        modules.add(new DripCoffeeModule());
        return modules;
    }

    public void inject(Object object) {
        activityGraph.inject(object);
    }
}
