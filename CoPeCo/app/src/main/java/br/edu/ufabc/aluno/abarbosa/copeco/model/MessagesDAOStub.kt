package br.edu.ufabc.aluno.abarbosa.copeco.model

import br.edu.ufabc.aluno.abarbosa.copeco.interfaces.MessagesDAOInterface

object MessagesDAO : MessagesDAOInterface {

    val effectiveDAO = MessagesDAOStub;


    override fun size(): Int {
        return effectiveDAO.size()
    }

    override fun add(message: Messages): Int {
        return effectiveDAO.add(message)
    }

    override fun getMessageAt(position: Int): Messages {
        return effectiveDAO.getMessageAt(position)
    }
}
/**
 * Singleon Task DAO implemented as an object expression
 */
object MessagesDAOStub : MessagesDAOInterface {
    const val JOAO_ID = 1;
    const val MY_ID = 0;

    private val messages: MutableList<Messages> = ArrayList()

    fun createTestMessages(){
        var messageId = 0


        var message = Messages(
            messageId = messageId++,
            content = "Ola Andre",
            senderId = JOAO_ID,
            timestamp = Messages.stringToTimestamp("02/07/2019-17:20:15")
        )
        messages.add(message);

        message = Messages(messageId++, MY_ID,"Oi João." , Messages.stringToTimestamp("02/07/2019-17:21:09"));
        messages.add(message)

        message = Messages(messageId++, JOAO_ID,"Como está?" , Messages.stringToTimestamp("02/07/2019-17:21:49"));
        messages.add(message)

        message = Messages(messageId++, MY_ID,"Bem, e você?" , Messages.stringToTimestamp("02/07/2019-17:22:13"));
        messages.add(message)
    }

    override fun size(): Int {
        return messages.size
    }

    override fun add(message: Messages): Int {
        messages.add(message)

        return messages.size - 1
    }

    override fun getMessageAt(position: Int): Messages {
        return messages[position]
    }
}