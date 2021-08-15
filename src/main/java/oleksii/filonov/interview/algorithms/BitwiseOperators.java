package oleksii.filonov.interview.algorithms;

public class BitwiseOperators {

    public static void main(String[] args) {
        byte three = 0b11; //3
        int zero = Integer.MIN_VALUE << 1;
        System.out.println(zero + ":" + Integer.toBinaryString(zero)
                + ", size:" + Integer.toBinaryString(zero).length());
        int twoInPow10 = 1 << 10;
        String binaryTwoInPow10 = Integer.toBinaryString(twoInPow10);
        System.out.printf("2 in power 10 value: %s, binary: %s, size: %s%n", twoInPow10, binaryTwoInPow10, binaryTwoInPow10.length());
        int value = 0b101;
        int or = value | 0b010;
        System.out.printf("value: %s, or: %s%n", value, or);
        System.out.println("Left right: " + Integer.toBinaryString(1 << 'a' - 'a'));//0b1
        System.out.println("Left right: " + Integer.toBinaryString(1 << 'b' - 'a'));//0b10
        System.out.println("Shift right: " + Integer.toBinaryString(0b10 >> 'c' - 'a'));
        System.out.println((0b100 >> 'b' - 'a') & 1);//&1 - allows to check the last bit 0b00001
        //check if keyring 0b101 contains b
        System.out.println((1 << 'c' - 'a') & 0b101);//&1 - allows to check the last bit 0b00001
    }
}
