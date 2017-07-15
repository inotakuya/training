package volume00;

/**
 * 何曜日？
2004 年 1 月 1 日から 12 月 31 日までの日付を入力し、その日の曜日を出力するプログラムを作成して下さい。
なお、2004 年 1 月 1 日は木曜日です。また、2004 年はうるう年ですので 2 月29 日があることに注意して下さい。

Input
複数のデータセットを処理しなければなりません。１つのデータセットに月と日が１つのスペースで区切られて１行に与えられます。
月が 0 となったとき入力の最後とします（この場合は処理をしないでプログラムを終了させる）。

データセットの数は 50 を超えません。

Output
各データセットごとに曜日を英語で１行に出力して下さい。以下の訳を参考にして出力して下さい。

月曜日 Monday
火曜日 Tuesday
水曜日 Wednesday
木曜日 Thursday
金曜日 Friday
土曜日 Saturday
日曜日 Sunday
Sample Input
1 1
2 29
0 0
Output for the Sample Input
Thursday
Sunday
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

public class V0027_What_day_is_today {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String data;
		while (true) {
			data = reader.readLine();
			if (data.charAt(0) == '0')
				break;
			StringTokenizer tokenizer = new StringTokenizer(data);
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int date = Integer.parseInt(tokenizer.nextToken());

			Calendar calendar = Calendar.getInstance();
			calendar.set(2004, month, date);
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			switch (week) {
			case 1:
				System.out.println("Sunday");
				break;
			case 2:
				System.out.println("Monday");
				break;
			case 3:
				System.out.println("Tuesday");
				break;
			case 4:
				System.out.println("Wednesday");
				break;
			case 5:
				System.out.println("Thursday");
				break;
			case 6:
				System.out.println("Friday");
				break;
			default:
				System.out.println("Saturday");
				break;
			}
		}
	}
}
