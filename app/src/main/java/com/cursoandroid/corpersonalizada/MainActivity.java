package com.cursoandroid.corpersonalizada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    private RadioGroup radioGroup;
    private RadioButton radioButton; //selected radio button
    private int idRadio;
    private Button btnSalvar;

    private static final String ARQUIVO_PRERENCIA = "ArqPreferencia";

    private String corEscolhida;

    private static final String MEU_AZUL = "#FF2196F3";
    private static final String MEU_LARANJA = "#FFFF5722";
    private static final String MEU_VERDE = "#FF009688";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        radioGroup = findViewById(R.id.radioGroup);

        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idRadio = radioGroup.getCheckedRadioButtonId();
                if (idRadio > 0){
                    radioButton = findViewById(idRadio);

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PRERENCIA, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    corEscolhida = radioButton.getText().toString();

                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();
                    setBackground(corEscolhida);

                }
                else {
                    Toast.makeText(MainActivity.this, R.string.erro, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setBackground(String cor) {
        switch (cor){
            case "Azul":
                layout.setBackgroundColor(Color.parseColor(MEU_AZUL));
                break;
            case "Laranja":
                layout.setBackgroundColor(Color.parseColor(MEU_LARANJA));
                break;
            case "Verde":
                layout.setBackgroundColor(Color.parseColor(MEU_VERDE));
                break;
        }
    }
}
