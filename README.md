> [!TIP]
> Socket通信

### Socket通信の機能
---
### TestServer
- 受信用ソケットのポート番号の設定(50000)
- 指定したポート番号でサーバ用TCPソケットを作成
- for文を使ってサーバー側で10回(ランダムな値)ループを回し、10回連続でデータをクライアントに送信
- 送信の間に Thread.sleep(500); を追加して、0.5秒ごとにデータを送信
- Thread.sleep(500); を追加して 0.5 秒ごとにデータを送信する理由は、サーバーとクライアントのデータのやりとりをスムーズに行うため。具体的には、クライアント側でデータを受け取る時間を確保するため・接続の負荷を減らすため

### TestClient
- 接続サーバ用TCPソケットのポート番号の設定(50000)
- 送信回数に合わせたfor文を使って、サーバーから送られる複数のデータを受信するように設定。サーバー側のfor文が10回のデータ送信を行うようになったので、クライアント側でも10回受信するように設定
- bufferedReader.readLine()で1行ずつデータを読み込み、読み込んだデータがnullでないか確認。nullが返ってきた場合は、サーバーからのデータが終了したと見なし、ループを抜ける
