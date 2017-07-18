package in.codingninjas.courses.network;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import in.codingninjas.courses.Course;

/**
 * Created by manishakhattar on 11/07/17.
 */

public class CourseResponse {


    public Data data;
    public int status;

   public static class Data{

        @SerializedName("courses")
        public ArrayList<Course> coursesList;

        public ArrayList<Course> getCoursesList() {
            return coursesList;
        }

        public void setCoursesList(ArrayList<Course> coursesList) {
            this.coursesList = coursesList;
        }
    }

}




