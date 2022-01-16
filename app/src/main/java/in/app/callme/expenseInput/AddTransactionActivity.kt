package `in`.app.callme.expenseInput

import `in`.app.callme.R
import `in`.app.callme.databinding.ActivityAddTransactionBinding
import `in`.app.callme.databinding.TransactionTypeSelectorLayoutBinding
import `in`.app.callme.utils.AppCustomToast
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil

class AddTransactionActivity : AppCompatActivity(), View.OnClickListener {
    //declare views
    private var amountEditText: EditText? = null
    private var notesEditText: EditText? = null
    private var addReceiptEditText: EditText? = null
    private var dateEditText: EditText? = null
    private var categoryEditText: EditText? = null
    private var incomeSelectionTypeTv: TextView? = null
    private var expenseSelectionTypeTv: TextView? = null
    private var submitBtnForTransaction: Button? = null

    private var mainBinding: ActivityAddTransactionBinding? = null
    private var transactionTypeSelectionBinding: TransactionTypeSelectorLayoutBinding? = null

    //declare variables
    //if 1 transaction type=income , if 2 transType= expense but by default selection = 1 (means income)
    var currentSelectedTransactionType = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflating the layout using data binding i think safest way
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_transaction)
        initializeViews(mainBinding = mainBinding)
        setUpListeners()
    }


    private infix fun initializeViews(mainBinding: ActivityAddTransactionBinding?) {
        //just initializing variables or views
        mainBinding?.let { parentBinding ->
            transactionTypeSelectionBinding = parentBinding.transactionTypeSelectorContainer
            amountEditText = parentBinding.amountEditText
            notesEditText = parentBinding.addNotesEditText
            addReceiptEditText = parentBinding.addReceiptEditText
            dateEditText = parentBinding.dateEditText
            categoryEditText = parentBinding.categoryEditText
            submitBtnForTransaction = parentBinding.submitAddTransactionBtn
            incomeSelectionTypeTv = transactionTypeSelectionBinding?.transactionTypeIncome
            expenseSelectionTypeTv = transactionTypeSelectionBinding?.transactionTypeExpense
        }
    }

    private fun setUpListeners() {
        submitBtnForTransaction?.isEnabled = true
        submitBtnForTransaction?.setOnClickListener(this::onClick)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            mainBinding?.submitAddTransactionBtn?.id -> {
                this.finish()
            }
            else -> {

            }
        }
    }

}