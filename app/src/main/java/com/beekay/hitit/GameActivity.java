package com.beekay.hitit;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class GameActivity extends FragmentActivity {

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    String uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);
        Intent i=getIntent();
        Bundle extra=i.getExtras();
        if(extra!=null){

            String imageUri=extra.getString("Uri");
            setUri(imageUri);
            Log.v("Got uri",getUri());
        }
        BigFrag bigFrag=new BigFrag();
        if(getUri()!=null) {
            Bundle bundle=new Bundle();
            bundle.putString("Uri",getUri());
            bigFrag.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.gameactivity,bigFrag).commit();
            //
        }
        else{

            getSupportFragmentManager().beginTransaction().add(R.id.gameactivity,bigFrag).commit();
        }



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}
