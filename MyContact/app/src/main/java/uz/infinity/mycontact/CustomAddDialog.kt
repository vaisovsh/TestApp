package uz.infinity.mycontact

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialog

class CustomAddDialog(private val myContext: Context) : BottomSheetDialog(myContext) {
    private lateinit var submitBtn: View
    private lateinit var nameEdit: EditText
    private lateinit var phoneEdit: EditText
    private lateinit var view: View

    private var dialogListener: ((String, String) -> Unit)? = null

    fun setDialogListener(f: (String, String) -> Unit) {
        dialogListener = f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = LayoutInflater.from(myContext).inflate(R.layout.dialog_layout, null, false)
        setContentView(view)
        setCancelable(false)

        findViews()
        eventClick()
    }

    private fun findViews() {
        submitBtn = view.findViewById(R.id.submitBtn)
        nameEdit = view.findViewById(R.id.nameEdit)
        phoneEdit = view.findViewById(R.id.phoneEdit)
    }

    private fun eventClick() {
        submitBtn.setOnClickListener {
            dialogListener?.invoke(nameEdit.text.toString(), phoneEdit.text.toString())
            dismiss()
        }
    }
}