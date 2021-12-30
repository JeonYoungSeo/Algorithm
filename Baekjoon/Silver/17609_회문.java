import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){

            String words = br.readLine();
            int size = words.length()-1;
            int result = 0;

            for(int i=0; i<(size+1)/2; i++){
                if(words.charAt(i) != words.charAt(size-i)){
                    result = 1;
                    boolean check1 = false;
                    boolean check2 = false;
                    //왼쪽 빼고 확인
                    int cnt = 0;
                    for(int j=i+1; j<size/2+1; j++){
                        if(words.charAt(j) != words.charAt(size-i-cnt++)){
                            check1 = true;
                            break;
                        }
                    }

                    //오른쪽 빼고 확인
                    cnt = 0;
                    for(int j=i; j<size/2; j++){
                        if(words.charAt(j) != words.charAt(size-i-1-cnt++)){
                            check2 = true;
                            break;
                        }
                    }
                    if(check2 && check1){
                        result = 2;
                        break;
                    }
                    break;
                }
            }

            System.out.println(result);


        }

    }

}
