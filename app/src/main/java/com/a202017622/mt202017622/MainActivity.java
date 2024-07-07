package com.a202017622.mt202017622;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_IMAGE=101;
    EditText idEditText;
    EditText pwEditText;
    TextView usedTimeText;
    int assignAble=1;
    int usedTime = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);
        Button assignButton = findViewById(R.id.assignButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        idEditText = findViewById(R.id.idEditText);
        usedTimeText = findViewById(R.id.usedTimeText);
        pwEditText = findViewById(R.id.pwEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "눌렸음", Toast.LENGTH_SHORT).show();

                String id = idEditText.getText().toString();
                String pw = pwEditText.getText().toString();
                if (id.equals("")) {
                    Toast.makeText(getApplicationContext(), "ID를 입력하세요", Toast.LENGTH_LONG).show();
                } else if (pw.equals("")) {
                    Toast.makeText(getApplicationContext(), "PW를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                if (id.equals(getId())) {
                    if (pw.equals(getPw())) {
                        //image activity로 넘어간다
                        Intent intent =new Intent(getApplicationContext(),ImageActivity.class);
                        startActivityForResult(intent,REQUEST_CODE_IMAGE);
                    } else {//pw가 일치하지 않을떄
                        Toast.makeText(getApplicationContext(), "PW가 일치하지 않습니다", Toast.LENGTH_LONG).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"등록되지 않은 사용자입니다",Toast.LENGTH_LONG).show();


            }
        });

        assignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(assignAble==1) {//회원등록이 가능할떄만.


                    String id = idEditText.getText().toString();
                    String pw = pwEditText.getText().toString();
                    if (id.equals("")) {
                        Toast.makeText(getApplicationContext(), "ID를 입력하세요", Toast.LENGTH_LONG).show();
                    } else if (pw.equals("")) {
                        Toast.makeText(getApplicationContext(), "PW를 입력하세요", Toast.LENGTH_SHORT).show();
                    } else {
                        saveState();
                        Toast.makeText(getApplicationContext(),"회원가입 완료",Toast.LENGTH_LONG).show();

                        assignAble = 0;//더이상 회원등록이 불가
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"회원등록이 불가능합니다",Toast.LENGTH_LONG).show();

            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원정보 삭제
            }
        });


    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", idEditText.getText().toString());
        editor.putString("pw", pwEditText.getText().toString());
        editor.commit();


    }

    protected String getId() {
        String id = null;
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("id"))) {
            id = pref.getString("id", "");

        }
        return id;
    }

    protected String getPw() {
        String pw = null;
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("pw"))) {
            pw = pref.getString("pw", "");

        }
        return pw;
    }
}