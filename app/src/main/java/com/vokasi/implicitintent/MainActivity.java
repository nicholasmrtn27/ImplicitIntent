package com.vokasi.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editUrlWeb;
    private EditText editLocation;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrlWeb=findViewById(R.id.website_edittext);
        editLocation=findViewById(R.id.location_edittext);
        editText=findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url=editUrlWeb.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntent","Cant handle this");
        }
    }

    public void openLocation(View view) {
        String location=editLocation.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q="+location);
        Intent intent=new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntent","Cant handle this");
        }
    }

    public void shareText(View view) {
        String share=editText.getText().toString();
        ShareCompat.IntentBuilder

                .from(this)
                .setChooserTitle("Sharing ama dia atau kemana?")
                .setText(share)
                .setType("text/plain")
                .startChooser();
    }
}