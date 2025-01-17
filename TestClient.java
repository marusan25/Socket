import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) {
		// 接続サーバ用TCPソケットのポート番号の設定
		final int SERVER_PORT = 50000;
		
		// コマンドラインでサーバのIPアドレスが設定されているかのチェック
		if(args.length != 1) {
			System.out.println("使い方：Client サーバのIPアドレス");
			System.exit(1); // プログラムの強制終了
		}
		
		try(
			// サーバに接続するSocketの作成(第1引数「IPアドレス」第2引数「ポート番号」)
			Socket socket = new Socket(args[0],SERVER_PORT);
			// データ受信用の入力ストリームを取得(文字コードはUTF-8)
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream(),"UTF-8"));
		) {
			// サーバから10回データを受信する
			for(int i = 0; i < 10; i++) {
			String result = bufferedReader.readLine(); // データ受信
			// 受信した結果をコンソールに出力
			if (result != null) {
				System.out.println("結果：" + result);
			}else {
				System.out.println("サーバーからのデータがありません");
				break; // データがなければループを抜ける
				}
			}
			
			// 全てのデータを受信し終わったらメッセージを表示
			System.out.println("接続が終了しました");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("通信中にエラーが発生しました");
		}
	}

}
