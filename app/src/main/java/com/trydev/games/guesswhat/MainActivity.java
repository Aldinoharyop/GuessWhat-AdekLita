package com.trydev.games.guesswhat;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView Menu1, Menu2, MenuTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        Menu1 = (ImageView) findViewById(R.id.pgBalita);
        Menu2 = (ImageView) findViewById(R.id.pgOrtu);

        AssetManager assetManager = this.getAssets();
        InputStream is1= null;
        InputStream is2= null;

        try {
            is1 = assetManager.open("img/baby1.png");
            is2 = assetManager.open("img/ortu1.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap1 = BitmapFactory.decodeStream(is1);
        Bitmap bitmap2 = BitmapFactory.decodeStream(is2);
        Menu1.setImageBitmap(bitmap1);
        Menu2.setImageBitmap(bitmap2);
    }

    //cara kedua
    public void pageBalita(View view) {
        Intent hitungIntent = new Intent(MainActivity.this,MenuBalitaActivity.class);
        startActivity(hitungIntent);

    }


    public void pageOrtu(View view){
        Intent i = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(i);
    }


}
