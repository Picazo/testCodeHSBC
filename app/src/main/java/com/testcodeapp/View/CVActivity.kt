package com.testcodeapp.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.testcodeapp.Adapter.ListAdapter
import com.testcodeapp.Contract.ContractCV
import com.testcodeapp.Presenter.CVPresenter
import com.testcodeapp.Presenter.CVPresenter.Companion.listSkills
import com.testcodeapp.R
import kotlinx.android.synthetic.main.activity_main.*

class CVActivity : AppCompatActivity(), ContractCV.View {


    private lateinit var mPresenter : ContractCV.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CVPresenter(this)
        mPresenter.getCV()



        recycleView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = ListAdapter(listSkills)
        }

        bottomTabNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bbn_item1 -> {
                    val intent = Intent(this, CVActivity::class.java)
                    startActivity(intent)
                   true
                }
                else -> false
            }
        }

    }

    override fun setPresenter(presenter: ContractCV.Presenter) {
        this.mPresenter = presenter
    }

    override fun showToast(resultData: String){
        Toast.makeText(applicationContext,resultData, Toast.LENGTH_LONG).show()
    }

    override fun setData(name: String,age: String,direction: String,email: String,phone_number: String,about_me: String){
        progressBar.visibility = View.GONE
        tv_cargando.visibility = View.GONE
        txt_aboutme.text = about_me
        txt_name.text = name
        txt_age.text = age
        txt_direction.text = direction
        txt_email.text = email
        txt_skills.visibility = View.VISIBLE
    }



}

