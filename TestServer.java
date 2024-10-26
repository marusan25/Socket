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
		
		System.out.println("サーバー実行中");
		
		// ネットワーク処理は例外処理が必須
		// try-with-resources構文を利用(close処理の記述が不要)
		try(
				// 指定したポート番号でサーバ用TCPソケットを作成
				ServerSocket serverSocket = new ServerSocket();
				Socket socket = serverSocket.accept();
				PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), "UTF-8")
				);
				
		) {
			int result = getNumber();
			printWriter.println(result);
			printWriter.flush();
			
			System.out.println("送信した値：" + result);

		}catch (IOException e) {
			System.out.println("通信エラー発生");
		}

	}
	
	private static int getNumber() {
		int[] numbers = {1, 2, 3, 4};
		return numbers[new Random().nextInt(1, 5)];
	}

}
