package com.example.mycourse

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
// Tab Layout
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    // 1. Method onCreate untuk memuat layout utama
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inisialisasi adapter ViewPager2
//        otak dari pager
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
//        tempat pager akan di load
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
//        dimana tab akan di load
        viewPager.adapter = sectionsPagerAdapter

        // 2. Hubungkan TabLayout dengan ViewPager2 menggunakan TabLayoutMediator
        val tabs: TabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        // Menghilangkan bayangan/elevation di bawah ActionBar jika ada
        supportActionBar?.elevation = 0f
    }
    // 2. Method untuk menampilkan Options Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }
    // 3. Method untuk menangani klik item di Options Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_materi -> {
            // Logika untuk melihat skor
                Toast.makeText(this, "Materi", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_quiz -> {
                Toast.makeText(this, "Quiz", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
        )
    }


}