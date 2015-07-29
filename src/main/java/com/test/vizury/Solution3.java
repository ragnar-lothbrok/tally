package com.test.vizury;
interface A{
    public void abc();
}
class Exc0 extends Exception { } 
class Exc1 extends Exc0 { } /* Line 2 */
public class Solution3 
{  
    public static void main(String args[]) 
    { 
        try 
        {  
//            String s1 = "Hello";
//            StringBuffer sb = new StringBuffer(s1);
//            sb.reverse();
//            s1.concat(sb.toString());
//            System.out.println(s1 + sb + s1.length() + sb.length());
            
            String s1 = "java";
            String s2 = "java";
            String s3 = "JAVA";
            s2.toUpperCase();
            s3.toUpperCase();
            boolean b1 = s1==s2;
            boolean b2 = s1==s3;
            System.out.print(b1);
            System.out.print(" "+b2);
            throw new Exc1(); /* Line 9 */
        } 
        catch (Exc0 e0) /* Line 11 */
        {
            System.out.println("Ex0 caught"); 
        } 
        catch (Exception e) 
        {
            System.out.println("exception caught");  
        } 
    } 
}
