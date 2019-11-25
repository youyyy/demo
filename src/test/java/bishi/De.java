package bishi;
import java.util.Scanner;
public class De {
    static int N = 1000;
    static int a[] = new int[N];
    static int b[] = new int[N];
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().trim();
        String s2 = scanner.nextLine().trim();
        int len1 = s1.length();
        int len2 = s2.length();
        pre(s1, a);
        pre(s2, b);
        Output(Multiply(a, len1, b, len2));

    }

    public static void Output(int []arr) {
        boolean first =  false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!first && arr[i] == 0) {
                continue;
            }
            first = true;
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    public static int[] Multiply(int []a, int len1, int []b, int len2) {
        int res[] = new int[2 * N + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int te = res[j + i] + a[i] * b[j];
                int n = te % 10;
                int m = te / 10;
                res[i + j] = n;
                res[i + j + 1] += m;
            }
        }
        return res;
    }

    public static void pre(String s, int[] a) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            a[len - 1 - i] = s.charAt(i) - '0';
        }
    }
}
