import java.util.Scanner;

public class test20190805 {
    public static void intearray(int [] array, int value){

        for (int i = array.length-1; i > 0 ; i--) {
                array[i]=array[i-1];
        }
        array[0]=value;

    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int[] array =new int[5];
        for (int i = 0; i <array.length ; i++) {
            int a =input.nextInt();
            intearray(array,a);
        }


        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
