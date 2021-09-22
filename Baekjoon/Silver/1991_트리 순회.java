import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-22
 * Description : 백준 1991
 */


public class Main{
	public static class Node{
		int left,right;
		
		Node(int left, int right){
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[] node;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		node = new Node[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int mid = st.nextToken().charAt(0)-'A';
			int left = st.nextToken().charAt(0)-'A';
			int right = st.nextToken().charAt(0)-'A';
			
			node[mid] = new Node(left, right);
		}
		
		prefix(0);
		bw.newLine();
		infix(0);
		bw.newLine();
		postfix(0);
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void prefix(int n) throws IOException {
		if(n==-19) return;
		
		bw.write(Character.toChars(n+'A'));
		prefix(node[n].left);
		prefix(node[n].right);
	}
	
	
	public static void infix(int n) throws IOException {
		if(n==-19) return;
		
		infix(node[n].left);
		bw.write(Character.toChars(n+'A'));
		infix(node[n].right);
	}
	
	public static void postfix(int n) throws IOException {
		if(n==-19) return;
		
		postfix(node[n].left);
		postfix(node[n].right);
		bw.write(Character.toChars(n+'A'));
	}
}
