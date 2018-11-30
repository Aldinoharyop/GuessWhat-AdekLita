package com.trydev.games.guesswhat;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MenuActivity extends AppCompatActivity {
    Button btnHitung;
    private ImageView Menu1, Menu2, MenuTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuortu);
//        getSupportActionBar().hide();

        Menu1 = (ImageView) findViewById(R.id.menubmi);
        Menu2 = (ImageView) findViewById(R.id.menubalita);
        MenuTentang = (ImageView) findViewById(R.id.menuortu);

        AssetManager assetManager = this.getAssets();
        InputStream is1= null;
        InputStream is2= null;
        InputStream is3= null;

        try {
            is1 = assetManager.open("img/btnhitung.png");
            is2 = assetManager.open("img/btnarticlebalita.png");
            is3 = assetManager.open("img/btnarticleortu.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap1 = BitmapFactory.decodeStream(is1);
        Bitmap bitmap2 = BitmapFactory.decodeStream(is2);
        Bitmap bitmap3 = BitmapFactory.decodeStream(is3);
        Menu1.setImageBitmap(bitmap1);
        Menu2.setImageBitmap(bitmap2);
        MenuTentang.setImageBitmap(bitmap3);

        //cara pertama
        /*btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    //cara kedua
    public void hitung(View view) {
        Intent hitungIntent = new Intent(MenuActivity.this,HitungActivity.class);
        startActivity(hitungIntent);

    }

    public void goToOrtu(View view){
        Intent i = new Intent(MenuActivity.this, ArticleOrtuActivity.class);
        startActivity(i);
    }


    public void goToBalita(View view){
        Intent i = new Intent(MenuActivity.this, ArticleBalitaActivity.class);
        startActivity(i);
    }


}
