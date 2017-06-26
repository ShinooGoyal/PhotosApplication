package kot.practice.atry.com.photosapplication.modelnew

import android.content.DialogInterface
import android.provider.Contacts
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kot.practice.atry.com.photosapplication.R

/**
 * Created by GUR43615 on 5/25/2017.
 */
class PhotosAdapter(photos: Photos) :
        RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    var photosreceived = photos;

     inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textItem = itemView.findViewById(R.id.txtLayout) as TextView

    }

    override fun onBindViewHolder(holder: PhotosViewHolder?, position: Int) {
        val Photo = photosreceived.getHits()[position];
        holder!!.textItem.setText(Photo.pageURL);

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotosViewHolder {
       val layoutInflater = LayoutInflater.from(parent?.context)
        return PhotosViewHolder(layoutInflater.inflate(R.layout.main_item,parent,false))
    }

    override fun getItemCount(): Int {
        return photosreceived.getHits().size
    }

    fun setPhotos(listPhotos: Photos)
    {
        photosreceived.hits.addAll(listPhotos.hits);
        notifyDataSetChanged()
    }

}
