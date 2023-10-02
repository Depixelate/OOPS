package Ex2;

import java.util.Scanner;
import java.util.Arrays;
public class Q1Search {

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static int getSearchNum(Scanner sc) {
        print("Enter the number to search for: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static int linearSearch(int[] nums, int searchNum) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == searchNum) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int searchNum) {
        Arrays.sort(nums);
        int low = 0, high = nums.length;
        while(low != high) {
            int mid = (low + high)/2;
            int mid_elem = nums[mid];
            if(searchNum < mid_elem) {
                high = mid;
            } else if (searchNum > mid_elem) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void printSearchResult(int index) {
        if(index == -1) {
            print("The element wasn't found in the array...\n");
        } else {
            print(String.format("The element was found at index %d\n", index));
        }
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        print("Enter the number of elements: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++) {
            print("Enter a number: ");
            nums[i] = Integer.parseInt(sc.nextLine());
        }

        boolean quit = false;

        while(!quit) {
            print("""
                    Options:
                    1. Linear Search
                    2. Binary Search
                    3. Quit
                    Enter Your option: """);
            int option = Integer.parseInt(sc.nextLine());
            
            switch(option) {
                case 1:
                    int searchVal = getSearchNum(sc);
                    int index = linearSearch(nums, searchVal);
                    printSearchResult(index);
                    break;
                case 2:
                    int searchVal2 = getSearchNum(sc);
                    int index2 = binarySearch(nums, searchVal2);
                    printSearchResult(index2);
                    break;
                default:
                    print("Quitting..\n");
                    quit = true;
                    break;
            }
        }
        sc.close();
    }
}
