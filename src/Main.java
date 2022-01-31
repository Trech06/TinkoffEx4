import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    static int targetN = 0;

    static int targetM = 0;

    public static void main(String[] args) {
        int maxValue= 50;

        System.out.println("Введите 2 числа от 1 до 50");
        while(true) {
            Scanner scannerInt = new Scanner(System.in);
            try {
                targetN = scannerInt.nextInt();
                targetM = scannerInt.nextInt();

                if (targetN <= maxValue && targetN > 0 &&
                        targetM <=maxValue && targetM > 0 )
                {
                    break;
                }
                else {
                    throw new Exception("Вводите данные удовлетворяющие условиям задачи");
                }
            } catch (Exception e) {
                System.out.println("Вводите данные удовлетворяющие условиям задачи");
            }
        }

        AtomicLong solutions = new AtomicLong();
        doMove(1, 1, solutions);
        System.out.println(solutions.get());
    }

    static int[] moveRight(int n, int m) {
        return new int[]{n + 2, m + 1};
    }

    static int[] moveTop(int n, int m) {
        return new int[]{n + 1, m + 2};
    }

    static void doMove(int fromN, int fromM, AtomicLong solutions) {
        int[] newPoint = moveRight(fromN, fromM);
        if (isTarget(newPoint)) {
            solutions.incrementAndGet();
            return;
        } else if (!isOutOfBoard(newPoint)) {
            doMove(newPoint[0], newPoint[1], solutions);
        }

        newPoint = moveTop(fromN, fromM);
        if (isTarget(newPoint)) {
            solutions.incrementAndGet();
            return;
        } else if (!isOutOfBoard(newPoint)) {
            doMove(newPoint[0], newPoint[1], solutions);
        }
    }

    static boolean isTarget(int[] point) {
        if (point[0] == targetN && point[1] == targetM) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isOutOfBoard(int[] point) {
        if (point[0] > targetN || point[1] > targetM) {
            return true;
        } else {
            return false;
        }
    }
}