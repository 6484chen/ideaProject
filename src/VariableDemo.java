public class VariableDemo {
    public static void main(String[] args) {
        int orage = 100;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 35; j++) {

                if(j % 5 == 0)
                    continue;
                count++;
                if(count == 100){
                    break;
                }else {
                    System.out.println("S正在为第" + i + "班的第" + j + "个同学发橙子");
                }
            }
        }
        System.out.println("总共发了"+count+"个橙子");

        //定义indentfier    标识符

    }
}
