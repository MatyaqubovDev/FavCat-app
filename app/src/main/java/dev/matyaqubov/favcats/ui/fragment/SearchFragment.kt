package dev.matyaqubov.favcats.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dev.matyaqubov.favcats.R
import dev.matyaqubov.favcats.adapter.SearchAdapter
import dev.matyaqubov.favcats.networking.RetrofitHttp
import dev.matyaqubov.favcats.networking.model.BreedItem
import dev.matyaqubov.favcats.networking.model.Cat
import dev.matyaqubov.favcats.networking.model.CatItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var breeds = ArrayList<String>()
    private var breedItem = ArrayList<BreedItem>()
    private var pages = 1
    private var catItems = ArrayList<CatItem>()
    private lateinit var sp_breed: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SearchAdapter
    private lateinit var manager: StaggeredGridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return initViews(inflater.inflate(R.layout.fragment_search, container, false))
    }

    private fun initViews(view: View): View {
        getBreeds()
        sp_breed = view.findViewById(R.id.sp_breed)
        setupSpinner()
        adapter = SearchAdapter(catItems)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = manager

        return view
    }

    private fun setupSpinner() {
        val adapterspinner =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, breeds)
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_breed.adapter = adapterspinner
        sp_breed.onItemSelectedListener=this

    }

    private fun searchByBreeds(id: String) {
        RetrofitHttp.apiService.searchByBreeds(id,getPage()).enqueue(object :Callback<List<CatItem>>{
            override fun onResponse(call: Call<List<CatItem>>, response: Response<List<CatItem>>) {
                catItems.clear()
                catItems.addAll(response.body()!!)
                Log.d("ressss", response.body().toString())
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<CatItem>>, t: Throwable) {
                Log.d("faaiiilll", t.localizedMessage)
            }

        })
    }


    private fun getBreeds() {
        RetrofitHttp.apiService.getAllBreeds()
            .enqueue(object : Callback<ArrayList<BreedItem>> {
                override fun onResponse(
                    call: Call<ArrayList<BreedItem>>,
                    response: Response<ArrayList<BreedItem>>
                ) {
                    breeds.clear()
                    breedItem.clear()
                    breedItem.addAll(response.body()!!)
                    for (item in response.body()!!) {
                        breeds.add(item.name)
                    }

                }

                override fun onFailure(call: Call<ArrayList<BreedItem>>, t: Throwable) {
                    Toast.makeText(requireContext(), "Something went wrong!!!", Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }

    private fun getPage(): Int {
        if (pages < 20) {
            return pages + 1
        } else {
            pages = 1
            return pages
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        Toast.makeText(requireContext(), "${breedItem[position].id}", Toast.LENGTH_SHORT).show()
        searchByBreeds(breedItem[position].id)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}