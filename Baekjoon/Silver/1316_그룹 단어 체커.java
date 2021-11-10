import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //단어 개수
        int N = Integer.parseInt(br.readLine());
        //정답
        int result = 0;

    out : while(N-->0) {
            StringBuilder word = new StringBuilder(br.readLine());
            //알파벳 이미 나왓는지 체크
            boolean[] check = new boolean[27];
            //현재 체크한 위치
            int curr = 0;
            while(curr<word.length()){
                //이미 나왔던 문자가 다시 나오면 넘어간다
                if(check[word.charAt(curr)-'a']) {
                    continue out ;
                }
                //나온거라고 체크
                check[word.charAt(curr)-'a']=true;
                //같은 문자는 건너뛴다.
                char curchar = word.charAt(curr);
                while(curr<word.length() && word.charAt(curr)==curchar){
                    curr ++;
                }

            }
            result ++;
        }
        System.out.println(result);
    }
}
