package com.balamurugan.cocubesmessagenotification;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.balamurugan.cocubesmessagenotification.network.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Balamurugan M on 7/8/2017.
 */

public class JobSchedulerService extends JobService {

    String cookie;


    @Override
    public boolean onStartJob(JobParameters params) {

        SharedPreferences pref = getSharedPreferences(Constants.PREFERENCE_NAME, 0);
        cookie = pref.getString(Constants.PREFERENCE_TAG, null);
        if(cookie != null){
            new CheckUpdate().execute();
        }

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {

        return false;
    }


    private class CheckUpdate extends AsyncTask<Void, Void,Void> {



        String dlink;
       /* @Override
        protected void onPreExecute(){

        }*/

       Response response;
        Gson gson = new Gson();



        @Override
        protected Void doInBackground(Void... params) {

            HttpURLConnection conn = null;
            StringBuilder jsonResults = new StringBuilder();
            try {

                URL url = new URL(Constants.CONTENT_URL);

                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
                conn.setRequestProperty("Referer", "https://www.cocubes.com/student/messages.aspx");
                conn.setRequestProperty("Cookie", cookie);

                InputStreamReader in = new InputStreamReader(conn.getInputStream());

                // Load the results into a StringBuilder
                int read;
                char[] buff = new char[1024];
                while ((read = in.read(buff)) != -1) {
                    jsonResults.append(buff, 0, read);
                }
            } catch (MalformedURLException e) {
                //  Log.e(LOG_TAG, "Error-PlacesAPI URL", e);
            } catch (IOException e) {
                //  Log.e(LOG_TAG, "Er-conn-toPlaces API", e);
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }

            response = gson.fromJson(jsonResults.toString(), Response.class);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {


            if(response != null) {
                SharedPreferences pref = getSharedPreferences(Constants.PREFERENCE_NAME, 0);
                long nid = pref.getLong(Constants.PREFERENCE_NID, 0);
                if (nid < response.getItems().get(0).getNID()) {

                    //show notification

                    SharedPreferences.Editor editor = pref.edit();
                    editor.putLong(Constants.PREFERENCE_NID, response.getItems().get(0).getNID());
                    editor.apply();
                }
            }

        }

    }

}

