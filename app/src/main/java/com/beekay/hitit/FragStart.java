package com.beekay.hitit;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class FragStart extends Fragment {

    FragStartListener listener;

    public FragStart() {
        // Required empty public constructor
    }

    public interface FragStartListener{

        public void playClicked(String message);
        public void highClicked();
        public void settingClicked();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (FragStartListener) activity;
        }catch (ClassCastException e){
            Log.v("Should ","implement interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.frag_start,container,false);

        ImageButton play=(ImageButton)view.findViewById(R.id.play_but);

        ImageButton score=(ImageButton)view.findViewById(R.id.score_but);
        ImageButton sett=(ImageButton)view.findViewById(R.id.sett);
        View.OnClickListener click=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            switch (view.getId()){
                case R.id.play_but:
                    Log.v("play","clicked");
                    listener.playClicked("Play clicked");
                    break;
                case R.id.score_but:
                    Log.v("High","Clicked");
                    listener.highClicked();
                    break;
                case R.id.sett:
                    listener.settingClicked();
                    break;
            }
            }
        };
        play.setOnClickListener(click);
        score.setOnClickListener(click);
        sett.setOnClickListener(click);
        return view;
    }


}
