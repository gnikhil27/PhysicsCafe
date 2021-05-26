package nik.iant.physicscafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class htmlViewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html_viewer)
        val qp = findViewById<WebView>(R.id.questionPaper)
        qp.loadData(intent.data.toString(),"text/html","UTF-8")

    }
}