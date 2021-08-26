package mx.utng.notesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import mx.utng.notesapp.databinding.ActivityDeleteNoteBinding;

public class DeleteNoteActivity extends Activity {

    private ActivityDeleteNoteBinding binding;
    Button btnCancelar;
    private int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeleteNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                flag = 0;
            }
        });
        CountDownTimer cuenta = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if(flag == 1) {
                    Helper.displayConfirmation("Eliminada", DeleteNoteActivity.this);
                    String id = getIntent().getStringExtra("id");
                    Helper.eliminarNota(id, DeleteNoteActivity.this);
                    finish();
                }
            }
        }.start();
    }
}