package com.example.islamicfragment.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.islamicfragment.R
import com.example.islamicfragment.adapters.AyaAdapter
import kotlinx.android.synthetic.main.activity_start_sura_detalis.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class StartSuraDetalisActivity : AppCompatActivity() {
    lateinit var ayaAdapter: AyaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_sura_detalis)

        val suraName: String = intent.getStringExtra(Constance.EXTRA_SURA_NAME)?:""
        val fileName: String = intent.getStringExtra(Constance.EXTRA_FILE_NAME)?:""

        sura_title.setText(suraName)
       val ayat =  readSuraContent(fileName)
        ayaAdapter = AyaAdapter(ayat)
        Recycler_View.adapter = ayaAdapter
    }

    private fun readSuraContent(fileName: String):List<String> {
        val readLine = mutableListOf<String>()
        val reader: BufferedReader

        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
                readLine.add(line)
               // Log.d("line", line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return readLine
    }
}