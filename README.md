# tapiopon-webhook
Discord Webhookを使ってメッセージを送信するシンプルなPaperMCプラグイン

## 使い方
最初にDiscordにてサーバー設定/連携サービス/ウェブフックからウェブフックを作成します。
作成したらウェブフックURLをコピーします。

次にPluginsフォルダにプラグインを入れてサーバーを起動して止めて、plugins/SimpleTapioponWebhook/config.ymlを編集します。

```yml
# Discord webhook URLを貼り付け
webhook: 'https://discord.com/api/webhooks/xxxxxxxx'

# 送信するメッセージ
message: 'Hello'
```

起動するとDiscordにメッセージが送信されます。