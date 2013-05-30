package com.dustin.example.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.dustin.example.android.activity.BaseActivity;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        ((BaseActivity) getActivity()).inject(this);
    }
}
