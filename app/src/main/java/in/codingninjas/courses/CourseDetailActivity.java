package in.codingninjas.courses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        Intent i = getIntent();
        Course c = (Course)i.getSerializableExtra("Course");
        CourseDetailFragment courseDetailFragment = (CourseDetailFragment) getFragmentManager().findFragmentById(R.id.courseDetailFragment);
        courseDetailFragment.setCourse(c);
    }
}
