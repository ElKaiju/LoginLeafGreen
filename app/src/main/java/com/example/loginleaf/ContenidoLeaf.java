package com.example.loginleaf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContenidoLeaf extends AppCompatActivity {

    Button _btnPlantas, _btnConfiguracion, _btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido_leaf);
    }

    public void logout (View view){
        Intent logout = new Intent(this, Login.class);
        startActivity(logout);
        Toast.makeText(getApplicationContext(), "Gracias por usar LeafGreen", Toast.LENGTH_LONG).show();
    }

}
