// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Main {
    
    static void memthod(String fname){
        System.out.println(fname+" is my name");
    }
    static void memthod2(String fname,int age){
        System.out.println(fname+" is my name and age is "+age);
        if(age>18)
             System.out.println("Adult");
        else
             System.out.println("Not Adult");
    }
    static int memthod3(int x,int y){
        return x+y;
    }
    static int plusMethod(int x, int y) {
        return x + y;
    }

    static double plusMethod(double x, double y) {
    return x + y;
    }
    public static int sum(int k) {
        if (k > 0) {
          return k + sum(k - 1);
        } else {
          return 0;
        }
    }
    public static int sum(int beg,int end) {
        if (end > beg) {
          return end + sum(beg,end - 1);
        } else {
          return beg;
        }
    }
    public static void main(String[] args) {
        int a= 5_00_0000_00;
        int b=259;
        float c=9.8f;
        long p=898;
        boolean o=true;
        byte d=127;
        d=(byte)b;
        float f= 4.6f;
        int v=(int)f;
        byte i=40;
        byte j=30;
        int res=i*j;
        boolean result = b>=f;
        boolean result1 = b!=f;
        System.out.println(result1);
        if(a>c)
        {
            System.out.println(a);
            System.out.println("yo");
            
        }
        else
            System.out.println(c);
        int w=81;
        int value=0;
        value= w%2==0? 20 :10;
        System.out.println(value);
        int g=6;
        int val = g++;
        System.out.println(val);
        System.out.println(g);
        memthod("Kartik");
        memthod2("Clark",32);
        System.out.println(memthod3(3,2));
        int z =memthod3(5,6);
        System.out.println(z);
        int mynum1= plusMethod(3,6);
        double mynum2= plusMethod(3.6,7.9);
        System.out.println(mynum1);
        System.out.println(mynum2);
        int rez = sum(50);
        System.out.println(rez);
        int rez2 = sum(50,30);
        System.out.println(rez2);
    }
}
