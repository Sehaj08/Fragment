package in.codingninjas.courses;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by sehaj.gulati08 on 15-07-2017.
 */

public class CourseDetailFragment extends Fragment {

    EditText nameEditText;
    EditText titleEditText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course_detail,container,false);
        nameEditText = (EditText)v.findViewById(R.id.detailNameEditText);
        titleEditText = (EditText)v.findViewById(R.id.detailTitleEditText);
        return v;
        
    }
    public void setCourse(Course c){
        nameEditText.setText(c.name);
        titleEditText.setText(c.title);
    }
}

