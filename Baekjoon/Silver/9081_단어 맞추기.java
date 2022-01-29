import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            char[] word = br.readLine().toCharArray();

            int len = word.length;

            boolean check = false;
            int pos = -1;
            for(int i=len-1; i>0; i--){
                if(word[i]>word[i-1]){
                    check = true;
                    pos = i-1;
                    break;
                }
            }
            int pos2 = -1;
            if(!check){
                System.out.println(word);
                continue;
            }else{
                for(int i=pos+1; i<len; i++){
                    if(word[pos]<word[i]){
                        pos2 = i;
                    }
                }

                char temp = word[pos];
                word[pos] = word[pos2];
                word[pos2] = temp;

                Arrays.sort(word, pos+1, len);
            }

            System.out.println(word);
        }
    }
}
