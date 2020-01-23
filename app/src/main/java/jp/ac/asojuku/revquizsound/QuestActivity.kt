package jp.ac.asojuku.revquizsound

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quest.*

class QuestActivity : AppCompatActivity() {
    //soundPool型のインスタンス変数のフィールドプロパティを宣言
    private lateinit var soundPool: SoundPool;
    //効果音の音源（sound）のリソースID
    private var missId = 0//仮の番号で初期化
    private var questionId = 0//仮の番号で初期化
    private var bingoId = 0//仮の番号で初期化
    private var hakusyuId = 0//仮の番号で初期化


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)
    }


    override fun onResume() {
        super.onResume()

        this.soundPool =
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                SoundPool(
                    2,//SoundPoolクラスのコンストラクタ
                    AudioManager.STREAM_ALARM,//同時に鳴らせる音源数の設定
                    0//音源品質。現在未使用。初期値の０を設定する
                )
            }else{
                //新しい端末の時
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM).build();
                //オーディオ設定を使ってSoundPoolのインスタンスを作る
                SoundPool.Builder().setMaxStreams(1)//同時音源数（１）
                    .setAudioAttributes(audioAttributes)//オーディオ設定を登録
                    .build();//ビルド

            }

        //鳴らすサウンドファイルのリソースIDを設定
        this.missId = soundPool.load(
            this,//アクティビティのインスタンス（自分自身）
            R.raw.miss,//鳴らす音源のリソースID
            1//音の優先順位。現在は使用されていない。互換性ののために設定
        )
        this.questionId = soundPool.load(
            this,//アクティビティのインスタンス（自分自身）
            R.raw.question,//鳴らす音源のリソースID
            1//音の優先順位。現在は使用されていない。互換性ののために設定
        )
        this.bingoId = soundPool.load(
            this,//アクティビティのインスタンス（自分自身）
            R.raw.bingo,//鳴らす音源のリソースID
            1//音の優先順位。現在は使用されていない。互換性ののために設定
        )
        this.hakusyuId = soundPool.load(
            this,//アクティビティのインスタンス（自分自身）
            R.raw.hakusyu,//鳴らす音源のリソースID
            1//音の優先順位。現在は使用されていない。互換性ののために設定
        )



        this.miss.setOnClickListener{
            soundPool.play(
                missId,//サウンドリソースID（音を指定する）
                1.0f,//左ボリューム（0.0f~1.0f）
                1.0f,//右ボリューム（0.0f~0.0f）
                0,//優先度
                0,//ループする（１）、ループしない（０）
                1.0f  //再生スピード（1.0=通常。0.5~2.0までの範囲）


            )

        }

        this.bingo.setOnClickListener{
            soundPool.play(
                bingoId,//サウンドリソースID（音を指定する）
                1.0f,//左ボリューム（0.0f~1.0f）
                1.0f,//右ボリューム（0.0f~0.0f）
                0,//優先度
                0,//ループする（１）、ループしない（０）
                1.0f  //再生スピード（1.0=通常。0.5~2.0までの範囲）


            )

        }

        this.question.setOnClickListener{
            soundPool.play(
                questionId,//サウンドリソースID（音を指定する）
                1.0f,//左ボリューム（0.0f~1.0f）
                1.0f,//右ボリューム（0.0f~0.0f）
                0,//優先度
                0,//ループする（１）、ループしない（０）
                1.0f  //再生スピード（1.0=通常。0.5~2.0までの範囲）


            )

        }

        this.hakusyu.setOnClickListener{
            soundPool.play(
                hakusyuId,//サウンドリソースID（音を指定する）
                1.0f,//左ボリューム（0.0f~1.0f）
                1.0f,//右ボリューム（0.0f~0.0f）
                0,//優先度
                0,//ループする（１）、ループしない（０）
                1.0f  //再生スピード（1.0=通常。0.5~2.0までの範囲）


            )

        }









        kaitou_btn.setOnClickListener{
            //画面遷移用のインテントを生成
            val intent = Intent(this,MainActivity::class.java);
            //インテントを元に画面遷移を実行
            this.startActivity(intent);

        }

    }
}
