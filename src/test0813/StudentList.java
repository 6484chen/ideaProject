package test0813;

import java.util.Objects;

public class StudentList implements Comparable{
    private String snu;
    private String sname;
    private String scard;

    public StudentList(String snu, String sname, String scard) {
        this.snu = snu;
        this.sname = sname;
        this.scard = scard;
    }

    public String getSnu() {
        return snu;
    }

    public void setSnu(String snu) {
        this.snu = snu;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScard() {
        return scard;
    }

    public void setScard(String scard) {
        this.scard = scard;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "snu='" + snu + '\'' +
                ", sname='" + sname + '\'' +
                ", scard='" + scard + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentList that = (StudentList) o;
        return Objects.equals(snu, that.snu) &&
                Objects.equals(sname, that.sname) &&
                Objects.equals(scard, that.scard);
    }

   @Override
    public int hashCode() {
        int a = Objects.hash(snu, sname, scard);
        System.out.println("hashCode: "+a);
        return a;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }else{
            if ( o instanceof StudentList){
                StudentList studentList = (StudentList)o;

                if(this.sname.compareTo(studentList.sname) == 0 ){
                    return this.scard.compareTo(studentList.scard);
                }

                return this.sname.compareTo(studentList.sname);
            }
        }
        return 1;
    }
}
