import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
    public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
    	
    	
    	int x=3|5&3|5&1;
        System.out.println(x);
        
    	Calendar cal = Calendar.getInstance();
    	Date date = new Date(cal.getTimeInMillis());
    	SimpleDateFormat SQL_TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	System.out.println(SQL_TIMESTAMP_FORMAT.format(date));
    	
    	for(int i=0;i<9;i++){
    		System.out.println("$$$$"+new Random().nextInt(6));
    	}
    	
    	List<String> test = new ArrayList<String>();
    	test.add("asddsdf");
    	test.add("dsdfsdf");
//    	System.out.println(new ObjectMapper().writeValueAsString(test));
    	
    	Map<String,String> map = new  HashMap<String,String>();
    	map.put("asdasdff", "sdfsdf");
    	map.put("sdfsdf", "324234");
//    	System.out.println(new ObjectMapper().writeValueAsString(map));
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