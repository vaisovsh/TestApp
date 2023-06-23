package uz.gita.dragdropandtest.ui.dialog

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import uz.gita.dragdropandtest.R

class AnswerDialog : DialogFragment(R.layout.dialog_answer) {
    private var imageResource=0

    fun setImageResource(answerImage:Int){
        imageResource=answerImage
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val image: ImageView =view.findViewById(R.id.answerImage)
        val btnOk: Button =view.findViewById(R.id.okBtn)

        image.setImageResource(imageResource)
        btnOk.setOnClickListener{
            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        val params = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params
    }

}