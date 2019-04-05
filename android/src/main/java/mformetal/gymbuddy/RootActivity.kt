package mformetal.gymbuddy

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.Dispatchers
import mformetal.gymbuddy.home.HomeFragment
import mformetal.gymbuddy.kedux.arch.Store
import mformetal.gymbuddy.kedux.arch.ViewModel

class RootActivity : FragmentActivity() {

    val store = Store("first")
    val vm = ViewModel(store,
            Dispatchers.Main,
            Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.app_root, HomeFragment.newInstance())
                    .commit()
        }
    }
}