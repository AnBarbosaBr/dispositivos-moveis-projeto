package br.edu.ufabc.aluno.abarbosa.copeco.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ufabc.aluno.abarbosa.copeco.R
import br.edu.ufabc.aluno.abarbosa.copeco.adapters.MessagesAdapter
import br.edu.ufabc.aluno.abarbosa.copeco.model.MessagesDAOStub
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Chat : AppCompatActivity() {
    private lateinit var messagesList : RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        setTitle("PADM");

        messagesList = findViewById(R.id.messages_list)
        messagesList.setHasFixedSize(true)
        messagesList.layoutManager = LinearLayoutManager(this)
        messagesList.addItemDecoration(DividerItemDecoration(this,
            DividerItemDecoration.VERTICAL))
        messagesList.adapter = MessagesAdapter()

        startTest()
    }

    private fun startTest() {
        MessagesDAOStub.createTestMessages();
    }


}
