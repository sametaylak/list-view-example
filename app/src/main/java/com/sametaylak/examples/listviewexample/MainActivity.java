package com.sametaylak.examples.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listArray = new ArrayList<>(); // ListView componentimizde göstereceğimiz verileri tutacak
    ArrayAdapter<String> listAdapter; // listArray'imizi listView ile bağlamamızı sağlayacak olan adaptörümüz
    private EditText editText;
    private Button btnSave;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*

            Componentlerimizi tanımladık

         */

        editText = (EditText)findViewById(R.id.editText);
        btnSave = (Button)findViewById(R.id.btnSave);
        listView = (ListView)findViewById(R.id.listView);

        /*

            Adaptörümüzü default layout ile listArray dizimize bağladık

         */

        listAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, android.R.id.text1, listArray);

        /*

            Adaptörümüzü listView'e bağladık

         */

        listView.setAdapter(listAdapter);

        /*

            Kaydet butonunun click eventini oluşturduk
            Herhangi bir tıklamada editText'te ki veriyi alıp listArray'in içine atıyoruz
            Ve adaptöre değişiklikleri kontrol etmesini söylüyoruz

         */

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listArray.add(editText.getText().toString());
                listAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }
}
