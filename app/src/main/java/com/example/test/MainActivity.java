package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText entree;
    RadioGroup groupConvertion;
    Button convertir;
    TextView sortie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entree=(EditText) findViewById(R.id.edtxtMonnaie);
        groupConvertion=(RadioGroup) findViewById(R.id.groupdBtn);
        convertir=(Button) findViewById(R.id.btnConvert);
        sortie=(TextView) findViewById(R.id.textResult);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (entree.getText().toString().equals("")) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setMessage("vous devez saisir une valeur");
                    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
                    alertDialog.show();
                } else {
                    float valeurInit = 0.0F, res;
                    valeurInit = Float.valueOf(entree.getText().toString());
                    if
                    (groupConvertion.getCheckedRadioButtonId() == R.id.DBtnEurdin) {
                        res = EuroToDinar(valeurInit);
                    } else {
                        res = DinarToEuro(valeurInit);
                    }
                    sortie.setText(String.valueOf(res));
                }
            }

        });}
    public Float DinarToEuro (float vDinar)
    {
        return (float)(vDinar*0.316);
    }
    public Float EuroToDinar (float vEuro)
    {
        return (float)(vEuro/0.316);
    }


}
