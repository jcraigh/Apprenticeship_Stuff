package eva.FizzBuzz;

public class FizzBuzz {
    public static void main(String args[]) {
        for(int count = 1; count <= 143; count = count + 1){
            if (count % 3 == 0 || count % 5 == 0 || count % 7 == 0 || count % 11 == 0 || count % 13 == 0) {
                if (count % 3 == 0) {
                    System.out.print("Fizz");
                }
                if (count % 13 == 0){
                    System.out.print("Fezz");
                }
                if (count % 5 == 0) {
                    System.out.print("Buzz");
                }
                if (count % 7 == 0) {
                    System.out.print("Bang");
                }
                if (count % 11 == 0) {
                    System.out.print("\rBong");
                }
                if (count % 13 == 0 && count % 11 == 0){
                    System.out.print("\rFezzBong");
                }
            }
            else{
                System.out.print(count);
            }
            System.out.print("\n");
        }
    }
}
