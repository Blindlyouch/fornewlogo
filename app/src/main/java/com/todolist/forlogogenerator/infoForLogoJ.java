package com.todolist.forlogogenerator;

import android.graphics.Bitmap;
import android.net.Uri;

public class infoForLogoJ {

    //属性
    private String name;
    private Bitmap bitmap;
    private Uri uri;

    //コンストラクタ
    public infoForLogoJ(){}

    //ゲッター
    public Bitmap getBitmap(){return bitmap; }
    public String getName() {
        return name;
    }
    public Uri getUri(){return uri;}

    //セッター
    public void setUri(Uri uri){this.uri = uri;}
    public void setBitmap(Bitmap bitmap){this.bitmap = bitmap;}
    public void setName(String name) {
        this.name = name;
    }

}
