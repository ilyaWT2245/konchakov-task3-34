public class Line {
    public double x0;
    public double y0;
    public double a;

    public Line(double x0, double y0, double a){
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean IsPointAboveLine(double x, double y){
        return y - y0 >= a * (x - x0);
    }
}
