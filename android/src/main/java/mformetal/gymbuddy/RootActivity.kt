package mformetal.gymbuddy

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.Dispatchers
import mformetal.gymbuddy.kedux.v2.Store
import mformetal.gymbuddy.kedux.v2.ViewModel

class RootActivity : FragmentActivity() {

    val store = Store("first")
    val vm = ViewModel(store,
            Dispatchers.Main,
            Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.root)

        val textView = findViewById<TextView>(R.id.test)

        vm.start {
            textView.text = it + ", " + textView.text
        }

        object : CountDownTimer(1000, 1) {
            override fun onFinish() {
                store.update("FINISH")
            }

            override fun onTick(millisUntilFinished: Long) {
                Log.d("WTF", "$millisUntilFinished")
                store.update("$millisUntilFinished")
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed(Runnable {
            store.update("NEW SHIT")
        }, 10000)
    }

    override fun onStop() {
        super.onStop()

        store.update("ON STOP")
    }
}