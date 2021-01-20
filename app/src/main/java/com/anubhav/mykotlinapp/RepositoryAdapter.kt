package com.anubhav.mykotlinapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anubhav.mykotlinapp.databinding.AvItemRepoBinding
import com.anubhav.mykotlinapp.uimodels.OnItemClickListener
import com.anubhav.mykotlinapp.uimodels.Repository

class RepositoryAdapter(private var items: ArrayList<Repository>,
                        private var listener: OnItemClickListener) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AvItemRepoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    fun replaceData(arrayList: ArrayList<Repository>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: AvItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: OnItemClickListener?) {
            binding.repository = repo
            if (listener != null) {
                binding.root.setOnClickListener {listener.onItemClick(layoutPosition)}
            }

            binding.executePendingBindings()
        }
    }
}