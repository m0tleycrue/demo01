# demo01
正式採用の「Kotlin」で挑戦！ 初めてのAndroidアプリ開発 〜ストップウォッチを作ってみよう〜 （https://employment.en-japan.com/engineerhub/entry/2017/06/23/110000）
の記事を読んで、ストップウォッチのアプリの作成に挑戦！

記事中にかかれていた課題点の解決をいたしました。  
・Android開発用のプラグインKotlin Android Extensionsを使って、findViewByIdを省略する  
⇛kotlin-android-extensionsを使用  
・関数の引数や返却値をnullableにすべきかどうか再考する  
⇛nullableを取りやめた  
  ⇛引数のtimeValueはInt型でプリミティブ型であるから、nullableである必要がないと判断しnullableを取りやめた。
  ⇛0から始まりtimeValue++でインクリメントであるため引数＜０の条件が成り立たない。戻り値にnullを返さなくなるからnullableを取りやめた。
# コード  
https://github.com/m0tleycrue/demo01/blob/master/app/src/main/java/org/example/stopwatch/MainActivity.kt

# レイアウト
https://github.com/m0tleycrue/demo01/blob/master/app/src/main/res/layout/activity_main.xml
