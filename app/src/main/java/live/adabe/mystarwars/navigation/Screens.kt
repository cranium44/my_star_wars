package live.adabe.mystarwars.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import live.adabe.mystarwars.ui.DetailsFragment
import live.adabe.mystarwars.ui.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class HomeScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return HomeFragment()
        }
    }

    class DetailsScreen(private val bundle: Bundle?) : SupportAppScreen() {
        override fun getFragment(): Fragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}