package mformetal.gymbuddy

import android.os.Bundle
import androidx.core.app.ComponentActivity
import androidx.fragment.app.FragmentActivity
import mformetal.gymbuddy.base.android.DelegateActivity
import mformetal.gymbuddy.home.*
import mformetal.gymbuddy.kedux.Dispatcher

class HomeActivity : FragmentActivity() {

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