// Generated code from Butter Knife. Do not modify!
package com.dustin.example.android.activity;

import android.view.View;
import butterknife.Views.Finder;

public class MyActivity$$ViewInjector {
  public static void inject(Finder finder, com.dustin.example.android.activity.MyActivity target, Object source) {
    View view;
    view = finder.findById(source, 2131034114);
    target.secondsValueTextView = (android.widget.TextView) view;
    view = finder.findById(source, 2131034115);
    target.segmentValueTextView = (android.widget.TextView) view;
  }
}
