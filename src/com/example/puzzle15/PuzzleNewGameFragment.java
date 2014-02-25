package com.example.puzzle15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PuzzleNewGameFragment extends Fragment {
	
	Button mStartGame;
	Button mCapturePhoto;
	
	@TargetApi(9)
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_puzzle_new_game, parent, false);
        
        mStartGame = (Button)v.findViewById(R.id.start_game_button);
        mStartGame.setOnClickListener(new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PuzzleClassicalBoardActivity.class);
                startActivity(i);
            }
        });
        
        mCapturePhoto = (Button)v.findViewById(R.id.capture_photo_button);
        mCapturePhoto.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
				//Intent i = new Intent(getActivity(), PuzzleCameraActivity.class);
				//startActivity(i);	
        		capturePhoto(v);
			}
		});
        
        // If camera is not available, disable camera functionality
        PackageManager pm = getActivity().getPackageManager();
        boolean hasACamera = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA) ||
        		pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT) ||
        		(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD &&
        		Camera.getNumberOfCameras() > 0);
        if(!hasACamera) {
        	mCapturePhoto.setEnabled(false);
        }
        return v;
	}
	
	Uri imageUri;
	final int TAKE_PICTURE = 115;

	public void capturePhoto(View view) {
	    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
		String imageFileName = "PUZZLE_IMG" + timeStamp + ".png";
	    File photoFile = new File(Environment.getExternalStorageDirectory() + "/Puzzle Pictures",  imageFileName);
	    intent.putExtra(MediaStore.EXTRA_OUTPUT,
	            Uri.fromFile(photoFile));
	    imageUri = Uri.fromFile(photoFile);
	    startActivityForResult(intent, TAKE_PICTURE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    switch (requestCode) {
	        case TAKE_PICTURE:
	            if (resultCode == Activity.RESULT_OK) {
	                Uri selectedImageUri = imageUri;
	                //Do what ever you want
	        }
	    }
	}
}
