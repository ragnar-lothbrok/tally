package globalsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class RotateMatrix {

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 1, 11, 12 }, { 13, 14, 15, 16 } };

//		for (int i = 0; i < arr.length / 2; i++) {
//			int first = i;
//			int last = arr.length - first - i;
//
//			for (int j = first; j < last; j++) {
//
//				int offset = j - first;
//
//				int top = arr[first][j];
//				arr[first][j] = arr[last - offset][first];
//				arr[last - offset][first] = arr[last][last - offset];
//				arr[last][last - offset] = arr[j][last];
//
//				arr[j][last] = top;
//			}
//		}
		
		System.out.println(Arrays.asList(arr));
		
		Arrays.asList(arr).forEach(new Consumer<int[]>() {

			@Override
			public void accept(int[] t) {
				
			}
		});
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		iterator.next();
		((Iterator<Integer>)iterator).remove();
		System.out.println(list);
		
		
	}
}
