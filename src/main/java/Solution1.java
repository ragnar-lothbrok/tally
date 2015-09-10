import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Solution1 {

    public static void main(String[] args) {

        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();

        Random random = new Random();
        int num = Math.abs(random.nextInt() % 10);
        for (int i = 0; i < num; i++) {
            list1.add(Math.abs(random.nextInt() % 10));
        }

        num = Math.abs(random.nextInt() % 10);
        for (int i = 0; i < num; i++) {
            list2.add(Math.abs(random.nextInt() % 10));
        }

        System.out.println("Input1 : " + list1);
        System.out.println("input2 : " + list2);
        System.out.println("Output List : " + getSumOfLists(list1, list2));

    }

    public static List<Integer> getSumOfLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultantList = new LinkedList<Integer>();
        Collections.reverse(list1);
        Collections.reverse(list2);
        if (list1 == null || list1.size() == 0) {
            if (list2 != null && list2.size() != 0) {
                resultantList.addAll(list2);
            }
        } else {
            if (list2 == null || list2.size() == 0) {
                resultantList.addAll(list1);
            } else {
                int temp = 0;
                int carry = 0;
                int i = 0;
                while (i < list1.size() && i < list2.size()) {
                    int num1 = list1.get(i);
                    int num2 = list2.get(i);
                    temp = num1 + num2 + carry;
                    resultantList.add(temp % 10);
                    if (temp >= 10) {
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    i++;
                }
                if (list1.size() > list2.size()) {
                    // i--;
                    while (i < list1.size()) {
                        temp = list1.get(i) + carry;
                        resultantList.add(temp % 10);
                        if (temp >= 10) {
                            carry = 1;
                        } else {
                            carry = 0;
                        }
                        i++;
                    }
                } else if (list1.size() < list2.size()) {
                    // i--;
                    while (i < list2.size()) {
                        temp = list2.get(i) + carry;
                        resultantList.add(temp % 10);
                        if (temp >= 10) {
                            carry = 1;
                        } else {
                            carry = 0;
                        }
                        i++;
                    }
                }
                if (carry == 1) {
                    resultantList.add(1);
                }
            }
        }
        if (resultantList != null) {
            Collections.reverse(resultantList);
        }
        return resultantList.size() == 0 ? null : resultantList;
    }
}
