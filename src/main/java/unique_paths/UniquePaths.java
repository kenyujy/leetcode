package unique_paths;

import java.util.Arrays;

//https://leetcode-cn.com/problems/unique-paths/submissions/
public class UniquePaths{

    public static void main(String[] args) {
        long start= System.currentTimeMillis();
        System.out.println(uniquePaths(51,9));
        long end= System.currentTimeMillis();
        System.out.println(end-start);

        start= System.currentTimeMillis();
        System.out.println(uniquePaths2(51,9));
        end= System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static int uniquePaths(int m, int n) {

        if (m== 1)
            return 1;
        else if (n== 1)
            return 1;
        else
            return uniquePaths(m, n-1)+ uniquePaths(m-1,n);

    }

    public static int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

}