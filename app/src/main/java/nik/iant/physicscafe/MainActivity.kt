package nik.iant.physicscafe

import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {
    private var rcView:RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            var debugger = ndebug()
            rcView = findViewById(R.id.recyclerChap)
            var lmm = LinearLayoutManager(this)
            lmm.orientation = LinearLayoutManager.VERTICAL
            rcView?.layoutManager =lmm
            val myData = ndata(assets.open("questions.json")).getChapters()

            //var clist = arrayOf("Chapter1","Chapter2")
            rcView?.adapter = ChapterAdapter(this, myData)
            //debugger.alert(this , myData.last())
        }catch (ex: Exception)
        {
            Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
        }
    }
    private fun checkPermission():Boolean{
        var p1= ContextCompat.checkSelfPermission(
            applicationContext,
            "android.permission.WRITE_EXTERNAL_STORAGE"
        )
        var p2= ContextCompat.checkSelfPermission(
            applicationContext,
            "android.permission.READ_EXTERNAL_STORAGEE"
        )
        return p1 == PackageManager.PERMISSION_GRANTED && p2 == PackageManager.PERMISSION_GRANTED
    }
    private fun requestPermission(){
        //ActivityCompat.requestPermissions(this, arrayOf("",""), PERMISSION_REQUEST_CODE)
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == PackageManager.PERMISSION_GRANTED) {
            if (grantResults.size > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                val writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED
                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Permission Denined.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

}