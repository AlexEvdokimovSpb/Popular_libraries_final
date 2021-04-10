package gb.myhomework.popular_libraries_final.ui.activity

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import gb.myhomework.popular_libraries_final.App
import gb.myhomework.popular_libraries_final.R
import gb.myhomework.popular_libraries_final.databinding.ActivityMainBinding
import gb.myhomework.popular_libraries_final.mvp.presenter.MainPresenter
import gb.myhomework.popular_libraries_final.mvp.view.IMainView
import gb.myhomework.popular_libraries_final.ui.BackClickListener
import gb.myhomework.popular_libraries_final.ui.adapter.ApodsRVAdapter
import gb.myhomework.popular_libraries_final.ui.navigation.AndroidScreens
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {

    val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }

    private var adapter: ApodsRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackClickListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

}