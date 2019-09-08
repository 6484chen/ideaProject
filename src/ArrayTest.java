import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        //yangHuiSanJiao();
        //arrayExcel();
        //midSeach();
        //bubbleSort();
        //arraysUtils();
        halfSort();
    }

    /**
     * 1.第一行一个元素，第n行那个元素
     * 2.每一行的第一个元素和最后一个元素都是1
     * 3.第三行开始，对于一个非第一个元素和最后一个元素。即：
     * yanghui[i][j] = yanghui[i-1][j-1]+yanghui[i-1][j]
     */
    public static void yangHuiSanJiao(){

        int [][] yangHui = new int[10][];  //行的列不同，所以
        //给数组元素赋值
        for (int i = 0; i < yangHui.length; i++) {
            yangHui[i] = new int [i+1];
            //每一行的首末元素
            yangHui[i][0] = 1;
            yangHui[i][i] = 1;
            if(i>1){
                for (int j = 1; j < yangHui[i].length-1; j++) {
                    yangHui[i][j] = yangHui[i-1][j-1]+yangHui[i-1][j];
                }
            }
        }
        //打印杨辉三角
        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < yangHui[i].length; j++) {
                System.out.print(yangHui[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 创建一个长度为10 的int型数组，要求数组元素的值在1-30之间，且是随机赋值。同时要求元素的值各不相同。
     */
    public static void Random(){
       /*
         1 2  3  4  5
        16 17 18 19 6
        15 24 25 20 7
        14 23 22 21 8
        13 12 11 10 9
        */

    }
    //求数值
    public static void arrayExcel(){
        int [] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =(int) (Math.random()*(99-10+1)+10);  //random返回的值是[0.0,1)
        }
        //最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i])
                max = arr[i];
        }
        System.out.println("最大值："+max);
        //最小值
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i])
                min = arr[i];
        }
        System.out.println("最小值："+min);

        //总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("总和："+sum);
        //平均值
        System.out.println("平均值："+sum/arr.length);
    }
    //二分法查找
    public static void midSeach(){
        int [] arr = new int[]{-31,-20,-8,1,2,15,18,26};  //二分法必须有序
        int key = 2;
        int head = 0;
        int end = arr.length-1;
        boolean flag = true;
        while (head<=end){
            int mid = (end + head)/2;
            if(key == arr[mid]){
                System.out.println("元素已找到，位置为："+mid);
                flag = false;
                break;
            }else if (key < arr[mid]){
                end = mid - 1;
            }else{
                head = mid + 1;
            }
        }
        if(flag){
            System.out.println("没有找到该元素！！");
        }
    }
    //冒泡排序
    public static void bubbleSort(){
        //比较相邻元素、依次找出最大最小值
        int [] arr =new int[]{23,12,15,4,546,1,245,35,4,15};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1] ) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
    //arrays工具类
    public static void arraysUtils(){
        int [] arr =new int[]{23,12,15,4,546,1,245,35,4,15};
        int [] arr1 =new int[]{23,121,15,4,546,1,245,35,4,15};
        System.out.println(arr.equals(arr1));
        System.out.println(Arrays.toString(arr));  //返回数组中的所有元素
        Arrays.sort(arr);      //数组排序
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,10);  //替换填充数组中的元素
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

        int a = Arrays.binarySearch(arr1,546);  //返回数组中的位置index
        System.out.println(a);
        /*
        //错误一
        int []arr2 = new int[3];
        arr2 = null;
        System.out.println(arr2[0]);   //空指针异常

        //错误二
        int [][] arr3 = new int[4][];
        System.out.println(arr3[0][0]);   //空指针异常
        System.out.println(arr3[0]); //返回值为null
*/

        //错误三
        String [] arr4 = new String[]{"aa","bb","cc"};
        arr4[0] = null;
        System.out.println(Arrays.toString(arr4));  //null，bb,cc
        System.out.println(arr4[0].toString());  //空指针异常
        // */
    }
    //二叉排序
    public static void halfSort(){
        int[] a = { 2, 5, 6, 9, 7, 4, 3 };
        int i, j;
        int left, right, mid;
        int temp;
        for (i = 1; i < a.length; i++) {
            /* 找到数组中第一个无序的数，保存为temp */
            if (a[i] < a[i - 1]) {
                temp = a[i];
            } else {
                continue;
            }
            /* 找到数组中第一个无序的数，保存为temp */

            /* 二分查询开始 */
            left = 0;
            right = i - 1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (a[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            /* 二分查询结束,此时a[left]>=a[i],记录下left的值 */

            /* 将有序数组中比要插入的数大的数右移 */
            for (j = i; j > left; j--) {
                a[j] = a[j - 1];
            }
            /* 将有序数组中比要插入的数大的数右移 */

            // 将left位置赋值为要插入的数
            a[left] = temp;
        }
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k]+"\t");
        }
    }
}
