package com.todolist.forlogogenerator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    private String logo;
    private TextView textview;
    private ImageView imageView;
    private Button saveBtn;
    private Spinner spinner;
    private Spinner spinner2;

    private int preX;
    private int preY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //findViewById
        textview = (TextView) findViewById(R.id.name111);
        imageView = findViewById(R.id.imageView);
        saveBtn = findViewById(R.id.saveBtn);
        spinner = findViewById(R.id.font_spinner);
        spinner2 = findViewById(R.id.color_spinner);

        //Intentから値取得
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String strUri = intent.getStringExtra("uri");
        Uri uri = Uri.parse(strUri);    //string->uri

        //Infoに属性をセット
        infoForLogoJ info = new infoForLogoJ();
        info.setName(name);

        //viewに値をセット
        textview.setText(name);
        imageView.setImageURI(uri);

        //スピナー
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                setNewFontFromSpinner(spinner,textview);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                setNewColorFromSpinner(spinner2,textview);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /*imageView2.setImageBitmap(image);*/

        textview.layout(0,0, textview.getWidth(),textview.getWidth());

    }


    public void setNewFontFromSpinner(Spinner spinner, TextView textView){
        String [] labels = getResources().getStringArray(R.array.font_array);
        String item = (String)spinner.getSelectedItem();

        switch(item){
            case "ふつう":
                textView.setTypeface(Typeface.SERIF);
                break;
            case "斜体":
                textView.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
                break;
            case "太字":
                textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
                break;
        }
    }

    public void setNewColorFromSpinner(Spinner spinner, TextView textView) {
        String[] labels = getResources().getStringArray(R.array.color_array);
        String color = (String) spinner2.getSelectedItem();

        switch (color) {
            case "黒":
                textview.setTextColor(Color.BLACK);
                break;
            case "ダークグレー":
                textview.setTextColor(Color.parseColor("#a9a9a9"));
                break;
            case "グレー":
                textview.setTextColor(Color.parseColor("#808080"));
                break;
            case "白":
                textview.setTextColor(Color.WHITE);
                break;
            case "青":
                textview.setTextColor(Color.BLUE);
                break;
            case "ラベンダー":
                textview.setTextColor(Color.parseColor("#e6e6fa"));
                break;
            case "ミッドナイトブルー":
                textview.setTextColor(Color.parseColor("#191970"));
                break;
            case "紫":
                textview.setTextColor(Color.parseColor("#800080"));
                break;
            case "紺":
                textview.setTextColor(Color.parseColor("#000080"));
                break;
            case "赤":
                textview.setTextColor(Color.RED);
                break;
            case "サーモン":
                textview.setTextColor(Color.parseColor("#fa8072"));
                break;
            case "ダークピンク":
                textview.setTextColor(Color.parseColor("#ff1493"));
                break;
            case "ピンク":
                textview.setTextColor(Color.parseColor("#ffc0cb"));
                break;
            case "ライトピンク":
                textview.setTextColor(Color.parseColor("#ffb6c1"));
                break;
            case "黄色":
                textview.setTextColor(Color.YELLOW);
                break;
            case "オレンジ":
                textview.setTextColor(Color.parseColor("#fd7e00"));
                break;
            case "ダークオレンジ":
                textview.setTextColor(Color.parseColor("#ff8c00"));
                break;
            case "緑":
                textview.setTextColor(Color.GREEN);
                break;
            case "黄緑":
                textview.setTextColor(Color.parseColor("#adff2f"));
                break;
            case "アクアマリン":
                textview.setTextColor(Color.parseColor("#7fffd4"));
                break;
            case "オリーヴ":
                textview.setTextColor(Color.parseColor("#808000"));
                break;
            case "茶色":
                textview.setTextColor(Color.parseColor("#a52a2a"));
                break;
            case "チョコレート":
                textview.setTextColor(Color.parseColor("#d2691e"));
                break;
            case "お楽しみ色":
                textview.setTextColor(Color.parseColor("#00eaea"));
                break;
            default:
                textview.setTextColor(Color.BLACK);

        }
    }



    @Override
    public boolean onTouchEvent(MotionEvent event){
        //x,y位置ください
        int newX = (int)event.getRawX();
        int newY = (int)event.getRawY();

        switch(event.getAction()){
            case MotionEvent.ACTION_MOVE:
                int dx = textview.getLeft()+(newX-preX);
                int dy = textview.getTop()+(newY-preY);
                int txtW = dx+textview.getWidth();
                int txtH = dy+textview.getHeight();

                textview.layout(dx, dy, txtW, txtH);
                break;

            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP :
                break;
        }

        preX  = newX;
        preY = newY;

        return true;

    }



}