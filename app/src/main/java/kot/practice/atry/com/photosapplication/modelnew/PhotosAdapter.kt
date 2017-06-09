package kot.practice.atry.com.photosapplication.modelnew

import android.content.DialogInterface
import android.provider.Contacts
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by GUR43615 on 5/25/2017.
 */
class PhotosAdapter(photos: Photos, onClickListener: DialogInterface.OnClickListener) :
        RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    var photosreceived = photos;

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tags : TextView
        init()
        {
            tags = itemView.findViewById(R.id.tags) as TextView
        }

    }

    override fun onBindViewHolder(holder: PhotosViewHolder?, position: Int) {
        val Photo = photosreceived.getHits()[position];

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotosViewHolder {

    }

    override fun getItemCount(): Int {
       return photosreceived.getHits().size
    }
}
