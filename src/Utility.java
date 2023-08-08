public class Utility {
    // Prevent instantiation
    private Utility() {
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println("Result of addition: " + result);

        String capitalizedStr = capitalize("hello");
        System.out.println("Capitalized string: " + capitalizedStr);

        boolean isPrimeNumber = isPrime(17);
        System.out.println("Is 17 a prime number? " + isPrimeNumber);
    }
}
