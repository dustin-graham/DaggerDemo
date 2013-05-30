package com.dustin.example.android.activity;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Views;
import com.dustin.example.android.maven.R;
import com.dustin.example.android.module.ConsoleModule;
import com.dustin.example.android.service.PlaybackServiceClient;
import com.dustin.example.android.service.PlaybackServiceClientListener;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends BaseActivity implements PlaybackServiceClientListener {

    @Inject
    PlaybackServiceClient mPlaybackServiceClient;

    @InjectView(R.id.secondValue)TextView secondsValueTextView;

    @InjectView(R.id.segmentValue)TextView segmentValueTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Views.inject(this);

        mPlaybackServiceClient.connectToPlaybackService();
        mPlaybackServiceClient.setListener(this);
        mPlaybackServiceClient.play();
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new ArrayList<Object>();
        modules.add(new ConsoleModule());
        modules.addAll(super.getModules());
        return modules;
    }

    @Override
    public void onSecondsChanged(int seconds) {
        secondsValueTextView.setText(String.valueOf(seconds));
    }

    @Override
    public void onSegmentChanged(int segmentIndex) {
        segmentValueTextView.setText(String.valueOf(segmentIndex));
    }
}
