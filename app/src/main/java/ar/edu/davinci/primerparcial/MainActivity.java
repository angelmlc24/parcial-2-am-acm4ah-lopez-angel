package ar.edu.davinci.primerparcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {
    private Typeface script;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Bienvenido = findViewById(R.id.textView);
        TextView Elite_Runners = findViewById(R.id.textView2);
        TextView redes_sociales = findViewById(R.id.textView3);
        TextView slogan = findViewById(R.id.textView4);

        String fuentes = "fuentes/CollegeSans.ttf";
        this.script = Typeface.createFromAsset(getAssets(), fuentes);

        Bienvenido.setTypeface(script);
        Elite_Runners.setTypeface(script);
        redes_sociales.setTypeface(script);
        slogan.setTypeface(script);

        Button button = findViewById(R.id.button);
        Button boton_registro = findViewById(R.id.button2);

        button.setOnClickListener(v -> {
            // Código para iniciar la actividad de inicio de sesión
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });

        boton_registro.setOnClickListener(v -> {
            // Código para iniciar la actividad de registro
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(intent);
        });
    }
}
