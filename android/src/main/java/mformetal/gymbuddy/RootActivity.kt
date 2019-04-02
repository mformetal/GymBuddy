package mformetal.gymbuddy

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.InternalCoroutinesApi
import mformetal.gymbuddy.home.*
import mformetal.gymbuddy.kedux.v2.CoroutinesStore
import mformetal.gymbuddy.kedux.v2.CoroutinesViewModel

class RootActivity : FragmentActivity() {

    val store = CoroutinesStore("first")
    val vm = CoroutinesViewModel(store)

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.root)

        Toast.makeText(this, "TEST", Toast.LENGTH_SHORT).show()

        store.update("OK")

        val aggregate = mutableListOf<String>()
        vm.observe {
            aggregate.add(it)

            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        store.update("BRO")

        store.update("WE")

        store.update("TEST")

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .add(R.id.app_root, HomeFragment.newInstance())
//                    .commit()
//        }
    }

    override fun onStop() {
        super.onStop()

        store.update("ON STOP")
    }
}