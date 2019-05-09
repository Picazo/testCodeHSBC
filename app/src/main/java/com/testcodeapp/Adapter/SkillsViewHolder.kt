package com.testcodeapp.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.testcodeapp.Model.CurriculumVitae
import com.testcodeapp.R

class SkillsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recyclerview_item_row, parent, false)) {
    private var mTitleView: TextView? = null
    private var mYearView: TextView? = null
    private var mDescriptionView: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.itemTitle)
        mYearView = itemView.findViewById(R.id.itemDate)
        mDescriptionView = itemView.findViewById(R.id.itemDescription)

    }

    fun bind(skill: CurriculumVitae.Skills) {
        mTitleView?.text = skill.title
        mYearView?.text = skill.year.toString()
        mDescriptionView?.text = skill.description.toString()

    }

}