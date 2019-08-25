package com.todolist.forlogogenerator;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class EditActivityJ extends AppCompatActivity {
    private EditText input;
    private Button createBtn2;
    private Button imageBtn;
    private TextView error;
    private int btnPressed = 0;
    private ImageView imageView2;
    private String strUri;
    private Bitmap bitmap;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

         input = (EditText)findViewById(R.id.input_edit);
        createBtn2 = (Button)findViewById(R.id.createBtn2);
         error = (TextView)findViewById(R.id.errorMsg);
         imageBtn = (Button)findViewById(R.id.imageBtn);
         imageView2 = (ImageView)findViewById(R.id.imageView2);

         imageBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 checkPermission();
             }
         });

        createBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btnPressed == 0){
                    error.setText("画像を選んでください、画像を");
                }else{
                    infoForLogoJ info = new infoForLogoJ();
                    info.setName(input.getText().toString());
                    Toast.makeText(EditActivityJ.this,info.getName(),Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(EditActivityJ.this, ResultActivity.class);
                    intent.putExtra("name",info.getName());
                    intent.putExtra("uri",strUri);
                    startActivity(intent);
                }
            }
        });
    }

    public void checkPermission(){
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED){
            pickImageFromGarally();
        }else{
            requestGallery();
        }
    }

    private final int IMAGE_PICK_CODE = 1000;
    private final int PERMISSION_CODE = 1001;

      public void requestGallery() {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            requestPermissions(permissions, PERMISSION_CODE);
        }else{
            requestPermissions(permissions,PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grandResults){
        switch(requestCode){
            case PERMISSION_CODE:
            if(grandResults.length>0 && grandResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"call", Toast.LENGTH_LONG).show();
                pickImageFromGarally();
                break;
            }else {
                Toast.makeText(this, "画像とれませんでした", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void pickImageFromGarally(){
        Toast.makeText(this,"pickImageFromGallery", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/jpeg");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            btnPressed = 1;
            Toast.makeText(this, "onActivityResult", Toast.LENGTH_LONG).show();
            imageView2.setImageURI(data.getData());
            strUri = data.getData().toString();
            /*setImageUri(data.setData())*/
        }
    }
}




    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        createBtn2.setOnClickListener {
            var name:TextView= findViewById<TextView>(R.id.name)
                    var errorMsg:TextView = findViewById<TextView>(R.id.errorMsg)
            if(input_edit.text != null){
                // 取得したテキストを TextView に張り付ける
                var info = infoForLogo()
                info.name = input_edit.text.toString()
                setContentView(R.layout.created_view)
            }else{
                errorMsg.text = "入力してください"
            }
        }
    }
    */

