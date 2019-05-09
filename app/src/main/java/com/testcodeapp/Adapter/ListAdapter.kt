package com.testcodeapp.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.testcodeapp.Model.CurriculumVitae
import com.testcodeapp.R

class ListAdapter(private val list: List<CurriculumVitae.Skills>)
: RecyclerView.Adapter<SkillsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SkillsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        val movie: CurriculumVitae.Skills = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

}