package com.project.juke.showhidepassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

public class MainActivity extends AppCompatActivity {
    // Deklarasikan widget yang ada di layout activity_main.xml
    EditText EdEmail, EdUsername, EdPassword;
    AwesomeText ImgShowHidePassword;
    Button BtnLihatStatus, BtnHapus;
    TextView TxtTampilkanEmail, TxtTampilkanUsername;

    boolean pwd_status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // kenalkan widget yang telah di deklarasikan

        /*Widget EditText*/
        EdEmail = (EditText) findViewById(R.id.EdEmail);
        EdUsername = (EditText) findViewById(R.id.EdUsername);
        EdPassword = (EditText) findViewById(R.id.EdPassword);

        /*Widdget Button*/
        BtnLihatStatus = (Button) findViewById(R.id.BtnCekStatus);
        BtnHapus = (Button) findViewById(R.id.BtnClear);

        /*Widget TextView*/
        TxtTampilkanEmail = (TextView) findViewById(R.id.TxtTampilkanEmail);
        TxtTampilkanUsername = (TextView) findViewById(R.id.TxtTampilkanUsername);

        // widget show hide password
        ImgShowHidePassword = (AwesomeText)findViewById(R.id.ImgShowPassword);

        // lalu kita beri action agar show hide password nya bisa berfungsi
        ImgShowHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwd_status) {
                    EdPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status = false;
                    ImgShowHidePassword.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    EdPassword.setSelection(EdPassword.length());
                } else {
                    EdPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status = true;
                    ImgShowHidePassword.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    EdPassword.setSelection(EdPassword.length());
                }
            }
        });

        BtnLihatStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mengambil value yang ada di EditText dan akan kita tampilkan di text view
                String Email = (String) EdEmail.getText().toString();
                String Username = (String) EdUsername.getText().toString();
                String Password = (String) EdPassword.getText().toString();
                boolean valid = true;

                // code untuk editext tidak boleh kosong
                if (TextUtils.isEmpty(Email)) {
                    EdEmail.setError("Harus Diisi... Tidak Boleh Kosong!!!");
                    EdEmail.requestFocus();
                } else if (TextUtils.isEmpty(Username)) {
                    EdUsername.setError("Harus Diisi...Tidak Boleh Kosong!!!");
                    EdUsername.requestFocus();
                } else if (TextUtils.isEmpty(Password)) {
                    EdPassword.setError("Harus Diisi... Tidak Boleh Kosong!!!");
                    EdPassword.requestFocus();
                }

                // Kita tampilkan text yang sudah kita isi di editext, dan akan tampil pada editext
                TxtTampilkanEmail.setText("Email\t: " + Email);
                TxtTampilkanUsername.setText("Username\t: " + Username);

                Email = TxtTampilkanEmail.getText().toString();
                Username = TxtTampilkanUsername.getText().toString();

                // Lalu kita tampilkan pesan mealui Toast
                Toast.makeText(MainActivity.this, Username, Toast.LENGTH_SHORT).show();

            }
        });

        // Action untuk menghapus isi text yang ada pada edit text
        BtnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EdEmail.getText().clear();
                EdUsername.getText().clear();
                EdPassword.getText().clear();
            }
        });
    }
}