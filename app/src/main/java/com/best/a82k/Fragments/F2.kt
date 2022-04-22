package com.best.a82k.fragments

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
import com.best.a82k.Fragments.F1
import com.best.a82k.Models.Users
import com.best.a82k.R

class F2 : Fragment() {

    private var list: ArrayList<Users>? = null
    private var listener: Listener? = null
    private lateinit var textView: TextView
    private var TAG = F2::class.java.toString()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_secondpage, container, false)
        textView = view.findViewById(R.id.textS)
        val button: Button = view.findViewById(R.id.buttonS)
        button.setOnClickListener {
            getDataB()
        }

        return view
    }

    private fun getDataB() {
        val list = ArrayList<Users>()
        list.add(Users("Abbos", "4321"))
        Log.d(TAG, list.toString())
        textView.text = list.toString()
        listener?.sendS(list)
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

    fun updateS(data: ArrayList<Users>?) {
        textView.text = data.toString()
    }

    interface Listener {
        fun sendS(list: ArrayList<Users>?)
    }
}