package com.example.islamicfragment.Api

import com.google.gson.annotations.SerializedName

data class RadioResponse(

	@field:SerializedName("radios")
	val radios: List<RadiosItem?>? = null
)

data class RadiosItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("radio_url")
	val radioUrl: String? = null
)
