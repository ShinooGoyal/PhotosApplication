package kot.practice.atry.com.photosapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.GsonBuilder
import kot.practice.atry.com.photosapplication.api.PixabayClient
import kot.practice.atry.com.photosapplication.modelnew.Photos
import kot.practice.atry.com.photosapplication.modelnew.PhotosAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), Callback<Photos>{

    lateinit var adapter:PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPhotosList()
        var photosView = findViewById(R.id.photosView) as RecyclerView
        var manager = LinearLayoutManager(this)
        photosView.layoutManager = manager
        adapter = PhotosAdapter(Photos())
        photosView.adapter = adapter
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
            if(resBody!=null)
                adapter.setPhotos(resBody)
            Log.d("SHINOO", "response size is" + resBody?.totalHits+ " " +resBody?.hits?.size)
        }
    }

    override fun onFailure(call: Call<Photos>?, t: Throwable?) {
        Log.d("SHINOO", "response onFailure")
        t?.printStackTrace()
    }

}
