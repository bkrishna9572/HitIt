package com.beekay.hitit;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SettingsFrag extends Fragment {


    private static final int SELECT_PHOTO = 100;
    Uri image;

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    SettingsListener settingsListener;
    EditText address;
    Button browse,done;

    public SettingsFrag() {
        // Required empty public constructor
    }

    public interface SettingsListener{

        public void onDoneClicked(String uri);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            settingsListener=(SettingsListener)activity;
        }catch(ClassCastException e){
            Log.v("cast","settings");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_settings, container, false);
        address=(EditText)view.findViewById(R.id.address);
        browse=(Button)view.findViewById(R.id.browse);
        done=(Button)view.findViewById(R.id.done);
        address=(EditText)view.findViewById(R.id.address);
        View.OnClickListener bClick=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.browse:
                        Log.v("clicked","button browse");
                        Intent photoIntent=new Intent(Intent.ACTION_PICK);
                        photoIntent.setType("image/*");
                        startActivityForResult(photoIntent, SELECT_PHOTO);
                        break;
                    case R.id.done:
                        Log.v("done","clicked");
                        Log.v("add",address.getText().toString());
                        if(address.getText().length()!=0) {
                            settingsListener.onDoneClicked(address.getText().toString());
                           getActivity().getSupportFragmentManager().popBackStack();
                        }
                        else{
                            settingsListener.onDoneClicked(null);
                            getActivity().getSupportFragmentManager().popBackStack();
                        }
                        break;
                }
            }
        };
        browse.setOnClickListener(bClick);
        done.setOnClickListener(bClick);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SELECT_PHOTO:
                if(resultCode== Activity.RESULT_OK){
                    Uri selectedImage=data.getData();
                    setImage(selectedImage);
                    Log.v("uri","is"+selectedImage);


                    Cursor fileAddress=getActivity().getContentResolver().query(selectedImage, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
                    int columnIndex=fileAddress.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    if(fileAddress.moveToFirst()) {
                        String file = fileAddress.getString(columnIndex);
                        address.setText(file);
                        Log.v("file",file);
                    }
                }
                break;
        }
    }
}
