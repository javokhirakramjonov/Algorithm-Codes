import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextInt();
        while(k-- > 0) {
            long m = (long) (1e9 + 7);

            long a = scanner.nextInt();
            long b = scanner.nextInt();
            long c = scanner.nextInt();

            long n = binPow(b, c, m - 1);
            long ans = binPow(a, n, m);

            System.out.println(ans);
        }
    }

    public static long binPow(long a, long n, long m) {
        long res = 1;
        while(n > 0) {
            if(n % 2 == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            n >>= 1;
        }
        return res;
    }
}
