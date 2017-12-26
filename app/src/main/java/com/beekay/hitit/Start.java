package com.beekay.hitit;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;


public class Start extends FragmentActivity implements FragStart.FragStartListener,SettingsFrag.SettingsListener {

    FragStart startFrag;
    GameFrag gameFrag;

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    String imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          
        } else {

        }
        setContentView(R.layout.activity_start);
        if(findViewById(R.id.container)!=null){
            if(savedInstanceState!=null)
            return;
        }
        startFrag=new FragStart();
        getSupportFragmentManager().beginTransaction().add(R.id.container,startFrag).commit();


    }


    @Override
    public void playClicked(String message) {
        /*gameFrag=new GameFrag();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        //gameFrag.getMessage(message);
        ft.hide(startFrag).addToBackStack(null);
        ft.add(R.id.container,gameFrag).commit();*/
        if(getImageUri()==null) {
            Intent i = new Intent(Start.this, GameActivity.class);
            startActivity(i);
        }
        else{
            Intent i = new Intent(Start.this, GameActivity.class);
            i.putExtra("Uri", getImageUri());
            Log.v("sent Uri",getImageUri());
            startActivity(i);
        }
    }

    @Override
    public void highClicked() {
        HighFrag highFrag=new HighFrag();
        getSupportFragmentManager().beginTransaction().hide(startFrag).addToBackStack(null).add(R.id.container,highFrag).commit();
    }

    @Override
    public void settingClicked() {
        SettingsFrag settingsFrag=new SettingsFrag();
        getSupportFragmentManager().beginTransaction().hide(startFrag).addToBackStack(null).add(R.id.container,settingsFrag).commit();
    }


    @Override
    public void onDoneClicked(String uri) {

        setImageUri(uri);
        Log.v("Uri",""+uri);
        SettingsFrag settingsFrag=new SettingsFrag();
        //getSupportFragmentManager().beginTransaction().replace(R.id.container,startFrag).commit();

    }
}
