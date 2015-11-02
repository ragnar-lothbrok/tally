import java.util.ArrayList;
import java.util.List;

public class Solution10 {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        int random = 5/* (int) (Math.ceil(Math.random() * 5)) */;
        System.out.println(random);
       
        List<Integer> indexes = new ArrayList<Integer>();
        int temp = random;
        while(!indexes.contains(random-1) ){
            System.out.print(arr[random-1]+" ");
            indexes.add(random-1);
            random = random + temp;
            if(random > arr.length){
                random = random % arr.length;
            }
        }
    }
    
    private static void print(int[] arr,int random){
        int temp = random - 1;
        int count = 1;
        int offset = 1;
        while (temp >= 0) {
            while (temp < arr.length) {
                System.out.print(arr[temp] + " ");
                temp = random * (++count) - offset;
            }
            offset++;
            count = 1;
            temp = random - offset;
        }
    }

}
