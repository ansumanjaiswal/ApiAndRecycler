package com.jaiswal.behance.models.response

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.jaiswal.behance.ProjectDetailsActivity
import com.jaiswal.behance.R
import com.jaiswal.behance.models.response.CoverImages
import com.jaiswal.behance.models.response.ListBaseRow
import com.jaiswal.behance.models.response.Owner

/*- Screen 1: each item should show at minimum: a project cover image, title, and owner

- Screen 2: show the same information on screen 1, plus: the project description, the project owner's avatar, the project's number of views and number of appreciations, and the project fields (Advertising, Photography, etc).

 */

data class ProjectResponse (
    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("owners")
    val owners: List<Owner>? = null,

    @field:SerializedName("covers")
    val covers: CoverImages? = null
) : ListBaseRow {

    override fun getLayout(): Int {
        return R.layout.item_row
    }

    fun onClickView(view: View) {
        Toast.makeText(view.context, "Clicked on item $id", Toast.LENGTH_SHORT).show()
        (view.context as AppCompatActivity).startActivity(Intent(view.context as AppCompatActivity, ProjectDetailsActivity::class.java))
    }

    fun getUrl(): String{
        if(covers!= null){
            return covers.image_115!!
        }
        return ""
    }

    fun getOwner(): String{
        if(owners!!.isNotEmpty()){
            return owners[0]!!.first_name + " " + owners[0]!!.last_name
        }
        return "Owner name null"
    }

    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl)
                //.placeholder(R.drawable.defaultImage)
                //.error(R.drawable.errorImage)
                .into(view)
        }
    }
}