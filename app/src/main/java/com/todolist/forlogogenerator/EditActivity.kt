/*package com.todolist.forlogogenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

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
}

*/