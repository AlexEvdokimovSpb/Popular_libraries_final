package gb.myhomework.popular_libraries_final.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import gb.myhomework.popular_libraries_final.App
import gb.myhomework.popular_libraries_final.databinding.FragmentViewBinding
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.model.image.IImageLoader
import gb.myhomework.popular_libraries_final.mvp.presenter.ViewPresenter
import gb.myhomework.popular_libraries_final.mvp.view.IViewFragmentView
import gb.myhomework.popular_libraries_final.ui.BackClickListener
import gb.myhomework.popular_libraries_final.ui.image.GlideImageLoader
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ViewFragment : MvpAppCompatFragment(), IViewFragmentView, BackClickListener {

    private val presenter: ViewPresenter by moxyPresenter {
        val apod = arguments?.getParcelable<NasaApod>(APOD_ARG) as NasaApod
        ViewPresenter(apod).apply {
            App.instance.appComponent.inject(this)
        }
    }

    private var vb: FragmentViewBinding? = null
    val imageLoader: IImageLoader<ImageView>? = null
    //val imageLoader: GlideImageLoader(ImageView)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentViewBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backClick()

    companion object {
        private const val APOD_ARG = "apod"

        fun newInstance(apod: NasaApod) = ViewFragment().apply {
            arguments = Bundle().apply {
                putParcelable(APOD_ARG, apod)
            }
        }
    }

    override fun setTitle(title: String) {
        vb?.tvTitle?.text = title
    }

    override fun loadApod(url: String) {
        vb?.ivApod?.let { imageLoader?.load(url, it) }
    }

    override fun setCopyright(copyright: String) {
        vb?.tvCopyright?.setText(copyright)
    }

    override fun setExplanation(explanation: String) {
        vb?.tvExplanation?.setText(explanation)
    }
}
