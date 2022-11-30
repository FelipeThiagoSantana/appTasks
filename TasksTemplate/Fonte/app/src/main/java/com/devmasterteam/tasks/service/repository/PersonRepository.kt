package com.devmasterteam.tasks.service.repository

import android.content.Context
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.service.listener.APIlistener
import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.repository.remote.PersonService
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersonRepository (val context: Context) {

    val remote = RetrofitClient.getService(PersonService::class.java)

    fun login(email: String, password: String, listener: APIlistener<PersonModel>) {
      val call =   remote.login(email, password)
        call.enqueue(object : Callback<PersonModel>{
            override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
                if(response.code() == 200){
                    response.body()?.let { listener.onSuccess(it) }
                } else {
                    // TODO - Tratar JSON
                    listener.onFailure(response.errorBody()!!.string())
                }
            }

            override fun onFailure(call: Call<PersonModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })

    }
}


