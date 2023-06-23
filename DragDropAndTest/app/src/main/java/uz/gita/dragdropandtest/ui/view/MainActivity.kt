package uz.gita.dragdropandtest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.DOWN
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.dragdropandtest.R
import uz.gita.dragdropandtest.data.QuestionData
import uz.gita.dragdropandtest.repository.Repository
import uz.gita.dragdropandtest.repository.repositoryImpl.RepositoryImpl
import uz.gita.dragdropandtest.ui.adapter.PuzzleAdapter
import uz.gita.dragdropandtest.ui.dialog.AnswerDialog

class MainActivity : AppCompatActivity() {
    private lateinit var repository: Repository
    private lateinit var list: MutableList<Int>
    private lateinit var listAdapter: PuzzleAdapter
    private lateinit var showAnsBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var currentQuestionData: QuestionData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repository = RepositoryImpl()
        findView()
        clickEvent()

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(UP or DOWN, 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                listAdapter.notifyItemMoved(from, to)
                isWin()
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            }

        }

        ).attachToRecyclerView(recyclerView)

    }

    fun findView() {
        showAnsBtn = findViewById(R.id.answerBtn)
        nextBtn = findViewById(R.id.nextBtn)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerViewSettings()
    }

    private fun isWin() {
        val answer = currentQuestionData.answerList
        for (i in 0..list.size) {
            if (answer[i] != list[i]) return
        }
    }

    private fun recyclerViewSettings() {
        currentQuestionData = repository.getNextQuestion()
        list = currentQuestionData.questionList as MutableList<Int>
        listAdapter = PuzzleAdapter()
        listAdapter.submitList(list)
        recyclerView.adapter = listAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun clickEvent() {
        showAnsBtn.setOnClickListener {
            showDialog()
        }
        nextBtn.setOnClickListener {

            setQuestion()
        }
    }

    private fun setQuestion() {
        currentQuestionData = repository.getNextQuestion()
        list = currentQuestionData.questionList as MutableList<Int>
        listAdapter.submitList(list)
    }

    private fun showDialog() {
        val dialog = AnswerDialog()
        dialog.setImageResource(currentQuestionData.answer)
        dialog.show(supportFragmentManager, null)
    }


}