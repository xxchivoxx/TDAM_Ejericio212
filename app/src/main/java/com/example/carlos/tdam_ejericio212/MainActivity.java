package com.example.carlos.tdam_ejericio212;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSave, btnGet;
    EditText edtNombre, edtDireccion, edtCelular, edtFecha, edtHoraIni, edtHoraFin, edtPlatillos,edtPostres;
    CheckBox chkLujo, chkBasico;
    SeekBar skbMeseros;
    TextView txtMeseros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombre = findViewById(R.id.editText);
        edtCelular =  findViewById(R.id.editText2);
        edtDireccion = findViewById(R.id.editText3);
        edtFecha = findViewById(R.id.editText4);
        edtHoraIni = findViewById(R.id.editText5);
        edtHoraFin = findViewById(R.id.editText6);
        edtPlatillos = findViewById(R.id.editText7);
        edtPostres = findViewById(R.id.editText8);
        chkBasico = findViewById(R.id.checkBox2);
        chkLujo = findViewById(R.id.checkBox3);
        skbMeseros = findViewById(R.id.seekBar2);
        txtMeseros = findViewById(R.id.textView4);

        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        skbMeseros.setProgress(0);
        skbMeseros.setMax(10);

        skbMeseros.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtMeseros.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Llamada la metodo Save()
                saveChanges();;
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Llamada al metodo Get()
                getChanges();
            }
        });
    }

    private void saveChanges(){
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("NOMBRE",edtNombre.getText().toString());
        editor.putString("CELULAR",edtCelular.getText().toString());
        editor.putString("DIRECCION",edtDireccion.getText().toString());
        editor.putString("FECHA",edtFecha.getText().toString());
        editor.putString("HORAINICIO",edtHoraIni.getText().toString());
        editor.putString("HORAFIN",edtHoraFin.getText().toString());
        editor.putString("PLATILLOS",edtPlatillos.getText().toString());
        editor.putString("POSTRES",edtPostres.getText().toString());
        editor.putBoolean("CHKLUJO",chkLujo.isChecked());
        editor.putBoolean("CHKBASICO",chkBasico.isChecked());
        editor.putInt("MESEROS",Integer.parseInt(txtMeseros.getText().toString()));
        editor.commit();
        Toast.makeText(this, "Preferences saved it", Toast.LENGTH_SHORT).show();
    }

    private void getChanges(){
        String nombre, celular, direccion, fecha, horainicio, horafin, platillos, postres;
        Boolean chkLujo;
        Boolean chkBasico;
        int meseros;
        Boolean generoM,generoF,chkCo,chkWr,chkJo;
        int signo;
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        nombre = sharedPreferences.getString("NOMBRE",null);
        celular = sharedPreferences.getString("CELULAR",null);
        direccion = sharedPreferences.getString("DIRECCION",null);
        fecha = sharedPreferences.getString("FECHA",null);
        horainicio = sharedPreferences.getString("HORAINICIO",null);
        horafin = sharedPreferences.getString("HORAFIN",null);
        platillos = sharedPreferences.getString("PLATILLOS",null);
        postres = sharedPreferences.getString("POSTRES",null);
        chkBasico = sharedPreferences.getBoolean("CHKBASICO",false);
        chkLujo = sharedPreferences.getBoolean("CHKLUJO",false);
        meseros = sharedPreferences.getInt("MESEROS",0);


        edtNombre.setText(nombre);
        edtCelular.setText(celular);
        edtDireccion.setText(direccion);
        edtFecha.setText(fecha);
        edtHoraIni.setText(horainicio);
        edtHoraFin.setText(horafin);
        edtPlatillos.setText(platillos);
        edtPostres.setText(postres);
        this.chkBasico.setChecked(chkLujo);
        this.chkLujo.setChecked(chkLujo);
        skbMeseros.setProgress(meseros);

        Toast.makeText(this, "Preferences got it", Toast.LENGTH_SHORT).show();
    }
}
