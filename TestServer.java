import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TestServer {

	public static void main(String[] args) {
		// 受信用ソケットのポート番号の設定
		final int LISTEN_PORT = 50000;
		
		// 処理を行った回数
		int count = 0;
		
		System.out.println("サーバー実行中");
		
		// ネットワーク処理は例外処理が必須
		// try-with-resources構文を利用(close処理の記述が不要)
		try(
				// 指定したポート番号でサーバ用TCPソケットを作成
				ServerSocket serverSocket = new ServerSocket(LISTEN_PORT);
				Socket socket = serverSocket.accept();
				PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), "UTF-8")
				);
				
		) {
			// 10回データを送信する
			for(int i = 0; i < 10; i++) {
			int result = getNumber();
			printWriter.println(result); // データ送信
			printWriter.flush();
			
			System.out.printf("送信した値(%d回)：%s%n", ++count,result);
			
			// 少し待機することで、クライアントがデータを受け取る間隔を作る
			Thread.sleep(500); // 0.5秒待機
			}
		}catch (IOException | InterruptedException e) {
			System.out.println("通信エラー発生");
		}

	}
	
	private static int getNumber() {
		int[] numbers = {1, 2, 3, 4};
		return numbers[new Random().nextInt(4)];
	}

}
