package kot.practice.atry.com.photosapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.GsonBuilder
import kot.practice.atry.com.photosapplication.api.PixabayClient
import kot.practice.atry.com.photosapplication.modelnew.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), Callback<Photos>{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPhotosList()
    }
    fun getPhotosList()
    {
        var gson = GsonBuilder().setLenient().create()
        var retrofit =  Retrofit.Builder().baseUrl("https://pixabay.com/api/").addConverterFactory(GsonConverterFactory.create(gson)).build()
        var photoretreiver =  retrofit.create(PixabayClient::class.java)
        var callFunction = photoretreiver.getPhotos()
        callFunction.enqueue(this)
    }

    override fun onResponse(call: Call<Photos>?, response: Response<Photos>?) {
        Log.d("SHINOO", "response is "+ response?.isSuccessful())

        response?.isSuccessful().let {
            var resBody: Photos?  =  response?.body();
             Log.d("SHINOO", "response size is" + resBody?.totalHits)
        }
    }

    override fun onFailure(call: Call<Photos>?, t: Throwable?) {
        Log.d("SHINOO", "response onFailure")
        t?.printStackTrace()
    }

}
