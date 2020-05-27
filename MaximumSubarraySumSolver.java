import java.util.Arrays;

public class MaximumSubarraySumSolver {
    //https://www.hackerrank.com/challenges/maximum-subarray-sum/problem

    //public MaximumSubarraySumSolver() {
    //}

    static class Pair /*implements Comparable<Pair>*/{
        Long value;
        Long index;

        Pair(long value, long index){
            this.value = value;
            this.index = index;
        }

        /*@Override
        public long compareTo(Pair otherPlayer) {
            return (this.value - otherPlayer.value);
        }*/
    }

    public static long solve(long[] input, long m){
        long result = -1;
        //int[] indices = new int[input.length];
        long[] prefix_sum_array = create_prefix_sum_array(input, m);

        System.out.println(Arrays.toString(prefix_sum_array));

        Pair[] pairsInput = new Pair[prefix_sum_array.length];
        for (int i=0; i<prefix_sum_array.length; i++){
            pairsInput[i] = new Pair(prefix_sum_array[i], i+1);
        }
        sortArrayPairs(pairsInput);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        for (int i = 0; i<pairsInput.length; i++) {
            System.out.print(pairsInput[i].value + ", " + pairsInput[i].index + "\n");
        }
        System.out.println();

        long min_diff = Math.abs(pairsInput[pairsInput.length - 1].index - pairsInput[0].index);

        System.out.println("Min diff is " + min_diff);
        result = m - min_diff;
        return result;
    }

    /*private static void sortArray(int[] array, int[] indices) {
        for (int left = 0; left < array.length; left++) {
            // Get an element
            int value = array[left];
            int original_index = left;
            // Iterate through the elements that are in front of this element
            int i = left - 1;
            for (; i >= 0; i--) {
                // If the current element is smaller, then move the larger element to the right.
                if (value < array[i]) {
                    array[i + 1] = array[i];
                    indices[i] = original_index;
                } else {
                    // If the current element is larger, we stop
                    break;
                }
            }
            // Insert the current value in the empty space
            array[i + 1] = value;
        }
    }*/


    private static void sortArrayPairs(Pair[] pairsInput) {
        for (int left = 0; left < pairsInput.length; left++) {
            // Get an element
            long value = pairsInput[left].value;
            long index = pairsInput[left].index;

            // Iterate through the elements that are in front of this element
            int i = left - 1;
            for (; i >= 0; i--) {
                // If the current element is smaller, then move the larger element to the right.
                if (value < pairsInput[i].value) {
                    pairsInput[i + 1].value = pairsInput[i].value;
                    pairsInput[i + 1].index = pairsInput[i].index;
                } else {
                    // If the current element is larger, we stop
                    break;
                }
            }
            // Insert the current value in the empty space
            pairsInput[i + 1].value = value;
            pairsInput[i + 1].index = index;

        }
    }

    private static long[] create_prefix_sum_array(long[] input, long m){
        long[] prefix_sum_array = new long[input.length];
        long sum = 0;

        for (int i=0; i < input.length; i++){
            sum += input[i];
            prefix_sum_array[i] = sum % m;
        }

        return prefix_sum_array;
    }

}
