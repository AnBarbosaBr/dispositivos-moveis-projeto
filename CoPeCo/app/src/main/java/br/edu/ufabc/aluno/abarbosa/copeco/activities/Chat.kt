package br.edu.ufabc.aluno.abarbosa.copeco.activities


import java.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ufabc.aluno.abarbosa.copeco.R
import br.edu.ufabc.aluno.abarbosa.copeco.adapters.MessagesAdapter
import br.edu.ufabc.aluno.abarbosa.copeco.model.Messages
import br.edu.ufabc.aluno.abarbosa.copeco.model.MessagesDAOStub
import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.sql.Timestamp


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
        plugButtons()
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    private fun plugButtons() {
        var send = findViewById<FloatingActionButton>(R.id.send_message_button)
        send.setOnClickListener { view ->
            var text = findViewById<EditText>(R.id.send_message_text);
            var message = Messages(
                App.getNextMessageId(),
                App.MY_ID,
                text.text?.toString()?:"",
                Timestamp(Calendar.getInstance().time.time));
            text.setText("");
            MessagesDAOStub.add(message)
            updateMessages()
        }
    }

    private fun updateMessages() {
        var adapter = messagesList.adapter;
        adapter?.notifyDataSetChanged()
        if(adapter?.itemCount?:0 > 0){
            messagesList.postDelayed( {
                                        messagesList.smoothScrollToPosition(adapter?.itemCount ?: 0 - 1)
            }, 100)
        }
    }

    private fun startTest() {
        MessagesDAOStub.createTestMessages();
    }


}
