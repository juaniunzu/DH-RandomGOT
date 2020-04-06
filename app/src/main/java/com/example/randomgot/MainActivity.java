package com.example.randomgot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private TextView nombre;
    private Button botonDescubrir;
    private List<Personaje> listaDePersonajes;

    public Integer randomizador(){
        Random random = new Random();
        Integer randomNumber = random.nextInt(this.listaDePersonajes.size());
        return randomNumber;
    }

    public Personaje buscarPersonajePorIndice(Integer indice){
        return this.listaDePersonajes.get(indice);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imagen = findViewById(R.id.imageView);
        this.nombre = findViewById(R.id.textViewNombre);
        this.botonDescubrir = findViewById(R.id.buttonDescubrir);
        this.listaDePersonajes = new ArrayList<>();

        //creo los personajes, como parametros uso los nombres y los ID que salen de buscarlos en la carpeta res
        Personaje cersei = new Personaje("Cersei", R.drawable.cersei);
        Personaje daenerys = new Personaje("Daenerys", R.drawable.daenerys);
        Personaje jonSnow = new Personaje("Jon Snow", R.drawable.jonsnow);
        Personaje nightKing = new Personaje("Night King", R.drawable.nightking);
        Personaje tyrion = new Personaje("Tyrion", R.drawable.tyrion);

        this.listaDePersonajes.add(cersei);
        this.listaDePersonajes.add(daenerys);
        this.listaDePersonajes.add(jonSnow);
        this.listaDePersonajes.add(nightKing);
        this.listaDePersonajes.add(tyrion);

        botonDescubrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creo un personaje random
                Personaje personajeAMostrar = MainActivity.this.listaDePersonajes.get(randomizador());

                //tomo su nombre y su ruta de archivo de imagen
                String nombre = personajeAMostrar.getNombre();
                Integer idImagen = personajeAMostrar.getId();

                //agrego el nombre al textView nombre
                MainActivity.this.nombre.setText(nombre);

                //agrego la ruta al imageView imagen
                MainActivity.this.imagen.setImageResource(idImagen);
            }
        });





    }
}
