package com.example.cardier.ui.chatting

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ChatActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var sendButton: ImageView
    private lateinit var messageAdapter: com.example.cardier.recycler.MessageAdapter
    private lateinit var messageList: ArrayList<com.example.cardier.data.model.Message>
    private lateinit var mDbRef: DatabaseReference

    var receiverRoom : String? = null
    var senderRoom : String? = null

    companion object {
        private const val TAG = "ChatActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.cardier.R.layout.activity_chat)

        val name = intent.getStringExtra("name")
        val receiverUid = intent.getStringExtra("receiverUID")
        val senderUid = FirebaseAuth.getInstance().currentUser?.uid
        mDbRef = FirebaseDatabase.getInstance().reference

        senderRoom = receiverUid + senderUid
        receiverRoom = senderUid + receiverUid

        supportActionBar?.title = name

        chatRecyclerView = findViewById(com.example.cardier.R.id.chatRecyclerview)
        messageBox = findViewById(com.example.cardier.R.id.inputMessage)
        sendButton = findViewById(com.example.cardier.R.id.layoutSend)

        messageList = ArrayList()
        messageAdapter = com.example.cardier.recycler.MessageAdapter(this, messageList)

        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.adapter = messageAdapter


        // adding data to recyclerView
        mDbRef.child("chats").child(senderRoom!!).child("message")
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    messageList.clear()

                    for (postSnapshot in snapshot.children) {
                        val message = postSnapshot.getValue(com.example.cardier.data.model.Message::class.java)
                        messageList.add(message!!)
                    }

                    messageAdapter.notifyDataSetChanged()
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })

        // adding message to database
        sendButton.setOnClickListener {
            val message = messageBox.text.toString()
            val messageObject = com.example.cardier.data.model.Message(message, senderUid)

            mDbRef.child("chats").child(senderRoom!!).child("message").push()
                .setValue(messageObject).addOnSuccessListener {
                    mDbRef.child("chats").child(receiverRoom!!).child("message").push()
                        .setValue(messageObject)
                }

            messageBox.setText("")
        }

    }

}