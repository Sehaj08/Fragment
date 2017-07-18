package in.codingninjas.courses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by manishakhattar on 08/07/17.
 */

public class Course implements Serializable {

    @SerializedName("i_d")
    private int id;
    String title;
    String name;
    String overview;
    @SerializedName("is_active")
    boolean isActive;


    public Course(int id, String title, String name, String overview) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
