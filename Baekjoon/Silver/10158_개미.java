import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //격자
        StringTokenizer st = new StringTokenizer(br.readLine());
        //가로 세로
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        //개미
        st = new StringTokenizer(br.readLine());
        // 가로 세로
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        //시간
        int t = Integer.parseInt(br.readLine());
        //짝수번째면 그냥 출력 홀수번째면 역방향이므로, 격자의 길이에서 이동한 만큼 제해준다.
        if(((p+t)/w)%2 == 0){
            p = (p+t)%w;
        }else{
            p = w-(p+t)%w;
        }

        if(((q+t)/h%2)==0){
            q = (q+t)%h;
        }else{
            q = h-(q+t)%h;
        }
        bw.write(p+" "+q);

        bw.flush();
        bw.close();
        br.close();
    }

}
