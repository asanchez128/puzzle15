package com.example.puzzle15;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PuzzleFragment extends Fragment {
	
	Button mNewGame;
	
	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.fragment_puzzle, parent, false);
	        
	        mNewGame = (Button)v.findViewById(R.id.new_game_button);
	        mNewGame.setOnClickListener(new View.OnClickListener() {
	        	@Override
	            public void onClick(View v) {
	                Intent i = new Intent(getActivity(), PuzzleNewGameActivity.class);
	                startActivity(i);
	            }
	        });
	        return v;
	 }
}
