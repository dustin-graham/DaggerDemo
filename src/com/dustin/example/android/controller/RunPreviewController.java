package com.dustin.example.android.controller;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RunPreviewController {
    void setDisplay(RunPreviewController display);
    void onCreate(long workoutId);
    void onResume(long workoutId);
    void onStart();
    void prepareWorkout();
    void onWorkoutLaunchRequested();
}
