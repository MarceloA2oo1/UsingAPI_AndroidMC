package com.example.usingapi_androidmc.AdapterMC;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.usingapi_androidmc.ModeloMC.NotasMC;
import com.example.usingapi_androidmc.R;
import com.example.usingapi_androidmc.VistasMC.NotaMCActivity;

import java.util.List;

public class NotasAdapterMC extends ArrayAdapter<NotasMC> {

    private Context context;
    private List<NotasMC> notasMC;

    public NotasAdapterMC(@NonNull Context context, int resource, @NonNull List<NotasMC> objects) {
        super(context, resource, objects);
        this.context = context;
        this.notasMC = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.content_mc,parent, false);

        TextView txtId = (TextView) rowView.findViewById(R.id.txtidNota);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtTitulo);
        TextView txtdescription = (TextView) rowView.findViewById(R.id.txtDescripcion);
        TextView txtDate = (TextView) rowView.findViewById(R.id.txtFecha);
        TextView txtUser = (TextView) rowView.findViewById(R.id.txtUsuario);

        //get rowView
        txtId.setText(String.format("ID:%s", notasMC.get(position).getId()));
        txtTitle.setText(String.format("TITULO:%s", notasMC.get(position).getTitulo()));
        txtdescription.setText(String.format("DESCRIPCION:%s", notasMC.get(position).getDescripcion()));
        txtDate.setText(String.format("FECHA:%s", notasMC.get(position).getFecha()));
        txtUser.setText(String.format("USUARIO:%s", notasMC.get(position).getUsuario()));

        //implement update
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NotaMCActivity.class);
                intent.putExtra("ID", String.valueOf(notasMC.get(position).getId()));
                intent.putExtra("TITULO", String.valueOf(notasMC.get(position).getTitulo()));
                intent.putExtra("DESCRIPCION", String.valueOf(notasMC.get(position).getDescripcion()));
                intent.putExtra("FECHA", String.valueOf(notasMC.get(position).getFecha()));
                intent.putExtra("USUARIO", String.valueOf(notasMC.get(position).getUsuario()));
                context.startActivity(intent);
            }
        });


        return rowView;
    }
}
