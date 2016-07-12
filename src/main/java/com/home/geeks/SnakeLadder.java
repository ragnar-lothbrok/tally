package com.home.geeks;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadder {

	public static void main(String[] args) {
		List<EntityObj> entityObjs = intializeSnakeAndLadders();

		int position1 = 0;
		while (true) {
			int value = throwDice();
			position1 = calculatePosition(position1, value, entityObjs);
			if (position1 == 100) {
				break;
			}
		}

	}

	private static int calculatePosition(int position1, int value, List<EntityObj> entityObjs) {
		if (value + position1 > 100) {
			System.out.println("Try again. > 100 :>> " + position1);
		} else if (value + position1 == 100) {
			position1 = value + position1;
			System.out.println("WINNER");
		} else {
			position1 = position1 + value;

			for (EntityObj entityObj : entityObjs) {
				if (entityObj.getStart() == position1) {
					position1 = entityObj.getEnd();
					System.out.println(
							(entityObj.getStart() < entityObj.getEnd() ? " Ladder :>> " + entityObj.getEnd() : " Snake :>> " + entityObj.getEnd()));
					break;
				}
			}
		}
		return position1;
	}

	private static int throwDice() {
		int random = (int) (Math.random() * 6) + 1;
		System.out.println("Dice thrown : " + random);
		return random;
	}

	private static List<EntityObj> intializeSnakeAndLadders() {
		List<EntityObj> entityObjs = new ArrayList<SnakeLadder.EntityObj>();

		EntityObj entityObj = new EntityObj();
		entityObj.setStart(3);
		entityObj.setEnd(51);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(6);
		entityObj.setEnd(27);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(20);
		entityObj.setEnd(70);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(25);
		entityObj.setEnd(5);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(36);
		entityObj.setEnd(55);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(47);
		entityObj.setEnd(19);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(63);
		entityObj.setEnd(95);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(65);
		entityObj.setEnd(52);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(68);
		entityObj.setEnd(98);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(87);
		entityObj.setEnd(57);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(99);
		entityObj.setEnd(69);
		entityObjs.add(entityObj);

		entityObj = new EntityObj();
		entityObj.setStart(91);
		entityObj.setEnd(61);
		entityObjs.add(entityObj);

		return entityObjs;
	}

	static class EntityObj {
		private int start;
		private int end;

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

	}

}
