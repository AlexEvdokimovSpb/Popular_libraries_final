package gb.myhomework.popular_libraries_final.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import gb.myhomework.popular_libraries_final.App
import gb.myhomework.popular_libraries_final.Constants
import gb.myhomework.popular_libraries_final.databinding.FragmentViewVideoBinding
import gb.myhomework.popular_libraries_final.mvp.model.entity.NasaApod
import gb.myhomework.popular_libraries_final.mvp.presenter.ViewPresenter
import gb.myhomework.popular_libraries_final.mvp.view.IViewFragmentView
import gb.myhomework.popular_libraries_final.ui.BackClickListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class ViewVideoFragment : MvpAppCompatFragment(), IViewFragmentView, BackClickListener {

    private val presenter: ViewPresenter by moxyPresenter {
        val apod = arguments?.getParcelable<NasaApod>(APOD_ARG) as NasaApod
        ViewPresenter(apod).apply {
            App.instance.appComponent.inject(this)
        }
    }

    val TAG = "HW " + ViewVideoFragment::class.java.simpleName

    private var vb: FragmentViewVideoBinding? = null
    private var youTubePlayerView: YouTubePlayerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentViewVideoBinding.inflate(inflater, container, false).also {
        vb = it
        youTubePlayerView = vb?.youtubePlayerView
        youTubePlayerView?.let { lifecycle.addObserver(it) }
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        youTubePlayerView?.release();
        vb = null
    }

    override fun backPressed() = presenter.backClick()

    companion object {
        private const val APOD_ARG = "apod"

        fun newInstance(apod: NasaApod) = ViewVideoFragment().apply {
            arguments = Bundle().apply {
                putParcelable(APOD_ARG, apod)
            }
        }
    }

    override fun setTitle(title: String) {
        vb?.tvTitle?.text = title
        if (Constants.DEBUG) {
            Log.v(TAG, "title $title ")
        }
    }

    override fun loadApod(url: String) {
        val uri: Uri = Uri.parse(url)
        val videoId = uri.getPathSegments().get(1)

        if (Constants.DEBUG) {
            Log.v(TAG, "url $url videoId $videoId")
        }

        youTubePlayerView?.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
    }

    override fun setCopyright(copyright: String) {
        vb?.tvCopyright?.text = copyright
    }

    override fun setExplanation(explanation: String) {
        vb?.tvExplanation?.text = explanation
    }
}
