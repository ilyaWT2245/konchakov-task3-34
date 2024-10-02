import java.util.Scanner;

public class Program {
    public static final VerticalParabola VP1 = new VerticalParabola(2, 3, 0.5);
    public static final VerticalParabola VP2 = new VerticalParabola(1, 6, -1);
    public static final VerticalParabola VP3 = new VerticalParabola(4, 0, -0.125);
    public static final Circle C1 = new Circle(-3, 5, 5);

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
        if (C1.IsInsideCircle(x, y)){
            if (VP1.IsUpperOfParabola(x, y) && !VP2.IsUpperOfParabola(x, y)){
                return SimpleColor.YELLOW;
            }
            if (VP1.IsUpperOfParabola(x, y)){
                return SimpleColor.ORANGE;
            }
            if (!VP2.IsUpperOfParabola(x, y)){
                return SimpleColor.ORANGE;
            }
            return SimpleColor.BLUE;
        }
        if (VP1.IsUpperOfParabola(x, y)){
            if (!VP2.IsUpperOfParabola(x, y)){
                return SimpleColor.GRAY;
            }
            return SimpleColor.WHITE;
        }
        if (!VP3.IsUpperOfParabola(x, y)){
            if (!VP2.IsUpperOfParabola(x, y)){
                return SimpleColor.GRAY;
            }
            if (x < 0){
                return SimpleColor.WHITE;
            }
            return SimpleColor.ORANGE;
        }
        return SimpleColor.YELLOW;
    }
}