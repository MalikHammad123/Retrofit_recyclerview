package com.example.retrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var list : ArrayList<AlbumbListItem>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getdata()

    }
    var i=0
    private fun getdata() {
        title = "KotlinApp"
        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setTitle("Progress Bar")
        progressDialog.setMessage("API fetching data")
        progressDialog.show()
        Retrofitinstance.apiInterface.getData().enqueue(object : Callback<AlbumbList?> {
            override fun onResponse(
                call: Call<AlbumbList?>,
                response: Response<AlbumbList?>
            ) {

                list = response.body()
                binding.recyclerview.adapter = list?.let { AlbumsAdapter(this, it) }

                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<AlbumbList?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT)
                    .show()
                progressDialog.dismiss()
            }
        })
    }
}