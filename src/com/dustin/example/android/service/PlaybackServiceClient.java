package com.dustin.example.android.service;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PlaybackServiceClient {
    void connectToPlaybackService();
    void play();
    void pause();
    void setListener(PlaybackServiceClientListener listener);
}
