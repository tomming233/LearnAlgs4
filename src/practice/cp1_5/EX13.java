package practice.cp1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX13 {
	private int[] id;   // 夫链接数组
	private int[] sz;   // 各个根节点对应的分量大小
	private int count;
	
	public EX13(int N) {
		int count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++) sz[i] = 1;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int count() {
		return count;
	}
	
	public int find(int p) {
		int root = p;
		while (root != id[root]) {
			root = id[root];
		}
		while (id[p] != root) {
			int tmp = p;
			p = id[p];
			id[tmp] = root;
		}
		return root;
	}
	
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		if (sz[i] < sz[j]) {id[i] = j; sz[j] += sz[i];}
		else {id[j] = i; sz[i] += sz[j];}
		count--;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}

	}

}
