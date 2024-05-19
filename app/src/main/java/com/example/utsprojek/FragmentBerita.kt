package com.example.utsprojek

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.utsprojek.DataBerita

class FragmentBerita : Fragment() {

    private lateinit var listView: ListView
    private lateinit var adapter: AdapterBerita

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmentberita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.listView)
        val beritaList = listOf(
            DataBerita("PNJ KEMBALI MENDAPATKAN OPINI WAJAR TANPA PENGECUALIAN PADA LHP AUDIT KAP PADA LK 2023", "Kementerian Komunikasi dan Informatika (Kominfo) menyebut pihaknya akan melakukan prosedur standar untuk menelusuri dugaan kebocoran data Kependudukan dan Pencatatan Sipil (Dukcapil).",
                "Sebelumnya, sebanyak 337 juta data masyarakat di Direktorat Dukcapil Kementerian Dalam Negeri (Kemendagri) diduga mengalami kebocoran dan dijual di forum online hacker BreachForums.\n" +
                        "\n" +
                        "Kebocoran itu diungkap Teguh Aprianto, pendiri Ethical Hacker Indonesia, di media sosial pada Minggu (16/7). Teguh menjelaskan data yang dipastikan bocor adalah nama, Nomor Induk Kependudukan (NIK), nomor Kartu Keluarga (KK), tanggal lahir, alamat, nama ayah, nama ibu, NIK ibu, nomor akta lahir, nomor akta nikah dan lainnya.", "https://example.com/image1.jpg"),
            DataBerita("Tarif Rp24 Ribu Rute Terjauh LRT Dinilai Wajar", "PENGAMAT transportasi Djoko Setijowarno mengungkapkan tarif LRT Jabodebek yang diputuskan oleh Kementerian Perhubungan sebesar Rp24 ribu untuk rute terjauh dari Stasiun Harjamukti ke Dukuh Atas sudah wajar dan sesuai.",
                "Deskripsi Berita 1 untuk DetailActivity", "https://example.com/image1.jpg"),
            DataBerita("Indonesia Juara SEA V League 2023 Pekan Pertama", "TIMNAS voli putra Indonesia berhasil meraih gelar juara SEA V League 2023 pekan pertama usai mengalahkan Thailand 3-1 (21-25, 25-17, 25-23, dan 27-25) di GOR Candradimuka Padepokan Voli Jenderal Polisi Kunarto, Sentul, Bogor, Minggu (23/7) malam.", "Deskripsi Berita 1 untuk DetailActivity", "https://example.com/image1.jpg"),
            DataBerita("Bandara Soekarno-Hatta Direvitalisasi, Catat Area yang Terdampak", "Bandara Soekarno-Hatta, Tangerang, Banten akan direvitalisasi selama sekitar enam bulan ke depan. Hal ini dilakukan untuk meningkatkan kapasitas dan produktivitas pergerakan penumpang dan pesawat.", "Deskripsi Berita 1 untuk DetailActivity", "https://example.com/image1.jpg")
            // Tambahkan item berita lainnya di sini
        )

        adapter = AdapterBerita(requireContext(), R.layout.itemberita, beritaList)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedBerita = beritaList[position]
            val intent = Intent(activity, DetailBeritaActivity::class.java).apply {
                putExtra("title", selectedBerita.title)
                putExtra("desc", selectedBerita.descListView)
                putExtra("imageUrl", selectedBerita.imageUrl)
            }
            startActivity(intent)
        }
    }
}
