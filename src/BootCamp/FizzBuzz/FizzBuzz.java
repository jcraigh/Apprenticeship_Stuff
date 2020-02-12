package BootCamp.FizzBuzz;

public class FizzBuzz {
    public static void main(String args[]) {
        boolean num = false;
        for (int i = 1; i <= 255; i++) {
            if (i % 17 == 0) {
                if (i % 13 == 0) {
                    System.out.print("Fezz");
                    num = true;
                }
                if (i % 3 == 0) {
                    System.out.print("Fizz");
                    num = true;
                }
                if (i % 7 == 0) {
                    System.out.print("Bang");
                    num = true;
                }
                if (i % 5 == 0) {
                    System.out.print("Buzz");
                    num = true;
                }
                if (i % 11 == 0) {
                    System.out.print("\rBong");
                    num = true;
                }
            } else {
                if (i % 3 == 0) {
                    System.out.print("Fizz");
                    num = true;
                }
                if (i % 13 == 0) {
                    System.out.print("Fezz");
                    num = true;
                }
                if (i % 5 == 0) {
                    System.out.print("Buzz");
                    num = true;
                }
                if (i % 7 == 0) {
                    System.out.print("Bang");
                    num = true;
                }
                if (i % 11 == 0) {
                    System.out.print("\rBong");
                    num = true;
                }

            }
            if (num == false){
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }
}
