package introduction_to_programming;

/*複数の Hello World の出力

1000 個の "Hello World" を出力するプログラムを作成して下さい。

Input
この問題に入力はありません。

Output
各行に "Hello World" と書かれた 1000 行の文字列を出力して下さい。*/

public class ITP1_3_A_PrintManyHelloWorld {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++)
			System.out.println("Hello World");
	}
}
