package com.home.json;

public class RookMove {

	private Boolean validMove(int[][] chessBoard, int currX, int currY, int toX, int toY) {
		if (currX == toX && currY == toY) {
			return false;
		}

		if (isPiecePresent(chessBoard, toX, toY)) {
			return false;
		}
		if (currX == toX) {
			int diff = (toX < currX ? -1 : 1);
			for (int i = currY+diff; i != toY; i += diff) {
				if (isPiecePresent(chessBoard, toX, i)) {
					return false;
				}
			}
		} else if (currY == toY) {
			int diff = (toX < currX ? -1 : 1);
			for (int i = currX+diff; i != toX; i += diff) {
				if (isPiecePresent(chessBoard, i, currY)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	private boolean isPiecePresent(int[][] chessBoard, int toX, int toY) {
		if (chessBoard[toX][toY] == 1) {
			return false;
		}
		return true;
	}
}
