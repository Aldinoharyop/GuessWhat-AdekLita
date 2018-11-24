package com.trydev.games.guesswhat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.trydev.games.guesswhat.Quest.Quest;
import com.trydev.games.guesswhat.Service.MediaService;

import java.util.ArrayList;

import static com.trydev.games.guesswhat.MenuBalitaActivity.seek;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton fruit, animal, alphabet, color;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        fruit = (ImageButton) findViewById(R.id.fruit);
        animal = (ImageButton) findViewById(R.id.animal);
        alphabet = (ImageButton) findViewById(R.id.alphabet);
        color = (ImageButton) findViewById(R.id.color);

        mediaPlayer = MediaPlayer.create(this, R.raw.bgm);
        mediaPlayer.setLooping(true);
        start();

        fruit.setOnClickListener(this);
        animal.setOnClickListener(this);
        alphabet.setOnClickListener(this);
        color.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fruit:
                createFruitQuest();
                break;
            case R.id.animal:
                createAnimalQuest();
                break;
            case R.id.alphabet:
                crateAlphabetQuest();
                break;
            case R.id.color:
                crateColorQuest();
                break;
        }
        Intent intent;
        intent = new Intent(getApplicationContext(), GameActivity.class);
        mediaPlayer.pause();
        seek = mediaPlayer.getCurrentPosition();
        CategoryActivity.this.finish();
        startActivity(intent);
    }

    private void crateColorQuest() {
        ArrayList<Quest> colorQuest = new ArrayList<>();
        colorQuest.add(new Quest(R.drawable.error, "merah"));
        colorQuest.add(new Quest(R.drawable.home, "putih"));
        colorQuest.add(new Quest(R.drawable.love,"merah muda"));
        colorQuest.add(new Quest(R.drawable.music, "oranye"));
        colorQuest.add(new Quest(R.drawable.star,"kuning"));
        colorQuest.add(new Quest(R.drawable.success,"hijau"));
        colorQuest.add(new Quest(R.drawable.user,"ungu"));
        colorQuest.add(new Quest(R.drawable.water_drop,"biru"));
        GameActivity.myQuest = colorQuest;
    }

    private void crateAlphabetQuest() {
        ArrayList<Quest> alphabetQuest = new ArrayList<>();
        alphabetQuest.add(new Quest(R.drawable.water_drop, "a"));
    }

    private void createAnimalQuest() {
        ArrayList<Quest> animalQuest = new ArrayList<>();
        animalQuest.add(new Quest(R.drawable.bear, "beruang"));
        animalQuest.add(new Quest(R.drawable.cow, "sapi"));
        animalQuest.add(new Quest(R.drawable.crocodile, "buaya"));
        animalQuest.add(new Quest(R.drawable.deer, "rusa"));
        animalQuest.add(new Quest(R.drawable.donkey, "keledai"));
        animalQuest.add(new Quest(R.drawable.koala, "koala"));
        animalQuest.add(new Quest(R.drawable.panda, "panda"));
        GameActivity.myQuest = animalQuest;
    }

    private void createFruitQuest() {
        ArrayList<Quest> fruitQuest = new ArrayList<>();
        fruitQuest.add(new Quest(R.drawable.apple_correct, "apel"));
        fruitQuest.add(new Quest(R.drawable.banana_correct, "pisang"));
        fruitQuest.add(new Quest(R.drawable.cherry_correct, "ceri"));
        fruitQuest.add(new Quest(R.drawable.eggplant_correct, "eggplant"));
        fruitQuest.add(new Quest(R.drawable.grape_correct, "anggur"));
        fruitQuest.add(new Quest(R.drawable.orange_correct, "jeruk"));
        fruitQuest.add(new Quest(R.drawable.pear_correct, "pir"));
        fruitQuest.add(new Quest(R.drawable.strawberry_correct, "strawberry"));
        fruitQuest.add(new Quest(R.drawable.tomato_correct, "tomat"));
        GameActivity.myQuest = fruitQuest;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    protected void onStop() {
        mediaPlayer.pause();
        seek = mediaPlayer.getCurrentPosition();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        start();
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.pause();
        seek = mediaPlayer.getCurrentPosition();
        super.onBackPressed();
    }

    private void start(){
        if (seek>0){
            mediaPlayer.seekTo(seek);
        }
        mediaPlayer.start();
    }
}
