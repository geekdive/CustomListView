package id.co.decoded.moeslim.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by moeslim on 13/09/17.
 */

//Step 4 - Extend terlebih dahulu class dari CustomListAdapter dengan menambahkan
//extends ArrayAdapter<String> <---- yang ini ke
//public class CustomListAdapter (sini) extends ArrayAdapter<String>

public class CustomListAdapter extends ArrayAdapter<String> {
    //Istirahat 11:54
    //Mulai 13:09

    //Step 5 - Membuat public CustomAdapter untuk nantinya diakses di mainActivity.java
    //Sebagai listen

    //Step 6 - Membuat variable untuk string browser terkenal, dan gambar untuk icon browser
    private final Activity contex;
    //Jika terjadi error atau ada garis di bawah kamu Alt + Enter, pilih Add constructor parameter
    //dan secara otomatis akan menambahkan dalam bidang method public dibawah yang
    //sudah kita buat
    private final String[] kategoriBrowserTerkenal;
    //sama ketika menambahkan variable untuk String array browser terkenal tekan
    //Alt + Enter pilih Add constructor parameter
    private final Integer[] picBrowserTerkenal;
    //sama ketika menambahkan variable untuk Integer array picture atau icon browser terkenal tekan
    //Alt + Enter pilih Add constructor parameter

    //tambahkan final private String untuk subtitle
    private final String[] subkategori;


    public CustomListAdapter(Activity contex, String[] kategoriBrowserTerkenal, Integer[] picBrowserTerkenal, String[] subkategori){
        //Step 7 - Membuat custom untuk inflate activity dari activity sementara dan di inflate kemudian
        //data tampil
        super(contex, R.layout.list_item, kategoriBrowserTerkenal);
        //Step 8 - Membuat Layout untuk list_item.xml untuk penginflate dan menampilkan data
        //Cara pertama: Alt + Enter pada bagian merah list_item diatas kemudian pilih
        //create layout resource file "list_item.xml"

        this.contex = contex;
        this.kategoriBrowserTerkenal = kategoriBrowserTerkenal;
        this.picBrowserTerkenal = picBrowserTerkenal;
        this.subkategori = subkategori;
    }

    public View getView(int posisi, View view, ViewGroup parent){
        LayoutInflater inflater = contex.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView title = (TextView)rowView.findViewById(R.id.titleBrowser);
        TextView subtitle = (TextView)rowView.findViewById(R.id.subtittleBrowser);
        ImageView pictures = (ImageView)rowView.findViewById(R.id.browserTerkenal);

        title.setText(kategoriBrowserTerkenal[posisi]);
        subtitle.setText(subkategori[posisi]);
        pictures.setImageResource(picBrowserTerkenal[posisi]);

        return rowView;
    }
}
