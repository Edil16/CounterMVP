package com.example.countermvp.presenter

import com.example.countermvp.helper.Injector
import com.example.countermvp.view.CounterView

class Presenter {

    private val model = Injector.getModel()
    lateinit var view:CounterView

    fun increment() {
        model.increment()
        view.updateText(model.getCount())
        if (model.getCount()==+10){
            view.showToastIncrement()
        }
        if (model.getCount() == +15){
            view.getColor()
        }
    }

    fun decrement() {
        model.decrement()
        view.updateText(model.getCount())
    }

    fun attachView(view:CounterView) {
        this.view = view
    }


}