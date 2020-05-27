import java.util.HashMap;

public class AbbreviationSolver {
    private String s1;
    private String s2;
    private int[][] memostate;

    public AbbreviationSolver(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
        memostate = new int[s1.length()][s2.length()];
    }
    /*public static String solver(String s1, String s2){
        int i=0, j = 0;
        char latestS2;
        while (j<s2.length()){
            System.out.println(i + " " + s1.charAt(i) + " " + j + " " + s2.charAt(j));
            latestS2 = s2.charAt(j);
            if (i == s1.length()){
                return "NO 1";
            }
            if (s2.charAt(j) == s1.charAt(i) || s2.charAt(j) == s1.toUpperCase().charAt(i)){
                i++; j++;
            }
            else if (Character.isUpperCase(s1.charAt(i)) && s1.charAt(i) == latestS2){
                i++;
            }
            else if (Character.isLowerCase(s1.charAt(i))){
                i++;
            }
            else return "NO 2";
        }
        while (i<s1.length()){
            if (Character.isLowerCase(s1.charAt(i)))
            i++;
            else return "NO 3";
        }
        return "YES";
    }*/



    public boolean betterSolver(int i, int j) {
        if (j == s2.length()) {
            while (i < s1.length()) {
                if (Character.isUpperCase(s1.charAt(i))) {
                    return false;
                }
                i++;
            }
            return true;
        }

        if (i == s1.length() && j < s2.length()) {
            return false;
        }
        if (memostate[i][j] != 0){
            return memostate[i][j] == 1 ? true : false;
        }

        boolean b = false;
        if (s1.charAt(i) == s2.charAt(j)) {
            //i++;
            //j++;
            b = betterSolver(i + 1, j + 1);
            memostate[i][j] = b ? 1 : -1;

        }
        else if (s2.charAt(j) == Character.toUpperCase(s1.charAt(i))) {
            b = betterSolver(i + 1, j) || betterSolver(i + 1, j + 1);
            memostate[i][j] = b ? 1 : -1;
        }
        else if (Character.isLowerCase(s1.charAt(i))) {
            //i++;
            b = betterSolver(i + 1, j);
            memostate[i][j] = b ? 1 : -1;
        }
        return b;
    }
}
