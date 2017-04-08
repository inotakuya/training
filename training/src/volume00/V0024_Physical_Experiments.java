package volume00;

/**
 * 物理の実験
地球上で物体を静かに落下させたとき、空気抵抗などの影響を考えないとすると、t 秒後の物体の速度 
v,t 秒中に物体が落下した距離y は、

v=9.8t
y=4.9t2

で与えられます。

ある人が、建物の高い位置からガラスの球を落下させて、ガラスの球が割れるかどうかを調べる実験を行っています。

入力データとして、球が割れるのに必要な最低速度が与えられます。球を割るには、建物の少なくとも何階以上から落とす必要があるかを求め、
その階を出力するプログラムを作成して下さい。なお、建物の N 階の高さは 5×N−5 で与えられるものとします。

Input
複数のデータセットが与えられます。各データセットに球が割れるのに必要な最低速度（実数）が１行に与えられます。
入力の最後まで処理して下さい。データセットの数は 50 を超えません。

Output
各データセットに対して、そこから落とすと球が割れる最低の階数（整数）を１行に出力して下さい。

Sample Input
25.4
25.4
Output for the Sample Input
8
8
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V0024_Physical_Experiments {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String data;
		while ((data = reader.readLine()) != null) {
			double a = Double.parseDouble(data);
			double y = Math.pow(a / 9.8, 2) * 4.9;
			System.out.println((int) (Math.ceil((y + 5) / 5)));
		}
	}
}
