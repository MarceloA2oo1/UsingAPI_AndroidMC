package com.example.usingapi_androidmc.VistasMC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.usingapi_androidmc.ModeloMC.NotasMC;
import com.example.usingapi_androidmc.UtilsMC.APIsMC;
import com.example.usingapi_androidmc.UtilsMC.NotasServiceMC;
import com.example.usingapi_androidmc.databinding.ActivityNotaMcactivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotaMCActivity extends AppCompatActivity {

    private ActivityNotaMcactivityBinding binding;
    NotasServiceMC serviceMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotaMcactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();
        final String id = bundle.getString("ID");
        String titulo = bundle.getString("TITULO");
        String descrip = bundle.getString("DESCRIPCION");
        String fecha = bundle.getString("FECHA");
        String usuario = bundle.getString("USUARIO");

        binding.edtId.setText(id);
        binding.edtTitulo.setText(titulo);
        binding.edtDescripcion.setText(descrip);
        binding.edtFecha.setText(fecha);
        binding.edtUsuario.setText(usuario);

        //se validad si el campo manda vacio, significa que lo que se desea aser es agregar lo cual
        //la id es autoimcrental
        if (id.trim().length() == 0 || id.equals("")){
            binding.Id.setVisibility(View.INVISIBLE);
            binding.edtId.setVisibility(View.INVISIBLE);
        }

        //guardar los datos actualizados
        binding.btnSave.setOnClickListener(view -> {
            NotasMC notasMC = new NotasMC();
            notasMC.setTitulo(binding.edtTitulo.getText().toString());
            notasMC.setDescripcion(binding.edtDescripcion.getText().toString());
            notasMC.setFecha(binding.edtFecha.getText().toString());
            notasMC.setUsuario(binding.edtUsuario.getText().toString());
            if (id.trim().length() == 0 || id.equals("")){
                addNotasMC(notasMC);
                Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                startActivity(intent);
            } else {
                updateNotasMC(notasMC, Integer.valueOf(id));
                Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                startActivity(intent);
            }
        });

        binding.btnEliminar.setOnClickListener(view -> {
            deleteNotasMC(Integer.valueOf(id));
            Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
            startActivity(intent);
        });

    }

    private void updateNotasMC(NotasMC notasMC, int id) {
        serviceMC = APIsMC.getNotasServiceMC();
        Call<NotasMC>call = serviceMC.updateNotasMC(notasMC, id);
        call.enqueue(new Callback<NotasMC>() {
            @Override
            public void onResponse(Call<NotasMC> call, Response<NotasMC> response) {
                if (response.isSuccessful()){
                    Toast.makeText(NotaMCActivity.this, "Actualizado excitosamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<NotasMC> call, Throwable t) {
                Log.e("Error:", t.getMessage());
                Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addNotasMC(NotasMC notaMC){
        serviceMC = APIsMC.getNotasServiceMC();
        Call<NotasMC>call = serviceMC.addNotasMC(notaMC);
        call.enqueue(new Callback<NotasMC>() {
            @Override
            public void onResponse(Call<NotasMC> call, Response<NotasMC> response) {
                if (response.isSuccessful()){
                    Toast.makeText(NotaMCActivity.this, "Agregado sactifactoriamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<NotasMC> call, Throwable t) {
                Log.e("Error:", t.getMessage());
                Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                startActivity(intent);
            }
        });

    }

    public void deleteNotasMC(int id){
        serviceMC = APIsMC.getNotasServiceMC();
        Call<NotasMC>call = serviceMC.deleteNotasMC(id);
        call.enqueue(new Callback<NotasMC>() {
            @Override
            public void onResponse(Call<NotasMC> call, Response<NotasMC> response) {
                if (response.isSuccessful()){
                    Toast.makeText(NotaMCActivity.this, "Se ha Eliminado excitosamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<NotasMC> call, Throwable t) {
                Log.e("Error:", t.getMessage());
                Intent intent = new Intent(NotaMCActivity.this, MainMCActivity.class);
                startActivity(intent);
            }
        });

    }
}