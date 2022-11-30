package com.devmasterteam.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.devmasterteam.tasks.service.listener.APIlistener
import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.repository.PersonRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val personRepository = PersonRepository(application.applicationContext)
    /**
     * Faz login usando API
     */
    fun doLogin(email: String, password: String){
        personRepository.login(email,password, object : APIlistener<PersonModel> {
            override fun onSuccess(result: PersonModel) {

            }

            override fun onFailure(message: String) {

            }


        })
    }
    /**
     * Verifica se usuário está logado
     */
    fun verifyLoggedUser() {
    }

}