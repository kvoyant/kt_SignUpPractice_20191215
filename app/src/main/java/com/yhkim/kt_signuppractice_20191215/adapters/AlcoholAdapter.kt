package com.yhkim.kt_signuppractice_20191215.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.yhkim.kt_signuppractice_20191215.R
import com.yhkim.kt_signuppractice_20191215.datas.Alcohol
import org.w3c.dom.Text

class AlcoholAdapter (context: Context, resId:Int, list:ArrayList<Alcohol>)
    : ArrayAdapter<Alcohol>(context, resId, list) {
    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.alcohol_spinner_list_item, null)
        }

        val row = tempRow!!

        var data = mList.get(position)


        val a1 = row.findViewById<TextView>(R.id.alcoholBrandNameTxt)
        val a2 = row.findViewById<TextView>(R.id.alcoholTypeTxt)

        a1.text = data.brandName
        a2.text = data.type


        return row
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.alcohol_spinner_dropdown_list_item, null)
        }

        val row = tempRow!!

        var data = mList.get(position)


        val a1 = row.findViewById<TextView>(R.id.alcoholBrandNameTxt)
        val a2 = row.findViewById<TextView>(R.id.alcoholTypeTxt)

        a1.text = data.brandName
        a2.text = data.type


        return row
    }
}