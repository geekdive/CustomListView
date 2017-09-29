package id.co.decoded.moeslim.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class detailActivity extends AppCompatActivity {

    //Step 11 - Mendeklarasikan TextView
    TextView titleapps;
    TextView subapps;
    ImageView pictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titleapps = (TextView)findViewById(R.id.titleApps);
        subapps = (TextView)findViewById(R.id.subApps);
        pictures = (ImageView) findViewById(R.id.imgData);

        //Step 12 - membuat getIntent untuk menampung data kiriman dari acivity sebelumnya
//        Intent adpTampung = getIntent();
//
//        //Step 13 - Simpan ke string untuk ditampung sementara
//        String tampungSementara = adpTampung.getStringExtra("BROWSER");
//        tvTampilkanBrowser.setText(tampungSementara);
//        System.out.println("data yang diterima adalah " + tampungSementara);
//
            Bundle tampungBundle = getIntent().getExtras();
//            tvTampilkanBrowser.setText(tampungBundle.getString("tit"));
//            tvSubtitle.setText(tampungBundle.getString("sub"));

        String htmlText = " %s ";
        String myData = "<html><body style=\"text-align:justify\">Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView.</body></Html>";
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");



        String title = tampungBundle.getString("tit");
        String sub = tampungBundle.getString("sub");
        Integer pic = tampungBundle.getInt("picarea");

        titleapps.setText(title);
        subapps.setText(sub);
        pictures.setImageResource(pic);


        System.out.println("data yang diterima adalah " + title + " dengan deskripsi " + sub + " dengan gambar " + pic);


    }
}
