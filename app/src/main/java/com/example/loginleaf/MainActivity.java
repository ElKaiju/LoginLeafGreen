package com.example.loginleaf;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {

    //se llama a la base de datos y al openHelper

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    //se declaran las variables

    Button _btnRegistrar, _btnLogin;
    EditText _txtUsuario, _txtPassword, _txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new DatabaseHelper(this);

        //se crea la asociación de las variables con la ID del layout

        _btnRegistrar=(Button) findViewById(R.id.btnRegistrar);
        _txtUsuario=(EditText) findViewById(R.id.txtUsuario);
        _txtPassword=(EditText) findViewById(R.id.txtPassword);
        _txtEmail=(EditText) findViewById(R.id.txtEmail);
        _btnLogin=(Button) findViewById(R.id.btnLogin);

        //se configura el boton para que se genere la accion de registrar a un usuario

        _btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se configura la escritura de la base de datos
                db = openHelper.getWritableDatabase();
                String usuario = _txtUsuario.getText().toString();
                String password = _txtPassword.getText().toString();
                String email = _txtEmail.getText().toString();
                agregarDatos(usuario, password, email);
                //mensaje de que el registro fue exitoso
                Toast.makeText(getApplicationContext(), "Registro exitoso.",Toast.LENGTH_LONG).show();
            }
        });

        //se configura el boton de login llamando la clase Login e iniciando la actividad con esa clase

        //_btnLogin.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(MainActivity.this, Login.class);
        //        startActivity(intent);
        //    }
        // });

    }
    // se crea un objeto para escribir columna por columna en la base de datos
    public void agregarDatos (String usuario, String password, String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, usuario);
        contentValues.put(DatabaseHelper.COL_3, password);
        contentValues.put(DatabaseHelper.COL_4, email);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

}
