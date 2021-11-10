import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //글자 입력
        StringBuilder board = new StringBuilder(br.readLine());

        for(int i=0; i<board.length(); i++){
          //A, B, .이면 pass
            if(board.charAt(i)=='A' || board.charAt(i)=='B' || board.charAt(i)=='.') continue;

            int count = 0;

            for(int j=i; j<i+4; j++){
                if(j>=board.length()){
                    break;
                }
                if(board.charAt(j)!='X') break;
                count++;
            }
            //글자 들어갈수있으면 바꾸어준다.
            if(count==4){
                board.replace(i,i+4,"AAAA");
                continue;
            }else if(count==2){
                board.replace(i,i+2, "BB");
                continue;
            }
          //글자수 안맞으면 불가능
            System.out.println(-1);
            return;
        }
        System.out.println(board.toString());
    }
}
