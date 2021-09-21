package testCases;

import org.testng.annotations.Test;

/**Estos tests van de acuerdo al valor seteado en priority
then will print EDCBA
othewise will print according method name starting ... ABCDE */
public class Priority {
    @Test(priority = 2)
    public void c_method(){
        System.out.println("I'm in method C");
    }
    @Test(priority = 3)
    public void b_method(){
        System.out.println("I'm in method B");
    }
    @Test(priority = 4)
    public void a_method(){
        System.out.println("I'm in method A");
    }
    @Test(priority = 0)
    public void e_method(){
        System.out.println("I'm in method E");
    }
    @Test(priority = 1)
    public void d_method(){
        System.out.println("I'm in method D");
    }
}
