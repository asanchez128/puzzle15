package com.example.puzzle15;

import android.support.v4.app.Fragment;

public class PuzzleClassicalBoardActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new PuzzleClassicalBoardFragment();
	}

}
