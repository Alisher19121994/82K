package com.best.a82k.Fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.best.a82k.Models.Users
import com.best.a82k.R
import com.best.a82k.fragments.F2

class F1 : Fragment() {
    private var list: ArrayList<Users>? = null
    private var listener: Listener? = null
    private lateinit var textView: TextView
    private var TAG = F1::class.java.toString()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_firstpage, container, false)
        textView = view.findViewById(R.id.textF)
        val button: Button = view.findViewById(R.id.buttonF)
        button.setOnClickListener {
            getData()

        }
        return view
    }

    private fun getData() {
        val list = ArrayList<Users>()
        list.add(Users("Alisher", "1234"))
        Log.d(TAG, list.toString())
        textView.text = list.toString()
        listener?.sendF(list)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is Listener) {
            context
        } else {
            null
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateF(data: ArrayList<Users>?) {
        textView.text = data.toString()
    }

    interface Listener {
        fun sendF(list: ArrayList<Users>?)
    }
}
