import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// class MyThread extends Thread {
// public String text;
//
// public void run() {
// System.out.print(text);
// }
// }
//
// public class Test {
// public static void main(String args[]) {
// MyThread t1 = new MyThread();
// MyThread t2 = new MyThread();
// t1.start();
// t2.start();
// System.out.print("three ");
//
// }
//
// }
class A {
    public int GetResult(int a, int b) {
        return 0;
    }
}

class B extends A {
    public int GetResult(int a, int b) {
        return 1;
    }
}

public class Test {
    public static void main(String args[]) {
        B b = new B();
        System.out.println("x = " + b.GetResult(0, 1));
        new Test().start();

        System.out.println(daysCount("15-10-2015", "15-10-2015"));
        System.out.println(daysCount("10-06-2012", "15-10-2015"));
    }

    public static int daysCount(String input1, String input2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date1 = sdf.parse(input1);
            Date date2 = sdf.parse(input2);
            if (date1.getTime() == date2.getTime()) {
                return 0;
            }
            return (int) (1l + TimeUnit.DAYS.convert(Math.abs(date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
        }
        return 0;
    }

    // void start()
    // {
    // long [] a1 = {3,4,5};
    // long [] a2 = fix(a1);
    // System.out.print(a1[0] + a1[1] + a1[2] + " ");
    // System.out.println(a2[0] + a2[1] + a2[2]);
    // }
    //
    // long [] fix(long [] a3)
    // {
    // a3[1] = 7;
    // return a3;
    // }

    void start() {
        String s1 = "slip";
        String s2 = fix(s1);
        System.out.println(s1 + " " + s2);
    }

    String fix(String s1) {
        s1 = s1 + "stream";
        System.out.print(s1 + " ");
        return "stream";
    }
}