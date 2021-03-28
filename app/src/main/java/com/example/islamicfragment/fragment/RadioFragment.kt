package com.example.islamicfragment.fragment

import android.content.DialogInterface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamicfragment.Api.ApiManager
import com.example.islamicfragment.Api.RadioResponse
import com.example.islamicfragment.Api.RadiosItem
import com.example.islamicfragment.R
import com.example.islamicfragment.adapters.RadioAdapter
import com.example.islamicfragment.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.fragment_radio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : BaseActivity() {
    lateinit var radioAdapter: RadioAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        ApiManager.getApis().getRadioChannels().enqueue(object :Callback<RadioResponse>{
            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                showDialoge(message ="internet issue"+ t.localizedMessage,posActionName = "Retry",
                posAction = DialogInterface.OnClickListener { dialog, which ->
                    call.enqueue(this)
                    dialog.dismiss()
                }
                        )
            }

            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                progress_bar.visibility = View.GONE
                if (response.isSuccessful){
                       val data =  response.body()
                        radioAdapter.changeData(data?.radios)
                        Log.e("data",data.toString())
                    }
            }
        })
    }

    private fun setRecyclerView() {
        radioAdapter = RadioAdapter(null)
        RecyclerView_radio.adapter = radioAdapter
        radioAdapter.onPlayClickListener = object :RadioAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, radioChannel: RadiosItem) {
                    playRadio(radioChannel.radioUrl!!)
            }
        }
        radioAdapter.onStopClickListener = object : RadioAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, RadioUrl: RadiosItem) {
                    stopRadio()
            }
        }

    }
        var mediaPlayer = MediaPlayer()
        fun playRadio(url:String){
            stopRadio()
            mediaPlayer.setDataSource(activity!!, Uri.parse(url))
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener{
                it.start()
            }

        }
        fun stopRadio(){
            if (mediaPlayer.isPlaying)
                mediaPlayer.stop()
                mediaPlayer.reset()
        }

    }

