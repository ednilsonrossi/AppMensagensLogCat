package br.edu.ifsp.dmo.exemplologcat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private static final String TAG = "MyApp";
    private String[] opcoes = {
            "Mensagem geral (verbose)",
            "Depuração",
            "Informações",
            "Avisos",
            "Erro"};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter = new Adapter(this, opcoes);
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0:
                Log.v(TAG, "Clicou em " + opcoes[position]);
                break;
            case 1:
                Log.d(TAG, "Clicou em " + opcoes[position]);
                break;
            case 2:
                Log.i(TAG, "Clicou em " + opcoes[position]);
                break;
            case 3:
                Log.w(TAG, "Clicou em " + opcoes[position]);
                break;
            case 4:
                Log.e(TAG, "Clicou em " + opcoes[position]);
                break;
        }

        Toast.makeText(this, "A mensagem foi gravada no logcat", Toast.LENGTH_SHORT).show();
    }
}