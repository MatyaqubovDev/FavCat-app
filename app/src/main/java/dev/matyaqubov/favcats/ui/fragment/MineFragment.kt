package dev.matyaqubov.favcats.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dev.matyaqubov.favcats.R
import dev.matyaqubov.favcats.adapter.MyUploadedAdapter
import dev.matyaqubov.favcats.networking.RetrofitHttp
import dev.matyaqubov.favcats.networking.model.Upload
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MineFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyUploadedAdapter
    private var page = 0
    private lateinit var manager: StaggeredGridLayoutManager
    private var catItems = ArrayList<Upload>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return initViews(inflater.inflate(R.layout.fragment_mine, container, false))
    }

    private fun initViews(view: View): View {
        recyclerView = view.findViewById(R.id.recyclerView)
        getMyUploadedImages()
        adapter = MyUploadedAdapter(catItems)
        recyclerView.adapter = adapter
        manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = manager

        return view
    }

    private fun getMyUploadedImages() {
        RetrofitHttp.apiService.getMyImages(getPage()).enqueue(object : Callback<List<Upload>> {
            override fun onResponse(call: Call<List<Upload>>, response: Response<List<Upload>>) {
                catItems.addAll(response.body()!!)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Upload>>, t: Throwable) {

            }

        })
    }

    private fun getPage(): Int {
        if (page < 20) {
            return page++
        } else
            page = 1
        return page
    }
}