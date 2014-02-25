package com.example.puzzle15;

import android.support.v4.app.Fragment;

public class PuzzleNewGameActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new PuzzleNewGameFragment();
    }
}
