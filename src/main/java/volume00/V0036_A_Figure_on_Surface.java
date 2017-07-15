package volume00;

/**
 * 平面上の図形
縦 8、横 8 のマスからなる図 1 のような平面があります。 
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□

図１

この平面上に、以下の A から G の図形のどれかが一つだけ置かれています。

A
■	■		
■	■		
B
■		
■		
■		
■		
C
■	■	■	■

D
■		
■	■		
■			
E
■	■		
■	■	
F
■			
■	■		
■		
G
■	■	
■	■		

たとえば、次の図 2 の例では E の図形が置かれています。 
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	■	■	□	□	□	□	□
□	□	■	■	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□
□	□	□	□	□	□	□	□

図２

平面の中で図形が占めているマスを 1、占めていないマスを 0 で表現した数字の列を読み込んで、
置かれている図形の種類（A～G）を出力するプログラムを作成してください。

ただし、ひとつの平面に置かれている図形は必ず１つで、複数の図形が置かれていることはありません。
また、A～G で表される図形以外のものが置かれていることはありません。

Input
入力は複数のデータセットからなります。

１つのデータセットとして、平面の中で図形が占めているマスを 1、占めていないマスを 0 で表現した
 8 文字からなる 8 つの文字列が与えられます。例えば、図 2 に対応する文字列の並びは次のようになります。

0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0
0	1	1	0	0	0	0	0
0	0	1	1	0	0	0	0
0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0

データセットの間は１つの空行で区切られています。データセットの数は 50 を超えません。

Output
各データセットごとに、平面に与えられた図形の種類（A～G のいずれか）を１行に出力してください。

Sample Input
00000000
00000000
01100000
00110000
00000000
00000000
00000000
00000000

00011110
00000000
00000000
00000000
00000000
00000000
00000000
00000000

00000000
00000000
00110000
00110000
00000000
00000000
00000000
00000000
Output for the Sample Input
E
C
A
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0036_A_Figure_on_Surface {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty()) {
				break;
			}
			String[] lines = new String[9];
			lines[0] = line;
			for (int i = 1; i < 9; i++) {
				lines[i] = reader.readLine();
			}
			int[] nums = new int[4];
			int count = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (lines[i].charAt(j) == '1') {
						nums[count] = i * 8 + j;
						count++;
						if (count == 4) {
							break;
						}
					}
				}
			}
			int result = nums[3] - nums[0];
			switch (result) {
			case 9:
				System.out.println("A");
				break;
			case 24:
				System.out.println("B");
				break;
			case 3:
				System.out.println("C");
				break;
			case 15:
				System.out.println("D");
				break;
			case 10:
				System.out.println("E");
				break;
			case 17:
				System.out.println("F");
				break;
			default:
				System.out.println("G");
				break;
			}
		}
	}
}
