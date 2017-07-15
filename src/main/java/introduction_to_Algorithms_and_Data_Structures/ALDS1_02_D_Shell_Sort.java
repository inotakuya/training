package introduction_to_Algorithms_and_Data_Structures;

/*
 * Shell Sort
次のプログラムは、挿入ソートを応用して n 個の整数を含む数列 A を昇順に整列するプログラムです。

1  insertionSort(A, n, g)
2      for i = g to n-1
3          v = A[i]
4          j = i - g
5          while j >= 0 && A[j] > v
6              A[j+g] = A[j]
7              j = j - g
8              cnt++
9          A[j+g] = v
10
11 shellSort(A, n)
12     cnt = 0
13     m = ?
14     G[] = {?, ?,..., ?}
15     for i = 0 to m-1
16         insertionSort(A, n, G[i])
shellSort(A, n) は、一定の間隔 g だけ離れた要素のみを対象とした挿入ソートである insertionSort(A, n, g) を、
最初は大きい値から g を狭めながら繰り返します。これをシェルソートと言います。

上の疑似コードの ? を埋めてこのプログラムを完成させてください。n と数列 A が与えられるので、
疑似コード中の m、m 個の整数 G_i (i = 0, 1, ..., m － 1)、入力 Aを昇順にした列を出力するプログラムを作成してください。
ただし、出力は以下の条件を満 たす必要があります。

1 \leq m \leq 100
0 \leq G_i \leq n
cnt の値は \lceil n^{1.5}\rceil を超えてはならない
入力
1 行目に整数 n が与えられます。続く n 行目に n 個の整数 A_i (i=0,1,...,n-1) が与えられます。

出力
1 行目に整数 m、2 行目に m 個の整数 G_i (i=0,1,...,m-1) を空白区切りで出力してください。
3 行目に、G を用いた場合のプログラムが終了した直後の cnt　の値を出力してください。
続く n 行に整列した A_i (i=0,1,...,n-1) を出力してください。

この問題では、１つの入力に対して複数の解答があります。条件を満たす出力は全て正解となります。

制約
1 \leq n \leq 1,000,000
0 \leq A_i \leq 10^9
入力例 1
5
5
1
4
3
2
出力例 1
2
4 1
3
1
2
3
4
5
入力例 2
3
3
2
1
出力例 2
1
1
3
1
2
3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ALDS1_02_D_Shell_Sort {
	  static StringBuilder builder = new StringBuilder();
	  
	    public static void main(String[] args) throws NumberFormatException,
	            IOException {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                System.in));
	        int n = Integer.parseInt(reader.readLine());
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = Integer.parseInt(reader.readLine());
	        }
	        shellSort(a, n);
	        for (int i = 0; i < n; i++) {
	            builder.append(a[i]).append("\n");
	        }
	        System.out.print(builder);
	    }
	 
	    private static void shellSort(int[] a, int n) {
	        int[] g = new int[15];
	        int m = 0;
	        /*
	         * for (int i = 0; i < n; i = i * 3 + 1) { for (int j = m; 0 < j; j--) {
	         * g[j] = g[j - 1]; } g[0] = i; m++; } if (m == 0) { g[0] = 1; m = 1; }
	         */
	        for (int i = 1; i <= n; i = i * 3 + 1) {
	            g[m] = i;
	            m++;
	        }
	 
	        builder.append(m).append("\n");
	 
	        m--;
	        int cnt = 0;
	        for (int i = m; i >= 0; i--) {
	            if (i != m)
	                builder.append(" ");
	            builder.append(g[i]);
	            cnt += insertionSort(a, n, g[i]);
	        }
	        builder.append("\n").append(cnt).append("\n");
	    }
	 
	    private static int insertionSort(int[] a, int n, int g) {
	        int cnt = 0;
	        for (int i = g; i < n; i++) {
	            int key = a[i];
	            int j = i - g;
	            while (j >= 0 && a[j] > key) {
	                a[j + g] = a[j];
	                j = j - g;
	                cnt++;
	            }
	            a[j + g] = key;
	        }
	        return cnt;
	    }}