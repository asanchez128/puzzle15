package com.example.puzzle15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class PuzzleClassicalBoardFragment extends Fragment {

	Board myBoard = new Board(3);
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanteState) {
		View v = inflater.inflate(R.layout.fragment_puzzle_classical_board,
				parent, false);

		final TableLayout tableLayout = (TableLayout) v
				.findViewById(R.id.fragment_puzzle_classical_tableLayout);

		int index = 0;

		for (int tableRow = 0; tableRow < tableLayout.getChildCount(); tableRow++) {
			TableRow row = (TableRow) tableLayout.getChildAt(tableRow);
			for (int tableColumn = 0; tableColumn < row.getChildCount(); tableColumn++) {
				Button button = (Button) row.getChildAt(tableColumn);

				if (!myBoard.isEmptyTile(index)) {
					button.setText("" + myBoard.getContentBoard(index));
				} else {
					button.setText("");
				}
				button.setBackgroundResource(R.drawable.button_enabled);
				button.setId(index);
				button.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						int tileIndex = v.getId();
						System.out.println(tileIndex);
						myBoard.canMove(tileIndex);
						update(tableLayout);
					}
				});
				
				index++;
			}
		}

		return v;
	}

	void update(TableLayout tableLayout) {

		int index = 0;
		for (int tableRow = 0; tableRow < tableLayout.getChildCount(); tableRow++) {
			TableRow row = (TableRow) tableLayout.getChildAt(tableRow);
			for (int tableColumn = 0; tableColumn < row.getChildCount(); tableColumn++) {
				Button button = (Button) row.getChildAt(tableColumn);

				if (!myBoard.isEmptyTile(index)) {
					button.setText("" + myBoard.getContentBoard(index));
				} else {
					button.setText("");
				}
				index++;
			}
		}
	}

	static void shuffleArray(int[] numberArray) {
		Random rnd = new Random();

		for (int i = numberArray.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			int a = numberArray[index];
			numberArray[index] = numberArray[i];
			numberArray[i] = a;
		}
	}
}
