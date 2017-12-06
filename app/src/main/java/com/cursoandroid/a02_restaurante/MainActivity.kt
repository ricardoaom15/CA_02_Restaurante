package com.cursoandroid.a02_restaurante

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_restaurant_full.*

class MainActivity : AppCompatActivity() {

    val descriptionSet: ConstraintSet = ConstraintSet()
    val fullSet: ConstraintSet = ConstraintSet()
    var full:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_full)

        descriptionSet.clone(this, R.layout.activity_restaurant)
        fullSet.clone(root)

        fab.setOnClickListener{
            TransitionManager.beginDelayedTransition(root)
            if(full) descriptionSet.applyTo(root)
            else fullSet.applyTo(root)
            full = !full
        }

        loadData()
    }

    fun loadData(){
        name.text = "La pizarra"
        location.text = "Parque el recuerdo"
        phone.text = "8313131"
        des.text = "Pizzeria en el parque el recuerdo"
    }
}
