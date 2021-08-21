package Projects.InterviewCake;

/**
 * Created by Jesper Lundin on 6 Nov 2016.
 *
You have an array of integers, and for each index you want to find the product of every integer except the integer at
that index. Write a function getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of
the products.

For example, given: [1, 7, 3, 4]

your function would return: [84, 12, 28, 21]

by calculating: [7*3*4, 1*3*4, 1*7*4, 1*7*3]

Do not use division in your solution.
*/

public class ProductOfAllOtherIntegers {
    public static int[] withoutDivision(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int[] left = new int[array.length];
        int[] right = new int[array.length];

        int leftProduct=1;
        int rightProduct=1;
        left[0] = 1;
        right[array.length-1] = 1;

        for (int i=1; i<array.length; i++) {
            int r = array.length-i;
            int l = i-1;
            leftProduct = leftProduct*array[l];
            rightProduct = rightProduct*array[r];
            left[i] = leftProduct;
            right[r-1] = rightProduct;
        }

        int[] answer = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            answer[i] = left[i]*right[i];
        }

        return answer;
    }
    public static int[] usingDivision(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int product = 1;
        for (int i: array) {
            product = product*i;
        }
        int[] answer = new int[array.length];
        for (int i=0; i<array.length; i++) {
            if (array[i] == 0) {
                int p = 1;
                for (int j=0; j<array.length; j++) {
                    if(i!=j) {
                        p = p * array[j];
                    }
                }
                answer[i] = p;
            } else {
                answer[i] = product / array[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 4, 8, 16};
        int[] output = withoutDivision(input);
        int[] output2 = usingDivision(input);
        for (int i=0; i<output.length;i++) {
            System.out.println(i + "\t" + output[i] + "\t" + output2[i]);
        }
    }
}