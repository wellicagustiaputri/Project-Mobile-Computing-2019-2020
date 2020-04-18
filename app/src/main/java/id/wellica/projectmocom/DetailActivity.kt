package id.wellica.projectmocom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_WISATA = "extra_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val wisata = intent.getParcelableExtra(EXTRA_WISATA) as Wisata
        val name = wisata.name.toString()
        val overview = wisata.overview.toString()


        Glide.with(this).load(wisata.photo).into(img_detail)

        txt_namadetail.text = name
        txt_overviewdetail.text = overview
    }
}
