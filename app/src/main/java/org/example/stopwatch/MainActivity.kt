package org.example.stopwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    /** イベントハンドラ */
    val handler = Handler()
    /** 秒 */
    var timeValue = 0

    /**
     * Main Activity作成
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = start    // スタートボタン
        val stopButton = stop      // ストップボタン
        val resetButton = reset    // リセットボタン

        val runnable = object : Runnable {
            override fun run() {
                // 秒数カウント
                timeValue++

                // テキストの秒表示用に整形
                timeToText(timeValue).let {
                    // テキスト表示部に返り値を設定
                    timeText.text = it
                }
                // 1000ミリ秒単位にwaitして処理を実行
                handler.postDelayed(this, 1000)
            }
        }

        // スタートボタン押下時に秒数カウント処理を実行
        startButton.setOnClickListener {
            handler.post(runnable)
        }

        // ストップボタン押下時に秒数カウント処理を停止
        stopButton.setOnClickListener {
            handler.removeCallbacks(runnable)
        }

        // リセットボタン押下時に秒数カウントを停止し、秒数を0にする
        resetButton.setOnClickListener {
            handler.removeCallbacks(runnable)
            timeValue = 0
            timeToText().let {
                timeText.text = it
            }
        }
    }


    /**
     * 秒をhh:mm:ssに変換する
     * @param time : 秒 省略値 0
     * @return hh:mm:ss 表示形式の文字列
     */
    private fun timeToText(time: Int = 0): String {
        return when(time) {
            0 -> resources.getString(R.string._00_00_00)
            else -> {
                val h = time / 3600
                val m = time % 3600 / 60
                val s = time % 60
                resources.getString(R.string.format).format(h, m, s)
            }
        }
    }
}
