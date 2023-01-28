package com.example.marinaspudic_iazmu

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService
import com.example.marinaspudic_iazmu.api.CatFetcher
import com.example.marinaspudic_iazmu.framework.sendBroadcast


private const val JOB_ID = 1
@Suppress ("DEPRECATION")
class CatAppService : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        CatFetcher(this).fetchItems()
    }

    companion object{
        fun enqueue(context: Context){
            enqueueWork(context, CatAppService::class.java, JOB_ID, Intent(context, CatAppService::class.java))
        }
    }
}