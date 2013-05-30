package com.dustin.example.android.service;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import javax.inject.Inject;
import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultPlaybackServiceClient implements PlaybackServiceClient {

    private static final String SECONDS_KEY = "SECONDS";
    private static final String SEGMENT_KEY = "SEGMENT";

    private int mCurrentSeconds = 0;
    private int mCurrentSegment = 0;

    private DummyServiceHandler mHandler;

    private boolean isRunning = false;

    private PlaybackServiceClientListener mListener;

    @Override
    public void connectToPlaybackService() {
        //To change body of implemented methods use File | Settings | File Templates.
        mHandler = new DummyServiceHandler(this);
    }

    @Override
    public void play() {
        isRunning = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                while (isRunning) {
                    mCurrentSeconds++;
                    if (mCurrentSeconds % 10 == 0) {
                        mCurrentSegment++;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(SECONDS_KEY,mCurrentSeconds);
                    bundle.putInt(SEGMENT_KEY,mCurrentSegment);
                    Message msg = new Message();
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }).start();
    }

    @Override
    public void pause() {
        isRunning = false;
    }

    @Override
    public void setListener(PlaybackServiceClientListener listener) {
        mListener = listener;
    }

    private static class DummyServiceHandler extends Handler {

        private WeakReference<DefaultPlaybackServiceClient> mServiceClient;
        private int mCurrentSegment;

        public DummyServiceHandler(DefaultPlaybackServiceClient serviceClient) {
            mServiceClient = new WeakReference<DefaultPlaybackServiceClient>(serviceClient);
        }

        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            if (mServiceClient.get().mListener != null) {
                mServiceClient.get().mListener.onSecondsChanged(bundle.getInt(SECONDS_KEY));
                int segment = bundle.getInt(SEGMENT_KEY);
                if (segment > mCurrentSegment) {
                    mCurrentSegment = segment;
                    mServiceClient.get().mListener.onSegmentChanged(segment);
                }
            }
        }
    }
}
