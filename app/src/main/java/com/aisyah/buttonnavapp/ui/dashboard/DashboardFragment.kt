package com.aisyah.buttonnavapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aisyah.buttonnavapp.ListAdapter
import com.aisyah.buttonnavapp.Model
import com.aisyah.buttonnavapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class DashboardFragment : Fragment() {

    private val list = ArrayList<Model>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv.setHasFixedSize(true)

        list.addAll(getListData())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv.layoutManager = LinearLayoutManager(context)
        val listAdapter = ListAdapter(list)
        rv.adapter = listAdapter
    }

    private fun getListData(): ArrayList<Model> {
        val dataName = resources.getStringArray(R.array.title_tvseries)
        val dataDesc = resources.getStringArray(R.array.desc_tvseries)
        val dataPhoto = resources.obtainTypedArray(R.array.photo_tvseries)
        val listData = ArrayList<Model>()
        for (position in dataName.indices) {
            val model = Model(
                dataName[position],
                dataDesc[position],
                dataPhoto.getResourceId(position,- 1)
            )
            listData.add(model)
        }
        return listData
    }

}