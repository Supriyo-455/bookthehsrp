package com.example.bookthehsrp.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bookthehsrp.R
import com.example.bookthehsrp.adapter.ExpandableListViewAdapter
import com.example.bookthehsrp.data.ExpandableListData

class RegistrationFragment : Fragment(R.layout.registration_fragment){
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandableListView = view.findViewById<ExpandableListView>(R.id.vehicle_type)
        if(expandableListView != null){
            val listData = ExpandableListData.data
            titleList = ArrayList(listData.keys)

            adapter = context?.let { ExpandableListViewAdapter(it, titleList as ArrayList<String>, listData) }
            expandableListView!!.setAdapter(adapter)
            expandableListView!!.setOnGroupExpandListener { groupPosition ->
                Toast.makeText(
                    context,
                    (titleList as ArrayList<String>)[groupPosition] + " List Expanded.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            expandableListView!!.setOnGroupCollapseListener { groupPosition ->
                Toast.makeText(
                    context,
                    (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            expandableListView!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
                Toast.makeText(
                    context,
                    "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(
                            titleList as
                                    ArrayList<String>
                            )
                            [groupPosition]]!!.get(
                        childPosition
                    ),
                    Toast.LENGTH_SHORT
                ).show()
                false
            }
        }
    }
}