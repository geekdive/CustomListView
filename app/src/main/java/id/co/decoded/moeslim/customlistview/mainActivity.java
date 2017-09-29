package id.co.decoded.moeslim.customlistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class mainActivity extends AppCompatActivity {

    //Step 1 - Membuat Array data untuk Browser terkenal
    String[] kategoriBrowserTerkenal = {
            "Mozilla Firefox",
            "Google Chrome",
            "Safari Web Browser",
            "Opera Mini",
            "Microsoft Edge",
            "Internet Exploler",
            "Browser Android",
            "Browser Windows",
            "Browser Linux",
            "Apple Browser"
    };

    String[] subKategori = {

            //Coppas orang developer AS CTRL + D
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
            "Deskripsi Browser",
    };

    //Step 2 - Cari icon atau gambar dari browser terkenal tersebut
    //Jika sudah dimasukan ke dalam folder drawable kita buat Array baru dengan tipe data integer

    //Alasan kenapa kita harus menggunakan typedata integer untuk mengambil gambar
    //Awal gambar berekstensi png atau yang lainnya
    //untuk dapat mengambil data tersebut dan ditampilkan kedalam program kita ambil urutannya saja
    //dan dari urutan tersebut dimulai dari paling atas mulai dari 0 - sekian

    Integer[] picBrowserTerkenal = {
            R.drawable.mozilla,
            R.drawable.chrome,
            R.drawable.safari,
            R.drawable.opera,
            R.drawable.edge,
            R.drawable.ie,
            R.drawable.android,
            R.drawable.windows,
            R.drawable.linux,
            R.drawable.apple

    };

    //Deklarasi ListView
    ListView list;

    //Deklarasi Alert
    AlertDialog.Builder alertDialog;
    AlertDialog alertNya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 3 - Buat Class baru dengan Klik kanan di folder Java dengan nama CustomListAdapter.java

        CustomListAdapter clAdpter = new CustomListAdapter(this, kategoriBrowserTerkenal, picBrowserTerkenal, subKategori);

        list = (ListView)findViewById(R.id.listBrowser);
        list.setAdapter(clAdpter);

        //Step 9 - Menambahkan setOnItemClick pada ListView
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int posisiPilihan, long l) {


                //Step 10 - Membuat Alert Dialog
                //Membuat Alert Dialog untuk menampilkan pesan
                System.out.println("Pilihan " + kategoriBrowserTerkenal[posisiPilihan] + " dan deskripsi " + subKategori[posisiPilihan] + " dengan ID gambar " + picBrowserTerkenal[posisiPilihan]);

                alertDialog = new AlertDialog.Builder(mainActivity.this);
                //Setting Meesage & tittle
                alertDialog
                        .setTitle("Pilihan Yang Kamu Pilih Adalah : " + kategoriBrowserTerkenal[posisiPilihan])
                        .setMessage("Browser " + kategoriBrowserTerkenal[posisiPilihan] + " adalah browser terkenal salah satunya info bisa klik buka web")

                        //SetPositif Button
                        .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Intent adpKirim = new Intent(getApplicationContext(), detailActivity.class);
//                                //Browser di coppas masukan ke getStringExtra di Activity tujuan
//                                adpKirim.putExtra("BROWSER", kategoriBrowserTerkenal[posisiPilihan]);
//                                startActivity(adpKirim);


                                String title = kategoriBrowserTerkenal[posisiPilihan];
                                String sub = subKategori[posisiPilihan];
                                Integer bitmap = picBrowserTerkenal[posisiPilihan];

//                                //Log
//                                System.out.println("data" + bitmap);

                                //Membuat Bundle
                                Bundle angkut = new Bundle();

                                angkut.putString("tit", title);
                                angkut.putString("sub", sub);
                                angkut.putInt("picarea", bitmap);

                                Intent kirim = new Intent(mainActivity.this, detailActivity.class);
                                kirim.putExtras(angkut);
                                startActivity(kirim);

                            }
                        })

                        //SetNegative Button
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //kosingin
                            }
                        });
                alertNya = alertDialog.create();
                alertNya.show();
            }
        });

    }
}
