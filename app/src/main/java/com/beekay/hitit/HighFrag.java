package com.beekay.hitit;



import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HighFrag extends Fragment {

    TextView scoreView;
    Helper helper;

    public HighFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_high, container, false);
        scoreView=(TextView)view.findViewById(R.id.scoreshow);
        helper=new Helper(getActivity().getApplicationContext());
        helper.openRead();
        Cursor cursor=helper.retrive();
        int count=cursor.getCount();
        Log.v("count","is"+count);
        if(count>0) {
            StringBuilder builder = new StringBuilder();
            while (cursor.moveToNext()) {
                int num = cursor.getInt(cursor.getColumnIndex("myscore"));
                Log.v("num", "is" + num);
                builder.append(num);
            }
            Log.v("cursor", cursor.toString());
            helper.close();
            Log.v("builder", builder.toString());
            scoreView.setText(builder.toString());
        }
        else
        scoreView.setText("0");
        return view;

    }


}
