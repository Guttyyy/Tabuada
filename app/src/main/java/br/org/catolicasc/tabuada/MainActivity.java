package br.org.catolicasc.tabuada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final Object Toast = "";
    private EditText etNumero;
    private ListView lvTabuada;
    private Button btnMostrar;


    //Criar list_item na pasta do layout, com valor para root de TextView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);       //Declara a EditText pelo id dele
        lvTabuada = findViewById(R.id.lvTabuada);     //Declara o ListView pelo id
        btnMostrar = findViewById(R.id.btnMostrar);   //Declara o botão

        //Quando clica no botão ira fazer as operações abaixo
         btnMostrar.setOnClickListener(new View.OnClickListener() {   //Cria o listener para o botão
            @Override
            public void onClick(View v) {
                int numero = Integer.valueOf(etNumero.getText().toString());   //Pega o numero e converte para inteiro


                List<Integer> tabuada = new ArrayList<>(); //Cria a tabuada //Array preenchido com a tabuada
                for (int i = 1; i <= 10; i++) {
                    tabuada.add(i * numero);  //valores que vão ser mostrados
                }

                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>( //Vai atualizar o listView toda vez que o array atualizar
                        MainActivity.this, R.layout.list_item, tabuada // São passadas 3 normas
                );
                lvTabuada.setAdapter(arrayAdapter);   //Coloca na listView, vai mostrar os valores na lista
            }
        });

    }
}

