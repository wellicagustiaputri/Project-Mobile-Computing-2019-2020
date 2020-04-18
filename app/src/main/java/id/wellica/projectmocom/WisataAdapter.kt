package id.wellica.projectmocom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class WisataAdapter internal constructor(private val context: Context) : BaseAdapter() {
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_wisata, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val wisata = getItem(position) as Wisata
        viewHolder.bind(wisata)
        return itemView
    }

    override fun getItem(i: Int): Any = wisata[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = wisata.size

    internal var wisata = arrayListOf<Wisata>()

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_overview)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)
        internal fun bind(namawisata : Wisata) {
            txtName.text = namawisata.name
            txtDescription.text = namawisata.overview
            imgPhoto.setImageResource(namawisata.photo)
        }
    }

}