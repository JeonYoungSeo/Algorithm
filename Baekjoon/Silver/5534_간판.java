import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String name = br.readLine();
        int name_size = name.length();

        int result = 0;
        int num = 0;

        out :
        for(int i=0; i<N; i++){
            String old = br.readLine();

            int pos = -1;
            int size = old.length();
            int first ,second;
            while(++pos<size){

                num = 0;
                if(old.charAt(pos) != name.charAt(num)) {

                    continue;
                }
                num++;
                first = pos;

                if(name_size == num){
                    result++;
                    continue out;
                }

                int sec_pos = pos;
                while(++sec_pos < size) {
                    num = 1;
                    while (sec_pos<size && old.charAt(sec_pos) != name.charAt(num)) {
                        sec_pos++;
                        continue;
                    }

                    if (name_size == num) {
                        result++;
                        continue out;
                    }

                    if (sec_pos == size) {
                        continue;
                    }
                    num++;
                    int diff = sec_pos - pos;
                    int curr_pos =  sec_pos;
                    while (num < name_size) {
                        curr_pos += diff;

                        if (curr_pos < size && old.charAt(curr_pos) == name.charAt(num)) {
                            num++;
                        } else {
                            break;
                        }
                    }

                    if(num == name_size){
                        result++;
                        continue out;
                    }
                }
            }
        }
        System.out.println(result);

    }


}
