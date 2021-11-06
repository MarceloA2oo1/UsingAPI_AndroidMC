package com.example.usingapi_androidmc.UtilsMC;

import com.example.usingapi_androidmc.ModeloMC.NotasMC;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NotasServiceMC {

    @GET("listar")
    Call<List<NotasMC>> getNotasMC();
}
