package com.example.islamicfragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.trimmedLength
import com.example.islami123.adapter.Hadeth
import com.example.islami123.adapter.HadethAdapter
import com.example.islamicfragment.R
import kotlinx.android.synthetic.main.fragment_hadeth.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class HadethFragment : Fragment() {
    lateinit var hadethAdapter: HadethAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        hadethAdapter = HadethAdapter(readHadeth())
        recycler_view1.adapter = hadethAdapter
    }

    private fun readHadeth(): List<Hadeth> {
        val ahadethList = mutableListOf<Hadeth>()
        val reader: BufferedReader
        try {
            val file: InputStream? = context?.assets?.open("ahadeth.txt")
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = ""
//            line = reader.readLine()
            while (line != null) {
                //Log.d("line", line)
                line = reader.readLine()
                val title = line
                var content = ""
                while (!line?.trim().equals("#")) {
                    content += line + " "
                    line = reader.readLine()
                    //Log.e("line",line)
                }
                val hadeth = Hadeth(title = title,content = content)
                ahadethList.add(hadeth)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return ahadethList

    }
}