package com.a202017622.mt202017622;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    int imageState=0;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Button backButton = findViewById(R.id.backButton);
        Button imageChangeButton= findViewById(R.id.imageChangeButton);
        imageView=findViewById(R.id.imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        imageChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //이미지 바꾸는 기능
                changeImage();
            }
        });
    }
    private void changeImage(){

        if(imageState==0){
            imageState=1;
            Resources res= getResources();
            BitmapDrawable bitmap=(BitmapDrawable) res.getDrawable(R.drawable.paper2);
            int bitmapW=bitmap.getIntrinsicWidth();
            int bitmapH= bitmap.getIntrinsicHeight();
            imageView.setImageDrawable(bitmap);
            imageView.getLayoutParams().width=bitmapW;
            imageView.getLayoutParams().height=bitmapH;
        }
        else{
            imageState=0;
            Resources res= getResources();
            BitmapDrawable bitmap=(BitmapDrawable) res.getDrawable(R.drawable.paper);
            int bitmapW=bitmap.getIntrinsicWidth();
            int bitmapH= bitmap.getIntrinsicHeight();
            imageView.setImageDrawable(bitmap);
            imageView.getLayoutParams().width=bitmapW;
            imageView.getLayoutParams().height=bitmapH;
        }
    }
}