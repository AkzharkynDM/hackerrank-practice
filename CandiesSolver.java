public class CandiesSolver {

    public int solver(int[] students){
        int numberOFCandies = 0;
        int[] candies = new int[students.length];
        candies[0] = 1;

        for (int i = 1; i < students.length; i++){
            if (students[i-1] < students[i] ){
                candies[i] = candies[i-1] + 1;
            }
            else {
                candies[i] = 1;
               if (candies[i-1] == 1) {
                    int previousStudentWithMaxCandies = students[i];
                    for (int j = i-1; j >=0; j--) {
                        if (previousStudentWithMaxCandies < students[j] && candies[j] == candies[j+1]) {
                            candies[j] += 1;
                            previousStudentWithMaxCandies = students[j];
                        } else break;
                    }
               }
            }
        }


        for (int i=0; i< candies.length; i++){
            System.out.println(candies[i]);
            numberOFCandies+=candies[i];
        }
        return numberOFCandies;
    }

    public long bettersolver(int[] students){
        long candies = 1;
        long sum = 1;
        long bigger_before = 1;
        long max_in_chain = 1;
        for (int i = 1; i < students.length; i++) {
            if (students[i] > students[i-1]){
                candies += 1;
                bigger_before = 1;
                max_in_chain = candies;
                sum += candies;
            }else if (students[i] == students[i-1]) {
                candies = 1;
                bigger_before = 1;
                max_in_chain = candies;
                sum += candies;
            } else if (students[i] < students[i-1]) {
                if (candies == 1) {
                    candies = 1;
                    if ((max_in_chain - bigger_before) > 0) {
                        sum += (max_in_chain - bigger_before);
                        bigger_before += 1;
                    }
                    else {
                        bigger_before += 1;
                        sum += bigger_before;
                    }
                }
                if (candies != 1) {
                    candies = 1;
                    bigger_before += 1;
                    sum += candies;
                }
            }
        }
        return sum;
    }
}
