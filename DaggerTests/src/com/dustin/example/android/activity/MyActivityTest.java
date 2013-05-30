package com.dustin.example.android.activity;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.widget.TextView;
import com.dustin.example.android.maven.R;
import com.dustin.example.android.service.DefaultPlaybackServiceClient;
import com.dustin.example.android.service.PlaybackServiceClient;
import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.dustin.example.android.activity.MyActivityTest \
 * com.dustin.example.android.maven.tests/android.test.InstrumentationTestRunner
 */
public class MyActivityTest extends ActivityUnitTestCase<MyActivity> {

    private MyActivity myActivity;
    @Inject
    PlaybackServiceClient playbackServiceClient;

    public MyActivityTest() {
        super(MyActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockDaggerApplication mockDaggerApplication = new MockDaggerApplication();
        mockDaggerApplication.onCreate();
        setApplication(mockDaggerApplication);
        Intent intent = new Intent(getInstrumentation().getTargetContext(), MyActivity.class);
        startActivity(intent, null, null);
        myActivity = getActivity();
        mockDaggerApplication.inject(myActivity);
        mockDaggerApplication.inject(this);
    }

    public void testLabels() {
        assertNotNull(myActivity.findViewById(R.id.secondLabel));
        TextView secondsValueTextView = (TextView) myActivity.findViewById(R.id.secondValue);
        TextView segmentValueTextView = (TextView) myActivity.findViewById(R.id.segmentValue);
        assertEquals("0", secondsValueTextView.getText().toString());
        TestPlaybackServiceClient client = (TestPlaybackServiceClient) playbackServiceClient;

        for (int i = 0; i < 20; i++) {
            client.sendSeconds(i);
            client.sendSegment(i*2);
            assertEquals(String.valueOf(i), secondsValueTextView.getText().toString());
            assertEquals(String.valueOf(i*2), segmentValueTextView.getText().toString());

        }
    }

}
