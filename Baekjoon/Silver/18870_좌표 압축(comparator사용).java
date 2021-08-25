/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-25
 * Description : 백준 18870
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	public static class Node implements Comparable<Node>{
		int big, num, len;
		
		Node(int num, int len){
			this.num=num;
			this.len=len;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.num - node.num;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Node[] node = new Node[N];
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			node[i] = new Node(temp, i);
		}
		Arrays.sort(node);
		
		
		int big = 0;
		for(int i=0; i<node.length; i++) {
			if(i+1<node.length && node[i].num==node[i+1].num) {
				node[i].big = big;
				continue;
			}
			node[i].big = big++;
		}
		
		Comparator<Node> mycom = new Comparator<Node>() {
			@Override
			public int compare(Node node1, Node node2) {
				return node1.len-node2.len;
			}
		};
		
		Arrays.sort(node, mycom);
		System.out.println();
		for(int i=0; i<N; i++) {
			bw.write(node[i].big+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

