package introduction_to_Algorithms_and_Data_Structures;

/*
 * クイックソート
n 枚のカードの列を整列します。１枚のカードは絵柄(S, H, C, またはD)と数字のペアで構成されています。
これらを以下の疑似コードに基づくクイックソートで数字に関して昇順に整列するプログラムを作成してください。partition は ALDS1_6_B の疑似コードに基づくものとします。

1 quicksort(A, p, r)
2   if p < r
3     q = partition(A, p, r)
4     quickSort(A, p, q-1)
5     quickSort(A, q+1, r)
ここで、A はカードが格納された配列であり、partition における比較演算はカードに書かれた「数」を基準に行われるものとします。

また、与えられた入力に対して安定な出力を行っているかを報告してください。ここでは、同じ数字を持つカードが複数ある場合、
それらが入力で与えられた順序であらわれる出力を「安定な出力」とします。

入力
1行目にカードの枚数 n が与えられます。

2行目以降で n 枚のカードが与えられます。各カードは絵柄を表す１つの文字と数（整数）のペアで１行に与えられます。
絵柄と数は１つの空白で区切られています。

出力
1行目に、この出力が安定か否か（StableまたはNot stable）を出力してください。

2行目以降で、入力と同様の形式で整列されたカードを順番に出力してください（n を出力する必要はありません）。

制約
1 \leq n \leq 100,000
1 \leq カードに書かれている数 \leq 10^9
入力に絵柄と数の組が同じカードは２枚以上含まれない
入力例 1
6
D 3
H 2
D 1
S 3
D 2
C 1
出力例 1
Not stable
D 1
C 1
D 2
H 2
D 3
S 3
入力例 2
2
S 1
H 1
出力例 2
Stable
S 1
H 1
 */
import java.util.Scanner;

public class ALDS1_06_C_Quick_Sort {
	long count = 0;
	 
    public static void main(String[] args) {
        new ALDS1_06_C_Quick_Sort().run();
    }
 
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Card[] A = new Card[n];
        for (int i = 0; i < n; i++) {
            A[i] = new Card(scanner.next().charAt(0), scanner.nextInt(), i);
        }
        quicksort(A, 0, n - 1);
        boolean flag = true;
        int off;
        int[] I = new int[4];
        loop: for (int i = 0; i < n; i += off) {
            I[0] = A[i].idx;
            off = 1;
            while (i + off < n && A[i].num == A[i + off].num) {
                I[off] = A[i + off].idx;
                off++;
            }
            if (off != 1) {
                for (int j = 1; j < off; j++) {
                    if (I[j - 1] > I[j]) {
                        flag = false;
                        break loop;
 
                    }
                }
            }
        }
        if (flag)
            System.out.println("Stable");
        else
            System.out.println("Not stable");
        for (int i = 0; i < n; i++) {
            System.out.println(A[i].pic + " " + A[i].num);
        }
 
    }
 
    private void quicksort(Card[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A, q + 1, r);
        }
 
    }
 
    private int partition(Card[] a, int p, int r) {
        Card work;
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j].num <= a[r].num) {
                i++;
                work = a[i];
                a[i] = a[j];
                a[j] = work;
            }
        }
        work = a[i + 1];
        a[i + 1] = a[r];
        a[r] = work;
        return i + 1;
    }
 
    class Card {
        char pic;
        int num;
        int idx;
 
        public Card(char pic, int num, int idx) {
            this.pic = pic;
            this.num = num;
            this.idx = idx;
        }
 
        @Override
        public String toString() {
            return "[p=" + pic + ", n=" + num + ", id=" + idx + "]\n";
        }
 
    }
}
