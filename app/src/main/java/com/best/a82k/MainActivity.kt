package com.best.a82k

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.best.a82k.Fragments.F1
import com.best.a82k.Models.Users
import com.best.a82k.fragments.F2

class MainActivity : AppCompatActivity(), F1.Listener, F2.Listener {
    private lateinit var firstF: F1
    private lateinit var secondF: F2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        firstF = F1()
        secondF = F2()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainMF, firstF)
            .replace(R.id.mainMS, secondF)
            .commit()
    }

    override fun sendF(list: ArrayList<Users>?) {
        firstF.updateF(list)
    }

    override fun sendS(list: ArrayList<Users>?) {
        secondF.updateS(list)
    }
}