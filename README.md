# Overview
This project simulates a simple command-line virtual attendant that integrates with the OpenAI API (GPT models).
It was built as part of a personal study project to understand API integration, JSON/XML serialization, and user interaction through the Java console.

The attendant receives a user's name and question, sends the request to OpenAI's GPT model, and saves both the question and the generated answer in a structured format (JSON or XML).

# Features
- Integration with OpenAI API (GPT-5)
- User input handled via command-line interface
- Option to save sessions in JSON or XML format
- Uses HttpClient for API communication
- Handles environment variable for secure API key management
- Structured architecture with layered components (Controller, Service, Repository, Entity)

# Technologies Used
- Java 21
- Jackson~~~~ Databind (for JSON processing)
- HTTP Client (Java standard library)
- JAXP (for XML export)
- IntelliJ IDEA (recommended IDE)

# Setup
Requirements
- Java 21 or higher
- An OpenAI API key

# Environment Variable
Before running, define your OpenAI API key as an environment variable:

Windows (PowerShell):
setx OPENAI_API_KEY "your_api_key_here"

Linux / macOS (bash):
export OPENAI_API_KEY="your_api_key_here"

Running the Project
Open the project in IntelliJ IDEA and run the Main class.
The program will start in the console, asking for user input.

Usage Example
Be welcome at the virtual Customer Service

Enter the name of the user...: 
Write the question...........: 
Your question is being processed...
Response:

# Project Structure
src/
├─ controllers/
│   └─ CustomerServiceController.java
├─ entities/
│   └─ CustomerService.java
├─ repositories/
│   ├─ CustomServiceRepositoryJson.java
│   └─ CustomServiceServiceRepositoryXml.java
├─ services/
│   └─ OpenIAService.java
└─ Main.java

# Future Improvements
- Add a simple graphical interface (JavaFX)
- Improve error handling for failed API responses
- Implement conversation history management
- Include support for multiple language prompts

# License
This project is open-source and distributed for educational purposes.
Created by Edison Araujo (EdogawaCoder).

バーチャルアテンダント

# 概要
このプロジェクトは、OpenAI API（GPTモデル）と連携したシンプルなコマンドライン・バーチャルアテンダントをシミュレートします。
API連携、JSON/XMLシリアライゼーション、コンソールを通じたユーザー入力処理を学ぶために作成されました。

ユーザーの名前と質問を受け取り、OpenAIのGPTモデルに送信し、質問と生成された回答をJSONまたはXML形式で保存します。

# 機能
- OpenAI API（GPT-5）との連携
- コンソール入力によるユーザー対話
- JSONまたはXML形式での保存オプション
- HttpClientによるAPI通信
- 環境変数によるAPIキーの安全な管理
- Controller / Service / Repository / Entityによる階層化構造

# 使用技術
- Java 21
- Jackson Databind（JSON処理）
- HTTP Client（標準ライブラリ）
- JAXP（XML出力）
- IntelliJ IDEA（推奨IDE）

# セットアップ
必要条件
- Java 21以上
- OpenAI APIキー

環境変数設定
実行前にOpenAI APIキーを環境変数として設定します。

Windows (PowerShell):
setx OPENAI_API_KEY "your_api_key_here"

Linux / macOS (bash):
export OPENAI_API_KEY="your_api_key_here"

# 実行方法
IntelliJ IDEAでプロジェクトを開き、Mainクラスを実行します。
コンソール上でユーザー入力を受け付けるプログラムが起動します。


# プロジェクト構造
src/
├─ controllers/
│   └─ CustomerServiceController.java
├─ entities/
│   └─ CustomerService.java
├─ repositories/
│   ├─ CustomServiceRepositoryJson.java
│   └─ CustomServiceServiceRepositoryXml.java
├─ services/
│   └─ OpenIAService.java
└─ Main.java

# 今後の改善点
- シンプルなグラフィカルインターフェース（JavaFX）の追加
- APIエラー時の例外処理の改善
- 対話履歴の管理機能の実装
- 多言語プロンプト対応の拡張

# ライセンス
このプロジェクトは教育目的で公開されています。
作成者: Edison Araujo（EdogawaCoder）
