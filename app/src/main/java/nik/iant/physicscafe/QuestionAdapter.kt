package nik.iant.physicscafe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
public class QuestionData(intQ: Int, strQ:String, typQ:QuestionType, intM:Float){
    public enum class QuestionType{NULL,MCQs, ShortAnswer, LongAnswer, Diagram}

    var strQuestion =""
    var intQuestionId =0
    var typQuestion=QuestionType.NULL
    var intMarks = 0.0F
    init {
        strQuestion = strQ
        typQuestion = typQ
        intMarks = intM
        intQuestionId = intQ
    }

}
class QuestionAdapter(context: Context, data: Array<QuestionData>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    private var questions:Array<QuestionData> = emptyArray()
    var myContext:Context? = null
    public var selQuestion=ArrayList<QuestionData>()

    init {
        questions = data
        myContext = context
    }
    public class ViewHolder(context: Context, itemView: View, selQuestion: ArrayList<QuestionData>) : RecyclerView.ViewHolder(itemView) {
        private var myView:View? = null
        private var myContext:Context? = null
        private var selQuestions :ArrayList<QuestionData>? = null
        init {
            myView=itemView
            myContext = context
            selQuestions = selQuestion
        }
        private var _data:QuestionData? = null
        var data:QuestionData?
            get() = _data
            set(value) {
                if(myView != null)
                {
                    this._data = value
                    var lout=myView?.findViewById<ConstraintLayout>(R.id.bgMain)
                    var nameBox=myView?.findViewById<CheckBox>(R.id.chkbx)
                    var txtType=myView?.findViewById<TextView>(R.id.txtQuestionType)
                    var txtMarks=myView?.findViewById<Spinner>(R.id.drpMarks)
                    nameBox!!.text = data!!.strQuestion
                    txtType!!.text = ("LongQuestion")
                    //txtMarks!!.text =(data!!.intMarks.toString())
                    nameBox.setOnCheckedChangeListener { buttonView, isChecked ->
                        if(nameBox.isChecked){
                            selQuestions?.add(value!!)
                        }
                        else selQuestions?.remove(value)
                    }
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return QuestionAdapter.ViewHolder(myContext!!,view, selQuestion)
//        questions = emptyArray()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.data = questions[position]
    }

    override fun getItemCount(): Int {
        return questions.count()
    }
}