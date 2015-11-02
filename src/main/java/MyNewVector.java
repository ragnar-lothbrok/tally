import java.util.Vector;


class MyVector extends Vector 
{
    int i = 1; /* Line 5 */
    public MyVector() 
    { 
        i = 2; 
    } 
} 
public class MyNewVector extends MyVector 
{
    
    public class Inner { }

    
    public MyNewVector () 
    { 
        i = 4; /* Line 15 */
        new Inner();
    } 
    public static void main (String args []) 
    { 
        MyVector v = new MyNewVector(); /* Line 19 */
    } 
}
