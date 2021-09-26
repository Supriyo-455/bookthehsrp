package com.example.bookthehsrp.adapter

import android.content.Context
import android.graphics.Typeface.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import androidx.compose.ui.text.font.Typeface
import com.example.bookthehsrp.R

class ExpandableListViewAdapter constructor(
    private val context: Context,
    private val titleList: List<String>,
    private val dataList: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {


    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return this.dataList[titleList[p0]]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return titleList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return dataList[this.titleList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var convertView = p2
        val listTitle = getGroup(p0) as String
        if(convertView == null){
            val layoutInflater = this.context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
            ) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item_registration, null) as ViewGroup?
        }
        var listTitleTextView = convertView!!.findViewById<TextView>(R.id.listView)
        listTitleTextView.setTypeface(DEFAULT)
        listTitleTextView.text = listTitle
        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var convertView = p3
        val expandableList = getChild(p0, p1) as String
        if(convertView == null){
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item_registration, null)
        }
        val expandedListTextView = convertView!!.findViewById<TextView>(R.id.listView)
        expandedListTextView.text = expandableList
        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return  true
    }

}