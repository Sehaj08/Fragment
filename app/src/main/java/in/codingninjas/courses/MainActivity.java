package in.codingninjas.courses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements CourseListFragment.CoursesFragmentListItemClick {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CourseListFragment courseListFragment = (CourseListFragment) getSupportFragmentManager().findFragmentById(R.id.courseListFragment);
        courseListFragment.setCoursesFragmentListItemClick(this);

        Course c = new Course(12,"Android","Envision","xyz");
        Gson gson = new Gson();

        String json = gson.toJson(c);
        Log.i("JSONString", json);
        Course c2 = gson.fromJson(json, Course.class);
//        Log.i("JSONString", "Object "+ c2.title);


    }


    @Override
    public void onListItemClicked(Course c) {
        Toast.makeText(this, c.name+" clicked ", Toast.LENGTH_SHORT).show();

        FrameLayout frameLayout =  (FrameLayout) findViewById(R.id.containerLayout);
        if(frameLayout == null){
            Intent i = new Intent(MainActivity.this,CourseDetailActivity.class);
            i.putExtra("Course",c);
            startActivity(i);
        }else{
            CourseDetailFragment courseDetailFragment = (CourseDetailFragment) getFragmentManager().findFragmentById(R.id.courseDetailFragment);
            courseDetailFragment.setCourse(c);
        }


    }
}
