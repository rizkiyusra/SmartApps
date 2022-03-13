package com.example.smartapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RS extends ListActivity{
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listRs = new String[] {"Rumah Sakit Awal Bros", "Eka Hospital", "Rumah Sakit Jiwa Tampan", "Rumah Sakit Tabrani"};
        this.setListAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,listRs));
    }

    protected  void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanPilihan(pilihan);
    }

    private void tampilkanPilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Rumah Sakit Awal Bros")){
                a = new Intent(this,RSAwalBros.class);
            }
            else if (pilihan.equals("Eka Hospital")) {
                a = new Intent(this,RSEkaHospital.class);
            }
            else if (pilihan.equals("Rumah Sakit Jiwa Tampan")) {
                a = new Intent(this,RSJTampan.class);
            }
            else if (pilihan.equals("Rumah Sakit Tabrani")){
                a = new Intent(this,RSTabrani.class);
            }
            startActivity(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
