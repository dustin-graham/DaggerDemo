package com.dustin.example.android.activity;

import com.dustin.example.android.service.PlaybackServiceClient;
import com.dustin.example.android.service.PlaybackServiceClientListener;

/**
 * Created with IntelliJ IDEA.
 * User: dustin
 * Date: 5/30/13
 * Time: 12:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestPlaybackServiceClient implements PlaybackServiceClient {

    private PlaybackServiceClientListener mListener;

    @Override
    public void connectToPlaybackService() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void play() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setListener(PlaybackServiceClientListener listener) {
        //To change body of implemented methods use File | Settings | File Templates.
        mListener = listener;
    }

    public void sendSeconds(int seconds) {
        mListener.onSecondsChanged(seconds);
    }

    public void sendSegment(int segment) {
        mListener.onSegmentChanged(segment);
    }
}
