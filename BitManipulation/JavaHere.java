public class JavaHere {

    public static void main(String[] args) {

        JavaHere javaHere = new JavaHere();

//        javaHere.setBit();
//
//        javaHere.unSetBit();
//
//        javaHere.toggleBit();
//
//        javaHere.countSetBitStandard();
//
//        javaHere.countSetBitBrianAlgo();
    }

    private void setBit() {
        int a = 46;

        System.out.println(Integer.toBinaryString(a));

        int b = (1 << 4);

        int c = a | b;

        System.out.println(Integer.toBinaryString(c));
    }

    private void unSetBit() {
        int a = 46;

        System.out.println(Integer.toBinaryString(a));

        int b = ~(1 << 3);

        int c = a & b;

        System.out.println(Integer.toBinaryString(c));
    }

    private void toggleBit() {
        int a = 46;

        System.out.println(Integer.toBinaryString(a));

        int b = (1 << 4);

        int c = a ^ b;

        System.out.println(Integer.toBinaryString(c));

        int d = c ^ b;

        System.out.println(Integer.toBinaryString(d));
    }

    private void countSetBitStandard() {

        int n = 27;
        int count = 0;

        while (n != 0) {
            System.out.println(Integer.toBinaryString(n));
            count += n & 1;
            n >>= 1;
        }

        System.out.println(count);
    }

    private void countSetBitBrianAlgo() {

        int n = 57;

        int count = 0;

        while (n != 0) {
            System.out.println(Integer.toBinaryString(n));
            n &= n - 1;
            count++;
        }

        System.out.println(count);
    }
}
