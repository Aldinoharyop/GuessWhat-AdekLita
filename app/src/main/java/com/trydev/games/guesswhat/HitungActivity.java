package com.trydev.games.guesswhat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class HitungActivity extends AppCompatActivity {
    EditText edtNama, edtBB, edtTB,edtUsia;
    RadioButton radioButtonL;
    RadioButton radioButtonP;
    String jeniskelamin;
    String hasil;
    String ket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);
//        getSupportActionBar().setTitle("Hitung Berat Badan Ideal Balita");
        edtNama = (EditText)findViewById(R.id.edit_text_nama);
        edtBB = (EditText)findViewById(R.id.edit_text_bb);
        edtTB = (EditText)findViewById(R.id.edit_text_tb);
        edtUsia = (EditText)findViewById(R.id.edit_text_usia);
        radioButtonL = (RadioButton)findViewById(R.id.radio_btn_lk);
        radioButtonP=(RadioButton)findViewById(R.id.radio_btn_p);
    }

    public void cekHasil(View view) {
        String nama = edtNama.getText().toString().trim();
        String sBeratBadan = edtBB.getText().toString().trim();
        String sTinggiBadan = edtTB.getText().toString().trim();

        if(edtNama.getText().toString().equals("")||edtUsia.getText().toString().equals("")||edtBB.getText().toString().equals("")||edtTB.getText().toString().equals("")||(!radioButtonP.isChecked()&&!radioButtonL.isChecked())){
            Toast.makeText(getApplicationContext(),"Mohon untuk melengkapi data",Toast.LENGTH_SHORT).show();
        }
        else{
            double beratBadan = Double.parseDouble(sBeratBadan);
            double tinggiBadan = Double.parseDouble(sTinggiBadan);
            int usia=Integer.parseInt(edtUsia.getText().toString());

            //rumus
//            1. untuk anak dibawah 12 bulan : BBI = (n : 2) + 4
//            atau (umur (bln) : 2 ) + 4
//
//            2. untuk anak 1-10 thn : BBI = (2 x n) + 8
//            atau (2 x umur (thn)) + 8
            double bbi =0;
            if(usia<12){
bbi=(usia/2)+4;
}else{
                int usiaThn=usia/12;
bbi=(2*usiaThn)+8;
}

            Log.d("tag","Nama = "+nama+"\nbbi = "+bbi+"\n jenis kelamin : "+jeniskelamin);
            if(jeniskelamin.equals("Perempuan")){
                if(usia<12){
                    if(beratBadan==bbi){
                        hasil="Ideal";
                        ket = "Sebaiknya dipertahankan berat badannya. ";
                    }else if(beratBadan<bbi){
                        hasil="Under Weight/Kurus";
                        ket = "Sebaiknya mulai menambah berat badan. ";
                    }else{
                        hasil="Obesitas";
                        ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                    }
                    ket+="Tinggi ideal balita anda adalah 68-80 cm";
                }else{
                    if(usia>=12&&usia<24){
                        if(beratBadan>=9&&beratBadan<=15){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<9){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>15){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 80-93 cm";

                    }else if(usia>=24&&usia<36){
                        if(beratBadan>=11&&beratBadan<=18){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<11){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>18){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 87-102 cm";

                    }else if(usia>=36&&usia<48){
                        if(beratBadan>=12&&beratBadan<=22){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<12){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>22){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 94-110 cm";
                    }else{
                        if(beratBadan>=14&&beratBadan<=25){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<14){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>25){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 100-120 cm";
                    }

                }

            } else{
                if(usia<12){
                    if(beratBadan==bbi){
                        hasil="Ideal";
                        ket = "Sebaiknya dipertahankan berat badannya. ";
                    }else if(beratBadan<bbi){
                        hasil="Under Weight/Kurus";
                        ket = "Sebaiknya mulai menambah berat badan. ";
                    }else{
                        hasil="Obesitas";
                        ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                    }
                }else{
                    if(usia>=12&&usia<24){
                        if(beratBadan>=9&&beratBadan<=15){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<9){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>15){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 71-80 cm";

                    }else if(usia>=24&&usia<36){
                        if(beratBadan>=11&&beratBadan<=18){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<11){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>18){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 82-94 cm";

                    }else if(usia>=36&&usia<48){
                        if(beratBadan>=12&&beratBadan<=22){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<12){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>22){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 88-104 cm";
                    }else{
                        if(beratBadan>=14&&beratBadan<=25){
                            hasil="Ideal";
                            ket = "Sebaiknya dipertahankan berat badannya. ";
                        }else if(beratBadan<14){
                            hasil="Under Weight/Kurus";
                            ket = "Sebaiknya mulai menambah berat badan. ";
                        }else if(beratBadan>25){
                            hasil="Obesitas";
                            ket = "Sebaiknya segera membuat program menurunkan berat badan karena tidak baik bagi kesehatan";
                        }
                        ket+="Tinggi ideal balita anda adalah 100-120 cm";
                    }

                }
            }

            Intent intent = new Intent(HitungActivity.this,HasilActivity.class);
            intent.putExtra("EXTRA_NAMA", nama);
            intent.putExtra("EXTRA_BB",beratBadan);
            intent.putExtra("EXTRA_TB",tinggiBadan);
            intent.putExtra("EXTRA_JK",jeniskelamin);
            intent.putExtra("EXTRA_BMI",bbi);
            intent.putExtra("EXTRA_HASIL",hasil);
            intent.putExtra("EXTRA_KET",ket);
            startActivity(intent);
            Log.d("jeniskelamin",jeniskelamin);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_btn_lk:
                if (checked)
                    jeniskelamin = radioButtonL.getText().toString().trim();
                    break;
            case R.id.radio_btn_p:
                if (checked)
                    // Ninjas rule
                    jeniskelamin = radioButtonP.getText().toString().trim();
                    break;
        }
    }
}
