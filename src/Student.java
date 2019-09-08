public class Student {
    private String name;
    private int score;
    public boolean isMan;
    public Student(String name , int score){
        this.name=name;
        this.score=score;
    }
    public Student(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Student student =new Student("wangchen",23);
        Student student1 =new Student();
        System.out.println(student1.isMan);
    }
}
