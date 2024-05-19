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
            DataBerita("PNJ KEMBALI MENDAPATKAN OPINI WAJAR TANPA PENGECUALIAN PADA LHP AUDIT KAP PADA LK 2023", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Etiam massa massa, ultrices ac sagittis non, euismod eget erat. Praesent suscipit fringilla sapien, eget dapibus enim tristique dapibus.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Etiam massa massa, ultrices ac sagittis non, euismod eget erat. Praesent suscipit fringilla sapien, eget dapibus enim tristique dapibus. Sed finibus ipsum ac ante laoreet, vel condimentum ex fermentum.\n" +
                        "\n" +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Etiam massa massa, ultrices ac sagittis non, euismod eget erat. Praesent suscipit fringilla sapien, eget dapibus enim tristique dapibus. Sed finibus ipsum ac ante laoreet, vel condimentum ex fermentum.", "https://example.com/image1.jpg"),
            DataBerita("PERWAKILAN TIK PNJ RAIH JUARA TERBAIK I PILMAPRES TINGKAT LLDIKTI WILAYAH III PROGRAM DIPLOMA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("Visitasi Delegasi China ke Politeknik Negeri Jakarta", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("Sivitas Akademika PNJ Gelar Upacara Peringatan Hari Pendidikan Nasional 2024", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("Pendaftaran MSIB Kampus Merdeka", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("TI4B?? Sini Intip Biodata Mahasiswa kelas TI-4B", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("PNJ punya Bipol Baru, hadiah dari Mandiri", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("Ikuti Dialog Jurusan 2024", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("Aturan Kompensasi Mahasiswa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

            DataBerita("Jadwal Akademik Mahasiswa 2024/2025", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus volutpat blandit facilisis.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "https://upload.wikimedia.org/wikipedia/id/1/16/Logo_Politeknik_Negeri_Jakarta.jpg"),

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
