package com.dustin.example.android.service;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PlaybackServiceClientListener {
    void onSecondsChanged(int seconds);
    void onSegmentChanged(int segmentIndex);
}
