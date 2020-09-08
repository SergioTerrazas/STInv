package com.example.stinv.Actividades;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stinv.MainActivity;
import com.example.stinv.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class AltaArticuloActivity extends AppCompatActivity {

    private ImageButton btnCodigoBarra;
    private EditText tvwCodigoArticulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_articulo);

        btnCodigoBarra = findViewById(R.id.btnCodigoBarra);
        tvwCodigoArticulo = findViewById(R.id.editCodigoArticulo);

        btnCodigoBarra.setOnClickListener(mOnclickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult!=null){
            if(intentResult.getContents() !=null){
                tvwCodigoArticulo.setText(""+intentResult.getContents());
            }else{
                tvwCodigoArticulo.setText("Error al escanear elcodigo de barras");
            }
        }
    }

    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnCodigoBarra:
                    new IntentIntegrator(AltaArticuloActivity.this).initiateScan();
                break;
            }
        }
    };
}