package gb.myhomework.popular_libraries_final.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gb.myhomework.popular_libraries_final.databinding.ItemApodBinding
import gb.myhomework.popular_libraries_final.mvp.presenter.list.IApodsListPresenter
import gb.myhomework.popular_libraries_final.mvp.view.list.IApodItemView

class ApodsRVAdapter(val presenter: IApodsListPresenter) :
    RecyclerView.Adapter<ApodsRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemApodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemApodBinding) : RecyclerView.ViewHolder(vb.root),
        IApodItemView {
        override var pos = -1

        override fun setTitle(text: String) = with(vb) {
            tvTitle.text = text
        }

    }
}