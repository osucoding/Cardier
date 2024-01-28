package com.example.cardier.recycler

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import com.example.cardier.R
import android.content.Intent
import android.widget.TextView
import com.example.cardier.ui.chatting.ChatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class UserAdapter(val context: Context, val userList: ArrayList<com.example.cardier.data.model.User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private lateinit var mAuth: FirebaseAuth
    lateinit var db: FirebaseFirestore

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        var currentUser = userList[position]

        holder.textName.text = currentUser.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)

            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", FirebaseAuth.getInstance().currentUser?.uid)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val textName = itemView.findViewById<TextView>(R.id.text_id)
    }
}