package com.devmasterteam.tasks.service.listener

import com.devmasterteam.tasks.service.model.PersonModel

//"Ouve" a Resposta da API
interface APIlistener<T> {

    fun onSuccess(result: T)
    fun onFailure(message: String)

}