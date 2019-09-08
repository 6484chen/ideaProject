package test0814;

public class ExceStudent {
    public static void main(String[] args) {
        Student3 [] stu =new Student3[20];
        for (int i = 0; i < stu.length; i++) {
            stu[i] = new Student3();
            stu[i].setNumber(i);
            stu[i].setState((int)(Math.random()*(6-1+1)+1));
            stu[i].setScore((int)(Math.random()*(99-1+1)+1));
        }
        for (Student3 student3 : stu) {
            System.out.println(student3);
        }
        System.out.println("============================");
        for (Student3 student3 : stu) {
            if(student3.getState()==3){
                System.out.println(student3);
            }
        }
        System.out.println("================");
        Student3 temp ;      //冒泡排序
        for (int i = 0; i < stu.length-1; i++) {
            for (int j = 0; j < stu.length-1-i; j++) {
                if(stu[j].getScore()>stu[j+1].getScore()){

                            temp= stu[j];
                            stu[j] = stu[j+1];
                            stu[j+1] = temp;


                    /*int temp = stu[j].getScore();
                    stu[j].setScore(stu[j+1].getScore());
                    stu[j+1].setScore(temp);*/

                }
            }
        }
        for (Student3 student3 : stu) {
            System.out.println(student3);
        }
    }

}
class Student3{
    private int number;  //学号
    private int state;  //年级
    private int score;  //分数

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }
}
