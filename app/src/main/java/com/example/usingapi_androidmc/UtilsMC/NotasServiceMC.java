package com.example.usingapi_androidmc.UtilsMC;

import com.example.usingapi_androidmc.ModeloMC.NotasMC;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NotasServiceMC {

    @GET("listar")
    Call<List<NotasMC>> getNotasMC();

    @POST("agregar")
    Call<NotasMC>addNotasMC(@Body NotasMC notas);

    @POST("actualizar/{id}")
    Call<NotasMC>updateNotasMC(@Body NotasMC notas, @Path("id") int id);

    @POST("eliminar/{id}")
    Call<NotasMC>deleteNotasMC(@Path("id") int id);
}
