package com.labos.labo3agenda;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText correo;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=findViewById(R.id.editNom);
        correo=findViewById(R.id.editMail);
        boton=findViewById(R.id.buttonid);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact(nombre.getText().toString(), correo.getText().toString());
            }
        });

    }

    public void addContact(String nombre, String correo){
        Intent intent=new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, nombre);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, correo);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

}
