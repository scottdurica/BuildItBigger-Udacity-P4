package com.emroxriprap.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * Created by administrator on 9/20/16.
 */
public class AsyncTaskTest extends AndroidTestCase{
    CountDownLatch signal = null;
    String mResult = null;
    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testVerifyValidJokeReturn() throws InterruptedException {


        JokesTask task = new JokesTask();
        task.setListener(new JokesTask.JokeTaskListener() {
            @Override
            public void onComplete(String result) {
                mResult = result;
                signal.countDown();
            }
        }).execute();

        signal.await();
        String notConnectedMsg = "failed to connect to /10.0.2.2 (port 8080) after 20000ms: isConnected failed: ECONNREFUSED (Connection refused)";
        assertNotSame(mResult.length(),0);
        assertTrue(!(mResult.equals(notConnectedMsg)));



    }


}
