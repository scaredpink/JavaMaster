import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); 
        for (int i = 0; i < n; i ++ ) {
            String str = scan.next();
            if (equalNextChar(str) != -1) {
                System.out.println(1);
            } else {
                System.out.println(str.length());
            }
        }
    }

    public static int equalNextChar(String str) {
        for (int i = 0; i < str.length() - 1; i ++ ) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }
}