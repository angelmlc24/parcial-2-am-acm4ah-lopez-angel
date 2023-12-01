package ar.edu.davinci.primerparcial;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {
    private Typeface script;
    private UsuarioManager usuarioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        TextView registro = findViewById(R.id.textViewTitleRegistro);

        String fuentes = "fuentes/CollegeSans.ttf";
        this.script = Typeface.createFromAsset(getAssets(), fuentes);

        registro.setTypeface(script);

        EditText editTextNewUsername = findViewById(R.id.editTextNewUsername);
        EditText editTextNewPassword = findViewById(R.id.editTextNewPassword);
        Button buttonRegister = findViewById(R.id.buttonRegister);
        Button buttonBack = findViewById(R.id.buttonBackToMain);
        usuarioManager = new UsuarioManager();

        buttonRegister.setOnClickListener(v -> {
            List<Usuario> userList = usuarioManager.getUserList();
            String newUsername = editTextNewUsername.getText().toString();
            String newPassword = editTextNewPassword.getText().toString();

            if (newUsername.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(RegistroActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            } else if (!isValidRegistration(userList, newUsername)) {
                Toast.makeText(RegistroActivity.this, "El nombre de usuario ya está en uso", Toast.LENGTH_SHORT).show();
            } else {
                Usuario nuevoUsuario = new Usuario(newUsername, newPassword);
                usuarioManager.agregarUsuario(nuevoUsuario);
                Toast.makeText(RegistroActivity.this, "¡Usuario registrado con éxito!", Toast.LENGTH_SHORT).show();

            }
        });

        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private boolean isValidRegistration(List<Usuario> userList, String newUsername) {
        for (Usuario user : userList) {
            if (user.getNombreUsuario().equals(newUsername)) {
                return false;
            }
        }
        return true;
    }
}
