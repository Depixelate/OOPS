package Ex7Generics;
import java.util.Arrays;
class Main {
    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static <T> void swap(T[] array, int pos1, int pos2) {
        T temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public static <T extends Comparable<T>> void heapify(T[] array, int length, int pos) {
        if(left(pos) >=length) {
            return;
        }
        
        if(right(pos) >= length) {
            if(array[left(pos)].compareTo(array[pos]) > 0) {
                swap(array, pos, left(pos));
            }
            return;
        }

        if(array[left(pos)].compareTo(array[pos]) > 0 && array[left(pos)].compareTo(array[right(pos)]) >= 0) {
            swap(array, pos, left(pos));
            heapify(array, length, left(pos));
            
        } else if(array[right(pos)].compareTo(array[pos]) > 0 && array[right(pos)].compareTo(array[left(pos)]) >= 0) {
            swap(array, pos, right(pos));
            heapify(array, length, right(pos));
        }
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for(int i = array.length-1; i >= 0; i--) {
            heapify(array, array.length, i);
            //System.out.println(Arrays.toString(array));
        }

        //System.out.println("Here!");


        for(int i = array.length-1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
            //System.out.println(Arrays.toString(array));
        }
    }



    public static void main(String[] args) {
        Integer[] elems = {1, 5, 3, 4, 2, 7, -1, 9};
        System.out.println("Before: " + Arrays.toString(elems));
        Main.<Integer>sort(elems);
        System.out.println("After: " + Arrays.toString(elems));
        String[] strElems = {"Berlin", "Delhi", "Mumbai", "Zurich", "Ahmedabad", "Chennai", "Paris"};
        System.out.println("Before: " + Arrays.toString(strElems));
        Main.<String>sort(strElems);
        System.out.println("After: " + Arrays.toString(strElems));
    }
}
