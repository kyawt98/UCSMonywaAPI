package com.kyawt.ucsmonywaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.ucsmonywaapi.adapter.QueenAdapter
import com.kyawt.ucsmonywaapi.api.QueenAPI
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val BaseURL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getQueen()
    }

    fun loadQueenList (queenList:List<Queen>){

        recyclerView = findViewById(R.id.recycler_queeen)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)

            var queenAdapter = QueenAdapter(queenList)
            adapter = queenAdapter
        }

        }

    fun getQueen(){
        var retrofit = Retrofit.Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(QueenAPI::class.java)

        var apiCall = retrofitService.getQueen()
        apiCall.enqueue(object : Callback<List<Queen>>{
            override fun onFailure(call: Call<List<Queen>>, t: Throwable) {
               Log.d("Error", t.toString())
            }

            override fun onResponse(call: Call<List<Queen>>, response: Response<List<Queen>>) {
                var queenList = response.body()!!
                loadQueenList(queenList)
            }
        })
        }


    }


