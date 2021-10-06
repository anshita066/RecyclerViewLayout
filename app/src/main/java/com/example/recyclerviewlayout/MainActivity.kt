package com.example.recyclerviewlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.HandlerCompat.postDelayed
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var page =1
    var isLoading = false


    private var layoutManager: RecyclerView.LayoutManager?= null
    private var adapter: RecyclerView.Adapter<RecycleAdapter.ViewHolder>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = layoutManager

        adapter = RecycleAdapter()
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter


        findViewById<RecyclerView>(R.id.recyclerView).addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if(dy>0){
                    val visibleItemCount : Int = (layoutManager as LinearLayoutManager).childCount
                    val pastVisibleItem:Int = (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                    val total: Int= (adapter as RecycleAdapter).itemCount

                    if(!isLoading){
                        if((visibleItemCount + pastVisibleItem)>=total){
                            page++

                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

}


