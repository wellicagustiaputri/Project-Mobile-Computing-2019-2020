package id.wellica.projectmocom

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WisataAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var wisata = arrayListOf<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_wisata)

        adapter = WisataAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, wisata[position].name, Toast.LENGTH_SHORT).show()

            val wisata = Wisata(wisata[position].photo, wisata[position].name, wisata[position].overview)

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_WISATA, wisata)
            startActivity(intent)
        }

    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val w = Wisata(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            wisata.add(w)
        }
        adapter.wisata = wisata
    }
}
