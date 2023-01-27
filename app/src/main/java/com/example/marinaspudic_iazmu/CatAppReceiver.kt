package com.example.marinaspudic_iazmu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.marinaspudic_iazmu.framework.setBooleanPreference
import com.example.marinaspudic_iazmu.framework.startActivity

class CatAppReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.setBooleanPreference(DATA_IMPORTED)
        context.startActivity<HostActivity>()
    }
}