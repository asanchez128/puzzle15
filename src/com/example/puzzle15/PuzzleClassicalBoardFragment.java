package com.example.puzzle15;

import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class PuzzleClassicalBoardFragment extends Fragment {

	int[] numberArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanteState) {
		View v = inflater.inflate(R.layout.fragment_puzzle_classical_board,
				parent, false);
		
		TableLayout tableLayout = (TableLayout) v
				.findViewById(R.id.fragment_puzzle_classical_tableLayout);
		
		shuffleArray(numberArray);
		int index = 0;

		for (int tableRow = 0; tableRow < tableLayout.getChildCount(); tableRow++) {
			TableRow row = (TableRow)tableLayout.getChildAt(tableRow);
			for (int tableColumn = 0; tableColumn < row.getChildCount(); tableColumn++) {
				Button button = (Button) row.getChildAt(tableColumn);
				
				if (numberArray[index] != 9) {
					button.setText("" + numberArray[index]);
					button.setBackgroundResource(R.drawable.button_enabled);
				} else {
					button.setEnabled(false);
					button.setBackgroundResource(R.drawable.button_disabled);
					createOnClickListeners(button, tableLayout, tableRow, tableColumn, index);
				}
				index++;
			}
		}
		//update(tableLayout);

		return v;
	}
	
	void update(TableLayout tableLayout) {
		
		
		shuffleArray(numberArray);
		int index = 0;

		for (int tableRow = 0; tableRow < tableLayout.getChildCount(); tableRow++) {
			TableRow row = (TableRow)tableLayout.getChildAt(tableRow);
			for (int tableColumn = 0; tableColumn < row.getChildCount(); tableColumn++) {
				Button button = (Button) row.getChildAt(tableColumn);
				
				if (numberArray[index] != 9) {
					button.setText("" + numberArray[index]);
					button.setBackgroundResource(R.drawable.button_enabled);
				} else {
					button.setEnabled(false);
					button.setBackgroundResource(R.drawable.button_disabled);
					createOnClickListeners(button, tableLayout, tableRow, tableColumn, index);
				}
				index++;
			}
		}
	}
	
	void switchButtons(Button origin, Button destination) {
		origin.setEnabled(true);
		origin.setText(destination.getText().toString());
		origin.setBackgroundResource(R.drawable.button_enabled);
		destination.setEnabled(false);
		destination.setText("");
		destination.setBackgroundResource(R.drawable.button_disabled);
	}
	
	void switchArrayValues(int index, String direction) {
		
		if(direction == "right") {
			numberArray[index] = numberArray[index + 1];
			numberArray[index + 1] = 9;	
		} else if (direction == "left") {
			numberArray[index] = numberArray[index - 1];
			numberArray[index - 1] = 9;				
		} else if (direction == "down") {
			numberArray[index] = numberArray[index + 3];
			numberArray[index + 3] = 9;	
		} else if (direction == "up") {
			numberArray[index] = numberArray[index - 3];
			numberArray[index - 3] = 9;	
		}
	}
	
	
	void createOnClickListeners(final Button emptyButton, TableLayout tableLayout, int tableRow, int tableColumn, final int index) {
		// Can it move to the right?
		if((index + 1) > 0 && (index + 1) < 9) {
			TableRow row = (TableRow)tableLayout.getChildAt(tableRow);
			final Button rightButton = (Button)row.getChildAt(tableColumn + 1);
			rightButton.setOnClickListener(new View.OnClickListener() {
	        	public void onClick(View v) {
	        		switchButtons(emptyButton, rightButton);
	        		switchArrayValues(index, "right");
	        	}
			});
		}
		// Can it move to the left?
		if((index - 1) > 0 && (index - 1) < 9) {
			TableRow row = (TableRow)tableLayout.getChildAt(tableRow);
			final Button leftButton = (Button)row.getChildAt(tableColumn - 1);
			leftButton.setOnClickListener(new View.OnClickListener() {
	        	public void onClick(View v) {
	        		switchButtons(emptyButton, leftButton);	
	        		switchArrayValues(index, "left");
	        	}
			});
		}
		// Can it move downwards?
		if((index + 3) > 0 && (index + 3) < 9) {
			TableRow row = (TableRow)tableLayout.getChildAt(tableRow + 1);
			final Button leftButton = (Button)row.getChildAt(tableColumn);
			leftButton.setOnClickListener(new View.OnClickListener() {
	        	public void onClick(View v) {
	        		switchButtons(emptyButton, leftButton);	 
	        		switchArrayValues(index, "down");
	        	}
			});
		}		
		// Can it move upwards?
		if((index - 3) > 0 && (index - 3) < 9) {
			TableRow row = (TableRow)tableLayout.getChildAt(tableRow - 1);
			final Button leftButton = (Button)row.getChildAt(tableColumn);
			leftButton.setOnClickListener(new View.OnClickListener() {
	        	public void onClick(View v) {
	        		switchButtons(emptyButton, leftButton);	
	        		switchArrayValues(index, "up");
	        	}
			});
		}
		
		//update(tableLayout);
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
