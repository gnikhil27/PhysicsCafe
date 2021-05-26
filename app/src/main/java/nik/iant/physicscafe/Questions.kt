package nik.iant.physicscafe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.Exception
import kotlin.collections.ArrayList

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        try {


            val rcView = findViewById<RecyclerView>(R.id.recyclerQue)
            val lmm = LinearLayoutManager(this)
            lmm.orientation = LinearLayoutManager.VERTICAL
            val myData = ndata(assets.open("questions.json")).getQuestions(intent.data.toString())
            val questionList = ArrayList<QuestionData>()
            for (i in 0 until myData.length()) {
                val io = myData.getJSONObject(i)
                questionList.add(
                    QuestionData(
                        1,
                        io.getString("Question"),
                        QuestionData.QuestionType.NULL,
                        io.getString("Marks").toFloat()
                    )
                )
            }
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N && Objects.isNull(
                    rcView
                )
            ) return
            rcView.layoutManager = lmm
            val dataAdapter= QuestionAdapter(this,questionList.toTypedArray())
            rcView.adapter = dataAdapter
            val submit = findViewById<Button>(R.id.btnDone)

            submit.setOnClickListener {
                var myHtmlData = ndata(assets.open("theme1.html")).getHTML
                myHtmlData+="<ol>"
                for(i in dataAdapter.selQuestion){
                    myHtmlData+="<li>"+i.strQuestion+"</li>"
                }
                myHtmlData+="</ol></body></html>"
//                var intent = Intent(this, htmlViewer::class.java)
                var intent = Intent(this, Options::class.java)
    //            intent.data = Uri.parse(myHtmlData)
                startActivity(intent)
            }
        }catch (ex:Exception)
        {
            ndebug().alert(this, ex.message!!, "Error:")
        }
    }
}