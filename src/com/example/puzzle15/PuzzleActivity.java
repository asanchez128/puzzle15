package com.example.puzzle15;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
public class PuzzleActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new PuzzleFragment();
    }
    
    @Override 
    public void onCreate(Bundle savedInstanceState)
    {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	super.onCreate(savedInstanceState);
    }
}
