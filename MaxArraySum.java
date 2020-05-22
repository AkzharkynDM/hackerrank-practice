public class MaxArraySum {
    // Hackerrank
    //https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
    public static int solver(int[] array){
        //This is the solution in O(n^2)
        int max = array[0];
        int[] newArray = new int[array.length];
        newArray = array.clone();
        for (int i=0; i< array.length; i++){
            for (int j=i+2; j< array.length; j++){
                int temp = newArray[i] + array[j];
                System.out.println("temp" + temp);
                if (temp > newArray[j]) {
                    newArray[j] = temp;
                }
                if (temp > max){
                    max = temp;
                }
                System.out.println("max" + max);
            }
        }

        return max;
    }

    public static int betterSolver(int[] array){
        //This is the solution in O(n)
        int max1 = array[0];
        int max2 = array[1];
        int index2=1;
        for (int i=2; i< array.length; i++){
            //two numbers are not adjacent
            if (index2 == i-1){
                int tmax = Math.max(array[i] + max1, array[i]);
                int tind = i;
                if (tmax > max1 || tmax > max2) {
                    max1 = Math.max(max1, max2);
                    max2 = tmax;
                    index2 = tind;
                }
            } else {
                int tmax = Math.max(array[i], Math.max(array[i] + max1, array[i]+max2));
                int tind = i;
                max1 = Math.max(max1, max2);
                max2 = tmax;
                index2 = tind;
            }
        }
        return Math.max(max1, max2);
    }
}
