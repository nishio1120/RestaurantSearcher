### アプリ名
RestaurantSearcher

#### コンセプト
食べに行きたいお店がすぐ見つかる。

### 該当プロジェクトのリポジトリ URL（GitHub,GitLab など Git ホスティングサービスを利用されている場合）
https://github.com/nishio1120/RestaurantSearcher

## 開発環境
### 開発環境
Android Studio Hedgehog | 2023.1.1 Patch 2

### 開発言語
Kotlin 1.9.0

## 動作対象端末・OS
### 実機端末OS
Pixel 5a Android14

## 開発期間
14日間

## アプリケーション機能
APIKeyはプロジェクトのルートディレクトリにある local.properties ファイルに
```
API_KEY="YOUR_API_KEY"
```
の形式で、APIキーを設定して下さい。

### 機能一覧
- レストラン検索：ホットペッパーグルメサーチAPIを使用して、現在地周辺の飲食店を検索する。
- レストラン情報取得：ホットペッパーグルメサーチAPIを使用して、飲食店の詳細情報を取得する。
- キーワード検索：飲食店のジャンルや名前の一部で検索を絞れる。
- URL連携：飲食店のHotPepperのURLをアプリに表示する。

### 画面一覧
- 検索画面 ：条件を指定してレストランを検索する。
- 一覧画面 ：検索結果の飲食店を一覧表示する。
- 店舗詳細画面　: 選択された店舗の詳細を表示する。

### 不具合
エミュレータ端末からだと正しく位置情報が取得できないです。

### 使用しているAPI,SDK,ライブラリなど
- ホットペッパーグルメサーチAPI
- play-services-location
- kotlinx-serialization-json
- picasso
- retrofit
- moshi
- viewmodel
- runtime
- material
- livedata
- dagger.hilt
- secrets-gradle-plugin
- safeargs

#### こだわったポイント
なるべくユーザーの余分な操作が少なくなるようにこだわりました。

#### デザイン面にこだわったポイント
操作する場所が一目でわかるように色合いなどをこだわりました。

### アドバイスして欲しいポイント
より見やすいUIにするためにはどうすればいいか（特に店舗詳細画面）アドバイスいただきたいです。

### 自己評価
MVVMモデルや位置情報、daggerなど初めて触ったものが多くそれらを勉強し理解するのに時間がかかってしまいあまり機能をつけれなかったのが反省点でした。
