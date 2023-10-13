package Ex2;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.Arrays;
import static java.lang.System.out;

class Main {

    public static void main(String[] args) {
        BiFunction<int[], Integer, Integer> linearSearch = (nums, searchNum) -> {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == searchNum) {
                    return i;
                }
            }
            return -1;
        };

        BiFunction<int[], Integer, Integer> binarySearch = (nums, searchNum) -> {
            Arrays.sort(nums);
            int low = 0, high = nums.length;
            while (low != high) {
                int mid = (low + high) / 2;
                int mid_elem = nums[mid];
                if (searchNum < mid_elem) {
                    high = mid;
                } else if (searchNum > mid_elem) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        };

        var sc = new Scanner(System.in);
        out.print("Enter the number of elements: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            out.print("Enter a number: ");
            nums[i] = Integer.parseInt(sc.nextLine());
        }

        boolean quit = false;

        while (!quit) {
            out.print("""
                    Options:
                    1. Linear Search
                    2. Binary Search
                    3. Quit
                    Enter Your option: """);
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    out.print("Enter the number to search for: ");
                    int searchVal = Integer.parseInt(sc.nextLine());
                    int index = linearSearch.apply(nums, searchVal);
                    if (index == -1) {
                        out.print("The element wasn't found in the array...\n");
                    } else {
                        out.print(String.format("The element was found at index %d\n", index));
                    }
                    break;
                case 2:
                    out.print("Enter the number to search for: ");
                    int searchVal2 = Integer.parseInt(sc.nextLine());
                    int index2 = binarySearch.apply(nums, searchVal2);
                    if (index2 == -1) {
                        out.print("The element wasn't found in the array...\n");
                    } else {
                        out.print(String.format("The element was found at index %d\n", index2));
                    }
                    break;
                default:
                    out.print("Quitting..\n");
                    quit = true;
                    break;
            }
        }
        sc.close();
    }
}
