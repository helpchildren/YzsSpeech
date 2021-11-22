package com.sesxh.yzsspeech;

import android.content.Context;
import android.util.Log;

import com.unisound.client.SpeechConstants;
import com.unisound.client.SpeechSynthesizer;

public class YSpeech {

    private SpeechSynthesizer mTTSPlayer;
    private String appKey = "zv5sv43s4lcny7pbfhzdlg33ue2vanwjt4odthap";
    private String secret = "d3553cbfa75c130ff05f2e4da5d8cd96";

    private static volatile YSpeech instance = null;

    public static YSpeech getInstance() {
        if (instance == null) {
            synchronized (YSpeech.class) {
                if (instance == null) {
                    instance = new YSpeech();
                }
            }
        }
        return instance;
    }

    public YSpeech() {

    }

    public void setAppKey(String appKey, String secret) {
        this.appKey = appKey;
        this.secret = secret;
    }

    public void initSpeech(Context context){
        initSpeech(context, appKey, secret);
    }

    /*
    * 语音初始化
    * */
    public void initSpeech(Context context, String appKey, String secret) {
        if (mTTSPlayer == null) {
            //1. 创建语音合成对象, appKey和secret通过 http://dev.hivoice.cn/ 网站申请
            mTTSPlayer = new SpeechSynthesizer(context, appKey, secret);
        }
        //2. 设置语音合成参数,设置语音合成模式为本地合成。
        mTTSPlayer.setOption(SpeechConstants.TTS_SERVICE_MODE, SpeechConstants.TTS_SERVICE_MODE_LOCAL);
        //4. 初始化语音合成引擎
        mTTSPlayer.init(null);
    }

    public void toSpeech(String txt){
        if (mTTSPlayer == null){
            Log.e("toSpeech", "mTTSPlayer is null");
            return;
        }
        //5. 开始语音合成并播报
        mTTSPlayer.playText(txt);

    }

    public void stop(){
        if (mTTSPlayer != null) {
            mTTSPlayer.stop();
        }
    }


}