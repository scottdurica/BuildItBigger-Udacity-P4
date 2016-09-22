package com.emroxriprap.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.emroxriprap.jokeuilibrary.JokeActivity;
import com.example.administrator.myapplication.backend.jokeApi.JokeApi;
import com.example.administrator.myapplication.backend.jokeApi.model.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by administrator on 9/20/16.
 */
public class JokesTask extends AsyncTask<String,Integer,String>{


    public static final String LOG_TAG = JokesTask.class.getSimpleName();
    private static JokeApi myJokeService = null;
    private Context context;
    private JokeTaskListener mListener = null;

    public interface JokeTaskListener{
        void onComplete(String result);
    }


    public JokesTask(Context context) {
        this.context = context;
    }
    public JokesTask(){}

    public JokesTask setListener(JokeTaskListener listener){
        this.mListener = listener;
        return this;
    }
    @Override
    protected String doInBackground(String... params) {
        if(myJokeService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myJokeService = builder.build();
        }
        try {
            Joke joke = myJokeService.getJoke(1l).execute();
            return joke.getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }

    }



    @Override
    protected void onPostExecute(String result) {
        //this will only be non null for the AndroidTest.
        final String fResult = result;
        if (mListener != null){
            mListener.onComplete(result);
        }else{
            //delay return of result to keep "loading"progress spinner from almost instantly disappearing from screen.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d(LOG_TAG, "Fetched joke from GCE");
                    Intent intent = new Intent(context, JokeActivity.class);
                    intent.putExtra("joke", fResult);
                    context.startActivity(intent);
                }
            },800);


        }


    }
}
