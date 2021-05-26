package nik.iant.physicscafe

import org.json.JSONObject
import java.io.InputStream
import android.content.res.AssetManager
import androidx.core.content.ContextCompat
import org.json.JSONArray
import java.nio.charset.Charset

class ndata(fileStream:InputStream)
{
    private var fileAsset:InputStream? = null
    private var fileSize:Int? = null
    private var fileData:ByteArray? = null
    private val fileDataString:String get() = fileData!!.toString(Charsets.UTF_8)
    val getHTML:String get() = fileDataString
    init {
        fileAsset = fileStream
        fileSize = fileStream.available()
        fileData = ByteArray(fileSize!!)
        fileAsset?.read(fileData)
        fileAsset?.close()
    }
    fun getChapters():Array<String>{
        var jsdata = JSONObject(fileDataString)
        var myList = ArrayList<String>()
        jsdata.keys().forEach { chapter -> myList.add(chapter) }
        return myList.toTypedArray()
    }
    fun getQuestions(key:String): JSONArray {
        var jsdata = JSONObject(fileDataString)
        return jsdata.getJSONArray(key)
    }
}
