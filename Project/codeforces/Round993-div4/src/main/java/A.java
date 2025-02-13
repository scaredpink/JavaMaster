import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        int amount;
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextInt();
        for (int i = 0; i < amount; i ++ )  {
            int n = scanner.nextInt();
            System.out.println(n - 1);
        }
    }
}