package introduction_to_Algorithms_and_Data_Structures;

/*
 * グラフ
グラフ G = (V, E) の表現方法には隣接リスト(adjacency list) による表現と隣接行列(adjacency matrices)による表現があります。

隣接リスト表現では、V の各頂点に対して１個、合計 |V| 個のリスト Adj[|V|] でグラフを表します。頂点 u に対して、
隣接リスト Adj[u] は E に属する辺 (u, v_i) におけるすべての頂点 v_i を含んでいます。
つまり、Adj[u] は G において u と隣接するすべての頂点からなります。

一方、隣接行列表現では、頂点 i から頂点 j へ辺がある場合 a_{ij} が 1、ない場合 0 であるような |V| \times |V| の行列 A でグラフを表します。

隣接リスト表現の形式で与えられた有向グラフ G の隣接行列を出力するプログラムを作成してください。
G は n\; (=|V|) 個の頂点を含み、それぞれ 1 から n までの番号がふられているものとします。

入力
最初の行に G の頂点数 n が与えられます。続く n 行で各頂点 u の隣接リスト Adj[u] が以下の形式で与えられます：

u k v_1 v_2 ... v_k

u は頂点の番号、k は u の出次数、v_1\;v_2\; ...\; v_k　は u に隣接する頂点の番号を示します。

出力
出力例に従い、G の隣接行列を出力してください。a_{ij} の間に１つの空白を入れてください。

制約
1 \leq n \leq 100
入力例
4
1 2 2 4
2 1 4
3 0
4 1 3
出力例
0 1 0 1
0 0 0 1
0 0 0 0
0 0 1 0
 */
import java.util.Scanner;

public class ALDS1_11_A_Graph {
	 public static void main(String[] args) {
	        new ALDS1_11_A_Graph().run();
	    }
	 
	    private void run() {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int[][] m = new int[n][n];
	        for (int i = 0; i < n; i++) {
	            int u = scanner.nextInt();
	            int k = scanner.nextInt();
	            u--;
	            for (int j = 0; j < k; j++) {
	                int v = scanner.nextInt();
	                v--;
	                m[u][v] = 1;
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                System.out.print(m[i][j]);
	                System.out.print(j == n - 1 ? '\n' : ' ');
	            }
	        }
	 
	    }
}
