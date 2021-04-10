package gb.myhomework.popular_libraries_final.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import gb.myhomework.popular_libraries_final.App
import gb.myhomework.popular_libraries_final.databinding.FragmentStartBinding
import gb.myhomework.popular_libraries_final.mvp.model.NasaApodRepo
import gb.myhomework.popular_libraries_final.mvp.presenter.StartPresenter
import gb.myhomework.popular_libraries_final.mvp.view.IStartFragmentView
import gb.myhomework.popular_libraries_final.ui.BackClickListener
import gb.myhomework.popular_libraries_final.ui.adapter.ApodsRVAdapter
import gb.myhomework.popular_libraries_final.ui.navigation.AndroidScreens
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class StartFragment : MvpAppCompatFragment(), IStartFragmentView, BackClickListener {

    private val presenter by moxyPresenter {
        StartPresenter(NasaApodRepo(), App.instance.router, AndroidScreens())
    }
    private var vb: FragmentStartBinding? = null
    private var adapter: ApodsRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentStartBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvApods?.layoutManager = LinearLayoutManager(requireContext())
        adapter = ApodsRVAdapter(presenter.apodsListPresenter)
        vb?.rvApods?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()

    companion object {
        fun newInstance() = StartFragment()
    }
}
