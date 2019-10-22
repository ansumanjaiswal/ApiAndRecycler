package com.jaiswal.behance

import com.jaiswal.behance.models.response.ProjectResponse

class DataModelAdapter(var data: List<ProjectResponse>) : BindableAdapter() {
    //private lateinit var loadMOre: LoadMore
    override fun getObjForPosition(var1: Int): Any {
        /*if (var1 == data.size - 1 && data[var1] is FooterDataModel) {
            loadMOre.onLoadMore(LoadingStatus.LOADING)
        }*/
        return data[var1]
    }

    override fun getLayoutIdForPosition(var1: Int): Int {
        return data[var1].getLayout()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    /*fun setLoadMore(load: LoadMore) {
        this.loadMOre = load
    }*/

}