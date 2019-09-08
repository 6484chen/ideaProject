import java.util.Scanner;
import java.util.Vector;

public class VectorArray {
    //按分数给出分数等级
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Vector v = new Vector();
        while (true){
             int a=input.nextInt();
             if(a<0)
                 break;
             //Student st = new Student("wangchen",99);
             v.addElement(a);

        }
        int max =0;
        for (int i = 0; i <v.size() ; i++) {
            int a = (int)v.elementAt(i);
            if(max< a)
                max=a;
        }

        for (int i = 0; i <v.size() ; i++) {
            int a = (int)v.elementAt(i);

            if(max-a<10) {
                System.out.println("成绩：" + a + "等级A");
            }else if(max-a<20) {
                System.out.println("成绩：" + a + "等级B");
            }else{
                System.out.println("成绩：" + a );
            }
        }

    }
}
