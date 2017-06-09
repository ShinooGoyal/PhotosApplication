package kot.practice.atry.com.photosapplication.api

import kot.practice.atry.com.photosapplication.modelnew.Photos
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by GUR43615 on 5/20/2017.
 */
internal interface PixabayClient
{
    @GET("?key=5415584-925148b27257890b90f7ada92&q=nature&image_type=photo")
    fun getPhotos() : Call<Photos>
}
