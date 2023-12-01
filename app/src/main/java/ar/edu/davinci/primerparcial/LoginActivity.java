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

public class LoginActivity extends AppCompatActivity {

    private Typeface script;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView Bienvenido = findViewById(R.id.textView);

        String fuentes = "fuentes/CollegeSans.ttf";
        this.script = Typeface.createFromAsset(getAssets(), fuentes);

        Bienvenido.setTypeface(script);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonRegistro = findViewById(R.id.buttonRegistro);

        buttonLogin.setOnClickListener(v -> {
            List<Usuario> userList = UsuarioManager.getUserList();
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            if (isValidCredentials(userList, username, password)) {
                Toast.makeText(LoginActivity.this, "¡Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();
                // Redireccionar a la actividad de Inicio
                Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(intent);
        });
    }
    private boolean isValidCredentials(List<Usuario> userList, String username, String password) {
        for (Usuario user : userList) {
            if (user.getNombreUsuario().equals(username) && user.getContraseña().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
