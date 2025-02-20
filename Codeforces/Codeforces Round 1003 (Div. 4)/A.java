import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i ++ ) {
            String str = scan.next();
            int index = str.lastIndexOf("us");
            System.out.println(str.substring(0, index) + "i");
        }
    }
}