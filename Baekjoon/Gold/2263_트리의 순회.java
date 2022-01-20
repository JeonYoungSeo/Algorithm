import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] inorder,inIndex,postorder;
    public static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        inorder = new int[N+1];
        postorder = new int[N+1];
        inIndex = new int[N+1];
        used = new boolean[N+1];

        StringTokenizer in = new StringTokenizer(br.readLine());
        StringTokenizer post = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            inorder[i] = Integer.parseInt(in.nextToken());
            inIndex[inorder[i]] = i;
        }
        for(int i=1; i<=N; i++){
            postorder[i] = Integer.parseInt(post.nextToken());

        }

        postorder(1, N, 1, N);

    }

    private static void postorder(int inS, int inE, int postS, int postE) {
        if(inS>inE || postS>postE) return;

        int div = inIndex[postorder[postE]];

        System.out.printf(postorder[postE]+" ");

        postorder(inS, div-1, postS, postS+(div-inS)-1);
        postorder(div+1, inE, postS+(div-inS), postE-1);

    }


}
