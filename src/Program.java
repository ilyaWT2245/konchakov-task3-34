import java.util.Scanner;

public class Program {
    public static final Line L1 = new Line(-2, -2, -4);
    public static final HorizontalParabola HP1 = new HorizontalParabola(-1, 2, -1);
    public static final VerticalParabola VP1 = new VerticalParabola(-5, 3, 0.5);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input X: ");
        double x = scanner.nextDouble();
        System.out.print("Input Y: ");
        double y = scanner.nextDouble();
        SimpleColor c = getColor(x, y);
        System.out.printf("Color of (%.3f; %.3f) -> %s", x, y, c);
    }

    public static SimpleColor getColor(double x, double y){
        if (L1.IsPointAboveLine(x, y)){
            if (VP1.IsUpperOfParabola(x, y)){
                return SimpleColor.ORANGE;
            } else{
                return SimpleColor.GREEN;
            }
        } else{
            if (VP1.IsUpperOfParabola(x, y) && HP1.IsLeftOfParabola(x, y)){
                return SimpleColor.BLUE;
            }
            if (VP1.IsUpperOfParabola(x, y)){
                return SimpleColor.WHITE;
            }
            if (HP1.IsLeftOfParabola(x, y)){
                return SimpleColor.GREEN;
            }

            if (y > 2){
                if (x > - 5){
                    return SimpleColor.ORANGE;
                }
                return SimpleColor.WHITE;
            }
            return SimpleColor.GREY;
        }
    }
}