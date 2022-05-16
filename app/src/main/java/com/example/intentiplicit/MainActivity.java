package com.example.intentiplicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    //atributos de las vistas
    private EditText etTelefono;
    private ImageButton btnLlamar;
    private ImageButton btnCamara;
    //Atributos de tipo primitivo
    private String numeroTelefono;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnLlamar.setOnClickListener(view->{

            obtenerInformacion();
            configurarIntentImplicit();

        });
    }

    private void configurarIntentImplicit() {
        //primero validamos si el campo de texto no està vacio
        //!=negacion
        if (!numeroTelefono.isEmpty()){
            //primer problema
            //las llamadas han cambiado desde la version 6 o sdk23
            //a partir de esa versiòn se hace el codigo con algunos cambios
            //antes de esa version haba otra manera de hacer el codigo

            //VALIFAR SI LA VERSION DE TU PROYECTO ES MAYORO OIGUAL A LAVRSION DE ANDROID
            // DONDE CAMBIO LA FORMA DE PROCESAR LA LLAMADA

            //EJ:SDK_INT=24 ES LA VERSIONDE SDK VERSION_CODE.M=23
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            }//para versiones nuevas
                else{
                 //para versiones anmtiguas
                configurarVersionesAntiguas();

                }


        }

    }

    private void configurarVersionesAntiguas() {
        //CONFIGURAR EL INTENT PARA VERSIONES ANTERIORES DONDE CAMBIO EL CODIGO
        //Intent implicito->1) Que accion quiere realizar
        //2) que datos quieres enviar en el Intent
        //lA uri es como la URL e web donde configuras las cabeceras(heathers
        //tu ruta donde tienes que salr atos
        //lavve valor para telefono:
        Intent intentLlamada=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+numeroTelefono));
        startActivity(intentLlamada);
    }

    private void obtenerInformacion() {
        numeroTelefono=etTelefono.getText().toString();
    }

    private void inicializarVistas() {
        etTelefono=findViewById(R.id.etTelefono);
        btnCamara=findViewById(R.id.btnCamara);
        btnLlamar=findViewById(R.id.btnLlamar);

    }
    private boolean revisarPermisos(String permiso)
    {
        //Nadroid maneeja los permisos de esta manera, para Android GRANTED significa permso otorgado
        // Para android DENIED significa no autorizado
        //VALIDAR si el permiso a evaluar en su aplicacion tiene el valor de Android manja para u permiso otogado (GRANTED)
        return false;
        }
    /*
    APUNTES 16-05 CLASE INTENT
    IPLICIT-EXPLICIT
    EXPLICIT=indica que componentes se quiere que realice la acciòn
    para que lanse una nueva pantalla, el sistema escoje cual es la mejor alternativa para realizar la acciòn
     */
}