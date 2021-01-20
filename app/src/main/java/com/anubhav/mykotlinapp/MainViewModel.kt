package com.anubhav.mykotlinapp

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anubhav.mykotlinapp.uimodels.OnDataReadyCallback
import com.anubhav.mykotlinapp.uimodels.OnRepositoryReadyCallback
import com.anubhav.mykotlinapp.uimodels.RepoModel
import com.anubhav.mykotlinapp.uimodels.Repository

class MainViewModel : ViewModel() {

    var repoModel: RepoModel = RepoModel()
 //   val text = ObservableField<String>()
 //   val isLoading = ObservableField<Boolean>()
 //   var repositories = ArrayList<Repository>()

    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()

   /* fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }*/

    fun loadRepositories(){
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}