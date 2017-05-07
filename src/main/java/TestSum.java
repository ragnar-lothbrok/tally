//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Random;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class TestSum {
//
//    @Test
//    public void test() {
//
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            int num1 = Math.abs(random.nextInt());
//            int num2 = Math.abs(random.nextInt());
//            long sum = (long) num1 + (long) num2;
//            Assert.assertEquals(sum, convertListToInteger(Solution1.getSumOfLists(convertIntegerToList(num1),
//                    convertIntegerToList(num2))));
//        }
//    }
//
//    /**
//     * Method will convert an Integer to a List
//     * 
//     * @param num
//     * @return
//     */
//    private static List<Integer> convertIntegerToList(int num) {
//        List<Integer> list = new LinkedList<Integer>();
//        while (num > 0) {
//            list.add(num % 10);
//            num = num / 10;
//        }
//        Collections.reverse(list);
//        return list;
//    }
//
//    /**
//     * Method will convert an List to an Integer
//     * 
//     * @param num
//     * @return
//     */
//    private static long convertListToInteger(List<Integer> list) {
//        long num = 0;
//        if (list != null) {
//            for (int i = 0; i < list.size(); i++) {
//                num = (num * 10) + list.get(i);
//            }
//        }
//        return num;
//    }
//}
