package com.example.puzzle15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.security.auth.login.LoginException;

import android.util.Log;

public class Board {
	List<Integer> numArray = new ArrayList<Integer>();
	int size;
	List<Integer> numbersBorder = new ArrayList<Integer>();
	List<Integer> validMoves = new ArrayList<Integer>();
	int empty;
	public final String TAG = "TTT";

	public Board(int s) {
		size = s;
		initBoard();
		suffleArray();
		generateBorderNumbers();
		generateValidMoves();
		empty = size * size;
	}

	private void initBoard() {
		for (int i = 0; i < size * size; ++i) {
			numArray.add(i + 1);
		}
	}

	public void suffleArray() {
		Random rnd = new Random();
		for (int i = numArray.size() - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			int a = numArray.get(index);
			numArray.set(index, numArray.get(i));
			numArray.set(i, a);
		}
	}

	public void generateBorderNumbers() {
		int n = size * size;
		for (int i = 0; i < size; ++i) {
			numbersBorder.add(n - 1);
			numbersBorder.add(n - size);
			n -= size;
		}
	}

	public void generateValidMoves() {
		validMoves.add(size);
		validMoves.add(-size);
		validMoves.add(1);
		validMoves.add(-1);
	}

	private boolean isInBorder(int a, int b) {
		return numbersBorder.contains(a) && numbersBorder.contains(b);
	}

	public void canMove(int tileIndex) {
		boolean found = false;
		for (int i = 0; i < validMoves.size() && !found; ++i) {
			int validMove = validMoves.get(i);
			Log.i(TAG, "validMove:" + validMove);
			int newIndex = tileIndex + validMove;
			Log.i(TAG, "newIndex:" + newIndex);
			if (newIndex >= 0 && newIndex < size * size) {
				if (validMove == 1 || validMove == -1) {
					if (!isInBorder(tileIndex, newIndex)) {
						
						if (isEmptyTile(newIndex)) {
							swap(newIndex, tileIndex);
							found = true;
						}
					}
				} else {
					if (isEmptyTile(newIndex)) {
						swap(newIndex, tileIndex);
						found = true;
					}				
					}
			}
		}
	}

	public void swap(int a, int b) {
		Log.i(TAG, "you did a swap");
		int temp = numArray.get(a);
		numArray.set(a, numArray.get(b));
		numArray.set(b, temp);
	}

	public int getContentBoard(int i) {
		return numArray.get(i);
	}

	public boolean isEmptyTile(int index) {
		return numArray.get(index) == empty;
	}

	public void print() {
		System.out.println("Array");
		for (int i = 0; i < numArray.size(); ++i) {
			Log.i(TAG, "" + numArray.get(i));
		}

	}
}
