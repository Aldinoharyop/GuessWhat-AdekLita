package com.trydev.games.guesswhat;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ArticleOrtuActivity extends AppCompatActivity {

    String [] titles={"Title 1","Title 2","Title 3","Title 4","Title 5"};
    String [] descriptions={"Description 1","Description 2","Description 3","Description 4","Description 5"};
    int [] images={R.drawable.alita,R.drawable.alita,R.drawable.alita,R.drawable.alita,R.drawable.alita};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        lv=(ListView) findViewById(R.id.idListView);


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String[] daftarTitle = databaseAccess.getTitleOrtu();
        String[] daftarDeskripsi = databaseAccess.getDescOrtu();

        databaseAccess.close();

        MyOrtuAdapter adapter= new MyOrtuAdapter(this,daftarTitle,daftarDeskripsi,images);
        lv.setAdapter(adapter);
    }


}

class MyOrtuAdapter extends ArrayAdapter{
int[]imageArray;
String [] titleArray;
String[]descArray;

public MyOrtuAdapter(Context context, String []titles1, String[] descriptions1, int[] img1){
super(context,R.layout.example_custlistview_row,R.id.idTitle,titles1);
this.imageArray=img1;
this.titleArray=titles1;
this.descArray=descriptions1;
}

@NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
    LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View row=inflater.inflate(R.layout.example_custlistview_row,parent,false);

    ImageView myImage = (ImageView) row.findViewById(R.id.idPic);
    TextView myTitle=(TextView) row.findViewById(R.id.idTitle);
    TextView myDescription = (TextView) row.findViewById(R.id.idDescription);

    myImage.setImageResource(imageArray[position]);
    myTitle.setText(titleArray[position]);
    myDescription.setText(descArray[position]);
    return row;
}
}
