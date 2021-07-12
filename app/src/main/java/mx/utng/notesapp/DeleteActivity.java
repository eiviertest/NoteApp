package mx.utng.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.wear.widget.CircularProgressLayout;
import android.os.Bundle;

public class DeleteActivity extends AppCompatActivity implements CircularProgressLayout.OnTimerFinishedListener {

    CircularProgressLayout circularProgressLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        circularProgressLayout = (CircularProgressLayout) findViewById(R.id.delayed_confirm);
        circularProgressLayout.setOnTimerFinishedListener(this);
        circularProgressLayout.setTotalTime(3000);
        circularProgressLayout.startTimer();
    }

    @Override
    public void onTimerFinished(CircularProgressLayout layout) {
        Helper.displayConfirmation("Eliminado", this);
        String id = getIntent().getStringExtra("id");
        Helper.eliminarNota(id, this);
        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Helper.displayConfirmation("Cancelado", this);
        finish();
    }
}