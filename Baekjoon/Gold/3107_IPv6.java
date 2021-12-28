import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine().trim();

        int tokens = 0;

        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == ':') tokens++;
        }

        if(line.length()>=4 && line.charAt(1)==':' && line.charAt(2)==':') tokens++;
        else if (line.charAt(0)==':' && line.charAt(1)==':') tokens--;
        else if (line.charAt(line.length()-1)==':' && line.charAt(line.length()-2)==':') tokens--;

        if(line.length() == 2){
            System.out.println("0000:0000:0000:0000:0000:0000:0000:0000");
            return;
        }

        line = line + ":";
        StringBuilder result = new StringBuilder();
        int cnt = 0;
        StringBuilder temp = new StringBuilder();

        boolean once = false;
        for(int i=0; i<line.length(); i++){

            if(line.charAt(i) == ':'){
                if(cnt!=0 && cnt!=4){
                    for(; cnt<4; cnt++)
                        result.append('0');
                }


                if(cnt == 0 && !once){
                    for(int k=0; k<8-tokens; k++){
                        result.append("0000:");
                    }

                    once = true;
                    continue;
                }

                result.append(temp);
                if(result.charAt(result.length()-1)!=':')
                    result.append(':');
                temp.setLength(0);
                cnt=0;
                continue;
            }

            temp.append(line.charAt(i));
            cnt++;

        }
        result.append(temp);
        while(result.charAt(result.length()-1) == ':')
            result.setLength(result.length()-1);

        System.out.println(result);

    }
}
