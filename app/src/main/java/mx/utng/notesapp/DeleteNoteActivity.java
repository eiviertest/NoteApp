package mx.utng.notesapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import mx.utng.notesapp.databinding.ActivityDeleteNoteBinding;

public class DeleteNoteActivity extends Activity {

    private ActivityDeleteNoteBinding binding;
    Button btnCancelar;

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
            }
        });
    }
}