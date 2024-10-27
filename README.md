> [!TIP]
> Socket通信

### Socket通信の機能
---
### TestServer
- 受信用ソケットのポート番号の設定(50000)
- 指定したポート番号でサーバ用TCPソケットを作成
- for文を使ってサーバー側で10回（ランダムな値）ループを回し、10回連続でデータをクライアントにレスポンス
- 送信の間に Thread.sleep(500); を追加して、0.5秒ごとにデータを送信
- Thread.sleep(500); を追加して0.5秒ごとにデータを送信する理由は、サーバーとクライアント間のデータのやりとりをスムーズに行うため。具体的には、クライアント側でデータを受け取る時間を確保し、接続の負荷を減らすため
### TestClient
- 接続サーバ用TCPソケットのポート番号の設定(50000)
- サーバー側が10回リクエストを行うため、クライアント側でも10回レスポンスを受信するように、for 文を使って設定
- bufferedReader.readLine() で1行ずつデータを読み込み、読み込んだデータが null でないか確認。null が返ってきた場合は、サーバーからのデータの送信が終了したと見なし、ループを抜ける
