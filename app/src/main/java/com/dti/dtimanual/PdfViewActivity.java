package com.dti.dtimanual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewActivity extends AppCompatActivity {

    PDFView pdfView;
    TextView chapterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        pdfView = findViewById(R.id.pdfView);
        chapterName = findViewById(R.id.insideName);

        int position = getIntent().getIntExtra("position", 0);
        String chapter = getIntent().getStringExtra("name");

        if (position==0){

            pdfView.fromAsset("DTI_Book.pdf").load();
            chapterName.setText(chapter);

        }
    }
}