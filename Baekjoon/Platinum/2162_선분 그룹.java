import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
백준 2162번 문제.... 
union-find 와 ccw를 적용하여 풀어야한다. 
그리고 계산과정중 int 형을 벗어나니 자료형에 주의...
*/
public class Main{
    public static void init(int[] arr, int N){
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
    }

    public static void union(int a, int b,int[] arr ){

        int pa = find(a,arr);
        int pb = find(b,arr);

        if(pa==pb){
            return;
        }

        arr[pb] = pa;
    }

    public static int find(int num, int[] arr){
        if(arr[num]!=num){
            arr[num] = find(arr[num], arr);
            return arr[num];
        }
        return arr[num];
    }

    public static long ccw(long[] a, long[] b, long[] c){
        return (b[0]-a[0])*(c[1]-a[1])-(b[1]-a[1])*(c[0]-a[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] pos = new int[N+1][4];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<4; j++){
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] union = new int[N+1];
        init(union, N);

        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){


                if(isIntersect(i,j,pos)){
                    union(i,j,union);
                }

            }
        }

        //부모 정리
        for(int i=1; i<=N; i++){
            find(i,union);
        }
        int[] cnt = new int[N+1];
        for(int i=1; i<=N; i++){
            cnt[union[i]]++;
        }

        //정답 찾기
        int result1 = 0;
        int result2 = 0;

        for(int i=1; i<=N; i++){
            //System.out.print(cnt[i]+" ");

            if(cnt[i]!=0){
                result1++;
                result2= Math.max(result2,cnt[i]);
            }
        }
        //System.out.println();
        System.out.println(result1);
        System.out.println(result2);
    }

    private static boolean isIntersect(int i, int j, int[][] pos) {
        long[] a = {pos[i][0], pos[i][1]};
        long[] b = {pos[i][2], pos[i][3]};
        long[] c = {pos[j][0], pos[j][1]};
        long[] d = {pos[j][2], pos[j][3]};

        long val1 = ccw(a,b,c) * ccw(a,b,d);
        long val2 = ccw(c,d,a) * ccw(c,d,b);
        //System.out.println(i+" "+j+" "+val1+" "+val2);
        if(val1==0 && val2==0){
            int ax = Math.min(pos[i][0],pos[i][2]);
            int bx = Math.max(pos[i][0],pos[i][2]);
            int cx = Math.min(pos[j][0],pos[j][2]);
            int dx = Math.max(pos[j][0],pos[j][2]);

            int ay = Math.min(pos[i][1],pos[i][3]);
            int by = Math.max(pos[i][1],pos[i][3]);
            int cy = Math.min(pos[j][1],pos[j][3]);
            int dy = Math.max(pos[j][1],pos[j][3]);


            return (bx>=cx && dx>=ax) && (by>=cy && dy>=ay);
        }

        return val1<=0 && val2<=0;
    }
}
