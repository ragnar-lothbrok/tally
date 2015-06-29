package com.home.loylogic;

import java.util.Calendar;
import java.util.Date;

public class TestRotation {

    public static void main(String[] args) {

        String inputString = "Iamkhan";
        String rotatedString = "khanIam";

        if ((inputString + inputString).indexOf(rotatedString) != -1) {
            System.out.println(true);
        }

        Store store = null;
        setAndCreateDate(store);
        System.out.println(store);

        store = new Store();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + 1000000);
        store.setD(calendar.getTime());
        System.out.println("First : " + store);
        setDate(store);
        System.out.println("Second : " + store);
        setAndCreateDate(store);
        System.out.println("Third :" + store);
        System.out.println(store.hashCode());

        String str = new String("abc");
        store.setStoreName(str);
        System.out.println(store);
        str = "cde";
        System.out.println(store);
        str = new String("desf");
        System.out.println(store);
        
        A a = new A();
        a.setName("A");
        store.setA(a);
        
        System.out.println(store);
        
        a.setName("B");
        System.out.println(store);
        
        a = new A();
        a.setName("D");
        
        System.out.println(store);
        
        A b = store.getA();
        
        setB(b);
        
        System.out.println(store);

        
        System.out.println("#################");
        Store store1 = new Store();
        setA(store1);
        store1.getA().setName("NDTV");
        System.out.println(store1);
        setA(store1);
        System.out.println(store1);
        store1.setD(new Date());
        System.out.println(store1);
        setDateOnly(store1.getD());
        
        System.out.println(store1);
    }
    
    public static void setDateOnly(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + 1000000);
        System.out.println(calendar.getTime() + " " + new Date());
        date.setTime(calendar.getTimeInMillis());
    }

    private static void setB(A b) {
        b.setName("V");
    }

    public static void setAndCreateDate(Store store) {
        System.out.println(store != null ? store.hashCode() : null);
//        store = new Store();
        if(store == null)
            return;
        store.setD(new Date());
        store.setA(new A());
        System.out.println(store.hashCode());
        System.out.println("%%%%%%%%");
    }

    public static void setDate(Store store) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + 1000000);
        System.out.println(calendar.getTime() + " " + new Date());
        store.setD(calendar.getTime());
    }
    
    public static void setA(Store store){
        A a = new A();
        a.setName("Aaj Tak");
        store.setA(a);
    }

    static class Store {
        Date d;
        String storeName;
        A a;

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }

        public Date getD() {
            return d;
        }

        public void setD(Date d) {
            this.d = d;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        @Override
        public String toString() {
            return "Store [d=" + d + ", storeName=" + storeName + ", a=" + a + "]";
        }

    }

    static class A {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A [name=" + name + "]";
        }

    }

}
