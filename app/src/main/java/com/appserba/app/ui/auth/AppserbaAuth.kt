package com.appserba.app.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.appserba.app.data.model.ActionState
import com.appserba.app.data.repository.AuthRepository
import kotlinx.coroutines.*

object AppserbaAuth {

    fun logout(context: Context,callback: ((ActionState<Boolean>) -> Unit)? =null) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}