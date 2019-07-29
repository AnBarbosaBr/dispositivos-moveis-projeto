package br.edu.ufabc.aluno.abarbosa.copeco.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ufabc.aluno.abarbosa.copeco.R
import br.edu.ufabc.aluno.abarbosa.copeco.model.MessagesDAO
import br.edu.ufabc.aluno.abarbosa.copeco.model.MessagesDAOStub

class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>(){

    class MessagesViewHolder(v: View): RecyclerView.ViewHolder(v){
        val senderText = v.findViewById(R.id.sender_messsage_text) as TextView;
        val receiverText = v.findViewById(R.id.receiver_message_text) as TextView;
        val receiverProfileImage = v.findViewById(R.id.message_profile_image) as ImageView;

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        return MessagesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_messages_layout,
                parent,
                false))
    }

    override fun onBindViewHolder(viewHolder: MessagesViewHolder, position: Int) {
        val message = MessagesDAO.getMessageAt(position) // TODO: precisamos tratar null?
        var userId = 0 // TODO: Get user ID
        var senderId = message.senderId;
         if(userId.equals(senderId)){
             viewHolder.receiverText.visibility = View.INVISIBLE
             viewHolder.receiverProfileImage.visibility = View.INVISIBLE;
             viewHolder.senderText.text = message.content

         }

    }

    override fun getItemCount() : Int = MessagesDAOStub.size()




}
