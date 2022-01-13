package fr.pf.pfbaseapp

import Message
import MessageAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var listeMessage = ArrayList<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnAjouterMessage)
        btn.setOnClickListener() {
            System.out.println("btn clicked")
            this.setMessages()
        }
    }

    fun setMessages(){
        var m1 = Message("R", "Sender1", "Content1")
        var m2 = Message("R", "Sender 2", "Content2")
        listeMessage.add(m1);
        listeMessage.add(m2);
        this.afficherMessages(listeMessage)
        System.out.println(listeMessage.get(0).content)
    }

    //Affiche les messages
    fun afficherMessages(messages : ArrayList<Message>){
        // Affichage avec le recycler view
        var listeMessages = messages
        var messageListe : MutableList<Message> = ArrayList<Message>()

        val recyclerView : RecyclerView = findViewById(R.id.affichageMessages)

        for(message in listeMessages){ messageListe.add(message)}

        // création de l'adapter :
        val adapter : MessageAdapter = MessageAdapter(listeMessages)
        // On notifie au RV notre adapter
        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
    }
}