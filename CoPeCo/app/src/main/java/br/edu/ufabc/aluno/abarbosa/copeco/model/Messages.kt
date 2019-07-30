package br.edu.ufabc.aluno.abarbosa.copeco.model

import java.sql.Timestamp
import java.text.SimpleDateFormat

data class Messages(
    val messageId : Int,
    val senderId : Int,
    val content : String,
    val timestamp : Timestamp
){
    companion object{
        val dateFrom = SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");

        fun stringToTimestamp(timestring : String) : Timestamp{
            return Timestamp(dateFrom.parse(timestring).getTime());
        }
    }
};


