package br.edu.ufabc.aluno.abarbosa.copeco.interfaces

import br.edu.ufabc.aluno.abarbosa.copeco.model.Messages

interface MessagesDAOInterface {

    fun size(): Int

    fun add(message: Messages): Int

    fun getMessageAt(position: Int): Messages

}