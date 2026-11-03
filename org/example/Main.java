public class Main {

    public static int findGreatest(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        int a = 10;
        int b = 25;
        int c = 15;

        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);
        System.out.println("Third number: " + c);

        System.out.println("Greatest number = " + findGreatest(a, b, c));
    }
}