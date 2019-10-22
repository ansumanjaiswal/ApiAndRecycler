package com.jaiswal.behance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView



abstract class BindableAdapter : RecyclerView.Adapter<BindableAdapter.BindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int, payloads: MutableList<Any>) {
        val obj = this.getObjForPosition(position)
        holder.bind(obj)
    }

    override fun getItemViewType(position: Int): Int {
        return this.getLayoutIdForPosition(position)
    }

    protected abstract fun getObjForPosition(var1: Int): Any

    protected abstract fun getLayoutIdForPosition(var1: Int): Int

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class BindingViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            //this.binding.setVariable(BR.item, item)
            this.binding.setVariable(BR.item, item)
            this.binding.executePendingBindings()
        }
    }
}