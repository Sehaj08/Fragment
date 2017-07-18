package in.codingninjas.courses;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by manishakhattar on 08/07/17.
 */

public class CoursesAsyncTask extends AsyncTask<String, Void, ArrayList<Course>> {
    OnDownloadCompleteListener mListener;

    void setOnDownloadCompleteListener(OnDownloadCompleteListener listener) {
        mListener = listener;
    }


    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected ArrayList<Course> doInBackground(String... params) {

        String urlString = params[0];

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();

            Scanner s = new Scanner(inputStream);
            String str = "";
            while (s.hasNext()) {
                str += s.nextLine();
            }

            Log.i("FetchedString ", str);
            return parseCourses(str);

        } catch (MalformedURLException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ArrayList<Course> parseCourses(String str) {

        try {
            JSONObject coursesJson = new JSONObject(str);
            JSONObject data = coursesJson.getJSONObject("data");
            JSONArray coursesJsonArray = data.getJSONArray("courses");

            ArrayList<Course> courseList = new ArrayList<>();

            for (int i = 0; i < coursesJsonArray.length(); i++) {
                JSONObject courseJson = (JSONObject) coursesJsonArray.get(i);
                int id = courseJson.getInt("id");
                String name = courseJson.getString("name");
                String title = courseJson.getString("title");
                String overview = courseJson.getString("overview");
                Course c = new Course(id, title, name, overview);
                courseList.add(c);

            }

            return courseList;


        } catch (JSONException e) {

        }
        return null;

    }

    @Override
    protected void onPostExecute(ArrayList<Course> courses) {
        super.onPostExecute(courses);
        if (mListener != null) {
            mListener.onDownloadComplete(courses);
        }
    }
}

interface OnDownloadCompleteListener {

    void onDownloadComplete(ArrayList<Course> coursesList);

}
