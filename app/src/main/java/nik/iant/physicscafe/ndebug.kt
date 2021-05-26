package nik.iant.physicscafe

import android.app.AlertDialog
import android.content.Context

class ndebug {
    public fun alert(context: Context, message: String, title: String = ""){
        var builder = AlertDialog.Builder(context)
        builder.setMessage(message)
        builder.setTitle(title)
        var dialog = builder.create()
        dialog.show()
    }

}
