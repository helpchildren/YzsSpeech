## 简介
基于云知声的离线语音播报

## 权限申请
安卓6.0以上需要动态添加此权限的申请
android.permission.READ_PHONE_STATE

## 使用方法
  //先初始化 建议在Application中初始化
   YSpeech.getInstance().initSpeech(context);
  //语音播报
  YSpeech.getInstance().toSpeech("这是离线语音测试");
  //停止播报
  YSpeech.getInstance().stop();


项目根目录：build.gradle 添加以下代码

```groovy
buildscript {
    repositories {
        google()
        jcenter()
        maven{
            url 'http://192.168.126.254:8081/repository/maven-releases/'
        }// 添加maven库地址
    }
    dependencies {
    classpath "com.android.tools.build:gradle:4.1.1"
    }
}
allprojects {
    repositories {
        google()
        jcenter()
        maven{
            url 'http://192.168.126.254:8081/repository/maven-releases/'
        }// 添加maven库地址
    }
}
``

可添加远程类库依赖：
```groovy
dependencies {
implementation 'com.sesxh.android.plugins:yzsspeech:1.0.0'
}
```

