package br.edu.ufabc.aluno.abarbosa.copeco.activities

class App {
    companion object{
        const val MY_ID = 0
        var lastMessageId = 0;

        fun getNextMessageId() = ++lastMessageId;
    }
}
