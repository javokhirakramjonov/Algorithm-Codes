public class BitwiseOperators {
    public static void main(String[] args) {

        int a = 37;
        int b = 13;

        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);

        System.out.println(37 >> 3);
        System.out.println(1 << 10);

        System.out.println((-74) >> 1);
        System.out.println((-74) >>> 1);

        System.out.println(~3);
    }
}
