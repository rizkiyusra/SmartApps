package com.example.smartapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSJTampan extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listAct1 = new String[] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct1));
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
            if (pilihan.equals("Call Center")){
                String nomor = "tel:0761-52525252";
                a = new Intent(Intent.ACTION_DIAL,Uri.parse(nomor));
            }
            else if (pilihan.equals("SMS Center")) {
                String sms = "Rizki Maulana Yusra H/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:085208520852"));
                a.putExtra("sms_body",sms);
            }
            else if (pilihan.equals("Driving Direction")) {
                String lokasiRs = "google.navigation:q=0.463823,101.390353";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasiRs));
            }
            else if (pilihan.equals("Website")) {
                String web = "https://rsjiwatampan.riau.go.id";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(web));
            }
            else if (pilihan.equals("Info Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Jiwa Tampan");
            }
            else if (pilihan.equals("Exit")) {

            }
            startActivity(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}