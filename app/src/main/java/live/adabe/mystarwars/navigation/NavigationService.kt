package live.adabe.mystarwars.navigation

import android.content.Context
import android.os.Bundle
import ru.terrakok.cicerone.Screen

interface NavigationService {
    fun openHomeScreen()

    fun openDetailsScreen(bundle: Bundle? = null)

    fun attachToActivity(context: Context)

    fun detachFromActivity()

    fun createChain(vararg screens: Screen)

}