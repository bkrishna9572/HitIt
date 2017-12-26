package com.beekay.hitit;



import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class BigFrag extends Fragment {

    private int count=1;
    BigFragListener bigListener;
    Handler handler=new Handler();
    Helper helper;
    String imageUri;
    Drawable image;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    int score;
    public TableLayout tl;
    public ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9;

    public Boolean getClicked() {
        return clicked;
    }

    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    Boolean clicked=true;
    TextView strikes,scores;


    public BigFrag() {
        // Required empty public constructor
    }

    public interface BigFragListener{
        public void setClickValue(boolean clicked);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.big_frag,container,false);
        Bundle extra=this.getArguments();
        if(extra!=null) {
            try {
                String uri = extra.getString("Uri");
                setImageUri(uri);
            }catch (NullPointerException e){
                Log.v("no ","uri");
            }
        }


        //initializing views
        tl=(TableLayout)view.findViewById(R.id.big_fragment);
        strikes=(TextView)view.findViewById(R.id.strikes);
        scores=(TextView)view.findViewById(R.id.scores);
        ib1=(ImageButton)view.findViewById(R.id.ib1);
        ib2=(ImageButton)view.findViewById(R.id.ib2);
        ib3=(ImageButton)view.findViewById(R.id.ib3);
        ib4=(ImageButton)view.findViewById(R.id.ib4);
        ib5=(ImageButton)view.findViewById(R.id.ib5);
        ib6=(ImageButton)view.findViewById(R.id.ib6);
        ib7=(ImageButton)view.findViewById(R.id.ib7);
        ib8=(ImageButton)view.findViewById(R.id.ib8);
        ib9=(ImageButton)view.findViewById(R.id.ib9);

        //setting onclicklistener for views
        View.OnClickListener buttonListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){
                    case R.id.ib1:
                        ib1.setVisibility(View.INVISIBLE);
                        ib1.removeCallbacks(null);
                        tl.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        break;
                    case R.id.ib2:
                        ib2.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        tl.setVisibility(View.INVISIBLE);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        ib2.removeCallbacks(null);

                        break;
                    case R.id.ib3:
                        ib3.setVisibility(View.INVISIBLE);
                        tl.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        ib3.removeCallbacks(null);

                        break;
                    case R.id.ib4:
                        ib4.setVisibility(View.INVISIBLE);
                        tl.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        ib5.removeCallbacks(null);

                        break;
                    case R.id.ib5:
                        ib5.setVisibility(View.INVISIBLE);
                        tl.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        ib6.removeCallbacks(null);

                        break;
                    case R.id.ib6:
                        ib6.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        tl.setVisibility(View.INVISIBLE);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        ib6.removeCallbacks(null);

                        break;
                    case R.id.ib7:
                        ib7.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        setScore(getScore()+10);
                        tl.setVisibility(View.INVISIBLE);
                        scores.setText(Integer.toString(score));
                        ib7.removeCallbacks(null);
                        break;
                    case R.id.ib8:
                        ib8.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        tl.setVisibility(View.INVISIBLE);
                        ib8.removeCallbacks(null);
                        break;
                    case R.id.ib9:
                        ib9.setVisibility(View.INVISIBLE);
                        setClicked(true);
                        tl.setVisibility(View.INVISIBLE);
                        setScore(getScore()+10);
                        scores.setText(Integer.toString(score));
                        ib9.removeCallbacks(null);
                        break;
                    default: setClicked(false);
                }


            }
        };

        //assigning onclicklistener to views
        ib1.setOnClickListener(buttonListener);
        ib2.setOnClickListener(buttonListener);
        ib3.setOnClickListener(buttonListener);
        ib4.setOnClickListener(buttonListener);
        ib5.setOnClickListener(buttonListener);
        ib6.setOnClickListener(buttonListener);
        ib7.setOnClickListener(buttonListener);
        ib8.setOnClickListener(buttonListener);
        ib9.setOnClickListener(buttonListener);


        //making views visible
       // play();
        if(getImageUri()==null){
            Log.v("imageUri",""+imageUri);
            image= getResources().getDrawable(R.drawable.ic_appear);
        }
        else {
            File imgFile=new File(getImageUri());
            if(imgFile.exists()){
                Bitmap hitImage=BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                hitImage=hitImage.createScaledBitmap(hitImage,300,300,false);
                image=new BitmapDrawable(getResources(),hitImage);


            }
        }



        return view;
    }


    public void play(){
        final Random random=new Random();


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int segment=random.nextInt(9);
                Log.v("segment","is"+segment);
                int max=900;
                int min=600;
                int randomTime=random.nextInt(max-min+1)+min;
                setVisibility(segment,randomTime);
                Log.v("clicked","is"+clicked);
                if(!getClicked()) {
                    if (strikes.getText().toString().equals("Strikes | | |")) {
                        strikes.setText("Strikes | | X");
                    } else if (strikes.getText().toString().equals("Strikes | | X")) {
                        strikes.setText("Strikes | X X");
                    } else if (strikes.getText().toString().equals("Strikes | X X")) {
                        strikes.setText("Strikes X X X");
                        insertScore(score);
                    }
                }
                if(!strikes.getText().toString().equals("Strikes X X X"))
                    handler.postDelayed(this, 500);
            }
        };

            handler.postDelayed(runnable, 500);



    }

    private void insertScore(int score) {

        List<Integer> builder=new ArrayList<Integer>();
        helper=new Helper(getActivity().getApplicationContext());
            helper.open();
        Cursor cursor=helper.retrive();
        if(cursor.getCount()==0)
        {
            helper.insertData(score);
            helper.close();
        }
        else {
            while (cursor.moveToNext()) {
                builder.add(cursor.getInt(cursor.getColumnIndex("myscore")));
            }
            if (getScore() > builder.get(0)) {
                helper.insertData(score);
                helper.close();
            }
        }


    }

    private void setVisibility(int segment, int randomTime) {


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if(ib1.getVisibility()==View.VISIBLE){
                    ib1.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib2.getVisibility()==View.VISIBLE){
                    ib2.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib3.getVisibility()==View.VISIBLE){
                    ib3.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib4.getVisibility()==View.VISIBLE){
                    ib4.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib5.getVisibility()==View.VISIBLE){
                    ib5.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib6.getVisibility()==View.VISIBLE){
                    ib6.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib7.getVisibility()==View.VISIBLE){
                    ib7.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib8.getVisibility()==View.VISIBLE){
                    ib8.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                if(ib9.getVisibility()==View.VISIBLE){
                    ib9.setVisibility(View.INVISIBLE);
                    tl.setVisibility(View.INVISIBLE);
                    setClicked(false);
                }
                //setClicked(false);
            }
        };


//making views visible
        switch (segment){
            case 0:

                ib1.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib1.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;
            case 1:
                ib2.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib2.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;
            case 2:
                ib3.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib3.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;
            case 3:
                ib4.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib4.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable,randomTime);
                break;
            case 4:
                ib5.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib5.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;
            case 5:
                ib6.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib6.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;
            case 6:
                ib7.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib7.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;
            case 7:
                ib8.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib8.setImageDrawable(image);
                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;
            case 8:
                ib9.setVisibility(View.VISIBLE);
                tl.setVisibility(View.VISIBLE);
                ib9.setImageDrawable(image);


                Log.v("is","visible now");
                handler.postDelayed(runnable, randomTime);
                break;

        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
    }

   @Override
    public void onResume() {
        super.onResume();
       if(!strikes.getText().toString().equals("Strikes X X X"))
        play();

    }
}





