package live.adabe.mystarwars.navigation

import android.content.Context
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import live.adabe.mystarwars.MainActivity
import live.adabe.mystarwars.R
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class NavigationServiceImpl(cicerone: Cicerone<Router>) : NavigationService {
    private val router = cicerone.router
    private val navigationHolder = cicerone.navigatorHolder

    override fun openHomeScreen() {
        newRootScreen(Screens.HomeScreen())
    }

    override fun openDetailsScreen(bundle: Bundle?) {
        navigateTo(Screens.DetailsScreen(bundle))
    }

    override fun attachToActivity(context: Context) {
        context as MainActivity
        navigationHolder.setNavigator(SupportAppNavigator(context, R.id.nav_host))
    }

    override fun detachFromActivity() {
        navigationHolder.removeNavigator()
    }

    override fun createChain(vararg screens: Screen) {
        router.run { newChain(*screens) }
    }

    private fun navigateTo(screen: Screen) {
        CoroutineScope(Dispatchers.Main).launch {
            router.navigateTo(screen)
        }
    }

    private fun replaceScreen(screen: Screen) {
        CoroutineScope(Dispatchers.Main).launch {
            router.replaceScreen(screen)
        }
    }

    private fun newRootScreen(screen: Screen) {
        CoroutineScope(Dispatchers.Main).launch {
            router.newRootScreen(screen)
        }
    }
}