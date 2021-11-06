package com.example.usingapi_androidmc.VistasMC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.example.usingapi_androidmc.AdapterMC.NotasAdapterMC;
import com.example.usingapi_androidmc.ModeloMC.NotasMC;
import com.example.usingapi_androidmc.R;
import com.example.usingapi_androidmc.UtilsMC.APIsMC;
import com.example.usingapi_androidmc.UtilsMC.NotasServiceMC;
import com.example.usingapi_androidmc.databinding.ActivityMainMcactivityBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainMCActivity extends AppCompatActivity {

    private ActivityMainMcactivityBinding binding;
    Toolbar toolbar;
    NotasServiceMC notasServiceMC;
    List<NotasMC> listNotasMC = new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMcactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView = binding.lstListView;
        ListarNotasMC();

       // toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(view -> Snackbar.make(view, "Replase witch your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    public void ListarNotasMC(){
        notasServiceMC = APIsMC.getNotasServiceMC();

        Call<List<NotasMC>> call = notasServiceMC.getNotasMC();
        call.enqueue(new Callback<List<NotasMC>>() {
            @Override
            public void onResponse(Call<List<NotasMC>> call, Response<List<NotasMC>> response) {
                listNotasMC=response.body();
                listView.setAdapter(new NotasAdapterMC(MainMCActivity.this, R.layout.activity_main_mcactivity, listNotasMC));
            }

            @Override
            public void onFailure(Call<List<NotasMC>> call, Throwable t) {
                Log.e("Error: ", t.getMessage());
            }
        });

    }
    /*
    public boolean aCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MrnuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
     */

}