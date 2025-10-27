# Virtual Attendant
Repository: https://github.com/EdogawaCoder/virtual-attendant

------------------------------------------------------------
English Version
------------------------------------------------------------

Overview
This project is a Java REST API built with Spring Boot that integrates with the OpenAI API.
It simulates a virtual attendant, capable of receiving questions from users and responding intelligently in natural language.
The goal is to provide an example of conversational automation for customer support systems or chatbot services.

Features
- REST endpoint (/api/chat) to receive messages from clients.
- Integration with OpenAI API using your API key.
- Sends user input to the model and returns contextual replies.
- Clean architecture using Controller → Service → Client structure.
- Environment variables and API keys handled securely via application.properties.

Technologies
- Java 17+
- Spring Boot 3
- OpenAI API (GPT models)
- Maven
- RESTful Architecture

How to Run
1. Clone this repository:
   git clone https://github.com/EdogawaCoder/virtual-attendant.git
   cd virtual-attendant

2. Add your OpenAI API key to the application.properties:
   openai.api.key=your_api_key_here

3. Run the project:
   mvn spring-boot:run

4. Send a test request:
   curl -X POST http://localhost:8080/api/chat -H "Content-Type: application/json" -d "{"message": "Hello"}"

Example Response
{
  "reply": "Hello! How can I assist you today?"
}

Project Structure
src/
 └── main/
     ├── java/com/edogawa/virtualattendant/
     │    ├── controller/
     │    ├── service/
     │    └── client/
     └── resources/
          └── application.properties

------------------------------------------------------------
日本語版
------------------------------------------------------------

概要
このプロジェクトは Spring Boot で構築された Java REST API であり、OpenAI API と連携して動作します。
ユーザーからの質問を受け取り、自然な言葉で応答するバーチャルアテンダント（仮想受付）をシミュレートします。
カスタマーサポートやチャットボットシステムの自動化例として設計されています。

主な機能
- /api/chat エンドポイントでメッセージを受信。
- OpenAI API と統合し、APIキーを使用して応答を生成。
- ユーザーの入力をモデルに送信し、文脈に沿った回答を返す。
- Controller → Service → Client の構成でクリーンなアーキテクチャを採用。
- application.properties で安全に環境変数とAPIキーを管理。

使用技術
- Java 17以上
- Spring Boot 3
- OpenAI API（GPTモデル）
- Maven
- RESTfulアーキテクチャ

実行方法
1. リポジトリをクローンします。
   git clone https://github.com/EdogawaCoder/virtual-attendant.git
   cd virtual-attendant

2. application.properties に OpenAI APIキーを追加します。
   openai.api.key=your_api_key_here

3. プロジェクトを起動します。
   mvn spring-boot:run

4. 動作確認を行います。
   curl -X POST http://localhost:8080/api/chat -H "Content-Type: application/json" -d "{"message": "こんにちは"}"

応答例
{
  "reply": "こんにちは！今日はどのようにお手伝いできますか？"
}
