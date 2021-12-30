import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] arr = new int[len1+1][len2+1];

        for(int i=1; i<=len1; i++){
            int word1 = str1.charAt(i-1);
            for(int j=1; j<=len2; j++){
                if(word1 == str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        System.out.println(arr[len1][len2]);
    }
}
