package com.example.moneytrack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneytrack.R
import com.example.moneytrack.data.Dao
import com.example.moneytrack.data.ModelDB
import com.example.moneytrack.data.MyDatabase
import com.example.moneytrack.recycle.MyAdapter
import com.example.moneytrack.recycle.MyViewHolder
import com.example.moneytrack.recycle.OnClick
import com.example.moneytrack.repo.MyRepository
import com.example.moneytrack.viewmodel.MyViewModel
import com.example.moneytrack.viewmodel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,OnClick{
    lateinit var viewModel : MyViewModel
    lateinit var repository : MyRepository
    lateinit var moneyDao: Dao
    var list= mutableListOf<ModelDB>()
    lateinit var recyclerView:RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moneyDao=MyDatabase.getDatabaseObject(this).getDatabaseDao()
        repository= MyRepository(moneyDao)
        val viewModelFactory=MyViewModelFactory(repository)
        viewModel= ViewModelProviders.of(this,viewModelFactory).get(MyViewModel::class.java)

        viewModel.createData(ModelDB("Salary",50000))
        viewModel.createData(ModelDB("Salary",50000))
        viewModel.createData(ModelDB("Salary",50000))
        viewModel.createData(ModelDB("Salary",50000))


        //get tasks fromapi
        viewModel.getTable().observe(this,{
            it.forEach {
                list.add(it)
            }
        })
        viewModel.getTotal().observe(this,{
            total.text=it.toString()
        })
        Toast.makeText(this,""+list.size,Toast.LENGTH_LONG).show()
        recyclerView=recycler
        myAdapter= MyAdapter(this,list,this)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=myAdapter
    }

    override fun edit(modelDB: ModelDB) {
        val newDesc = "New Desc"
        modelDB.desc = newDesc
        modelDB.amount = 300

        viewModel.createData(modelDB)
        viewModel.getTable().observe(this, Observer {
            list.clear()
            list.addAll(it)
            myAdapter.notifyDataSetChanged()
        })
    }

    override fun delete(modelDB: ModelDB) {
        viewModel.deleteData(modelDB)
        viewModel.getTable().observe(this, Observer {
            list.clear()
            list.addAll(it)
            myAdapter.notifyDataSetChanged()
        })
    }
}
