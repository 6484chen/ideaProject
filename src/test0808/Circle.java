package test0808;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/24 20:20
 * @Version 1.0
 */
public class Circle {

    private double radia;

    public Circle(){
        this.radia = 1;
    }

    public double getRadia() {
        return radia;
    }

    public void setRadia(double radia) {
        this.radia = radia;
    }

    public double circleArea(){
        return Math.PI * radia * radia;
    }
}


class Cylinder extends Circle{
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //public void
}