package com.example.loginleaf;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    Button _btnLogin;
    EditText _txtUsuario, _txtPassword;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        _btnLogin = (Button) findViewById(R.id.btnLogin);
        _txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        _txtPassword = (EditText) findViewById(R.id.txtPassword);

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = _txtUsuario.getText().toString();
                String password = _txtPassword.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_2 + " =? AND " + DatabaseHelper.COL_3 + " =? ", new  String[]{usuario, password});

                if (cursor != null){
                    if (cursor.getCount() > 0){
                        cursor.moveToNext();
                        //Toast.makeText(getApplicationContext(), "Bienvenido!", Toast.LENGTH_LONG).show();
                        Intent login = new Intent(Login.this, ContenidoLeaf.class);
                        startActivity(login);
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario o Contraseña no identificados, por favor ingrese datos correctos", Toast.LENGTH_LONG).show();;
                    }
                }

            }

        });

    }

    public void Siguiente (View view){
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }
}
