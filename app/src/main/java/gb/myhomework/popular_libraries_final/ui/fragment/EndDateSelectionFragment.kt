package gb.myhomework.popular_libraries_final.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.DatePicker
import gb.myhomework.popular_libraries_final.App
import gb.myhomework.popular_libraries_final.databinding.FragmentEndDateSelectionBinding
import gb.myhomework.popular_libraries_final.mvp.presenter.EndDateSelectionPresenter
import gb.myhomework.popular_libraries_final.mvp.view.IDateSelectionFragmentView
import gb.myhomework.popular_libraries_final.ui.BackClickListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class EndDateSelectionFragment : MvpAppCompatFragment(), IDateSelectionFragmentView,
    BackClickListener {

    private val presenter by moxyPresenter {
        EndDateSelectionPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    private var vb: FragmentEndDateSelectionBinding? = null
    private var datePicker: DatePicker? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentEndDateSelectionBinding.inflate(inflater, container, false).also {
        vb = it
        datePicker = vb?.datePicker
    }.root


    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backClick()

    companion object {
        fun newInstance() = EndDateSelectionFragment()
    }

    override fun dateSelection() {
        datePicker?.setOnDateChangedListener { datePicker, year, monthOfYear, dayOfMonth ->
            presenter.setData(year, monthOfYear, dayOfMonth)
        }
    }
}


