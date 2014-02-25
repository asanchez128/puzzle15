package com.example.puzzle15;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Puzzle15 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle15);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.puzzle15, menu);
        return true;
    }
    
}
