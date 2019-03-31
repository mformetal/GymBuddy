package mformetal.gymbuddy

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import mformetal.gymbuddy.extensions.takeIfNull
import mformetal.gymbuddy.home.*

class RootActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.root)

        savedInstanceState?.takeIfNull {
            supportFragmentManager.beginTransaction()
                    .add(R.id.app_root, HomeFragment.newInstance())
                    .commit()
        }
    }
}