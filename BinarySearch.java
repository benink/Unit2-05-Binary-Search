import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Doing binary searches to find a requested number.
 *
 * @author Beni Nkongolo
 * @version 1.0
 * @since 2025-10-23
 */
public final class BinarySearch {
    private BinarySearch() { } // hide constructor
/**
     * Makes 10 random numbers, and lists them to the user.
     * The user then asks for a number and it finds it in the array.
     * @param args Command-line arguments (not used).
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Create an array of 10 random numbers between 0 and 100
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(101); // 0 to 100 inclusive
        }

        // Sort the array
        Arrays.sort(numbers);

        System.out.println("Welcome to the Binary Search Program!");

        while (true) {
            // Display the numbers
            System.out.print("What number are you searching for in the "
            + "list below? Enter \"q\" to quit.\n");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Get user input
            System.out.print("Number: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thank you for playing!");
                break;
            }

            try {
                int target = Integer.parseInt(input);

                // Perform binary search
                int index = binarySearch(numbers, target);

                if (index != -1) {
                    System.out.println("The number "
                    + target + " is found at index " + index + ".");
                } else {
                    System.out.println("The number "
                    + target + " is not found in the list of numbers.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input."
                + "Please enter a number or 'q' to quit.");
            }

            System.out.println();
        }

        scanner.close();
    }

    // Binary Search method
    /**
     * Checks through the array for users targeted number.
     * @param arr The array to search through.
     * @param target The number to search for.
     * @return The index of the target number, or -1 if not found.
     */
    public static int binarySearch(final int[] arr, final int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // If number not found
    }
}
