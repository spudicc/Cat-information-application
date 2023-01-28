package com.example.marinaspudic_iazmu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.marinaspudic_iazmu.databinding.ActivitySplashScreenBinding
import com.example.marinaspudic_iazmu.framework.applyAnimation
import com.example.marinaspudic_iazmu.framework.getBooleanPreference
import com.example.marinaspudic_iazmu.framework.isOnline
import com.example.marinaspudic_iazmu.framework.startActivity

private const val DELAY = 5000L
const val DATA_IMPORTED = "com.example.marinaspudic_iazmu.data_imported"

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        beginAnimations()
        redirectToHost()
    }

    private fun beginAnimations() {
        binding.tvSplash.applyAnimation(R.anim.animation)
    }

    private fun redirectToHost() {
        //if (getBooleanPreference(DATA_IMPORTED)){
        //    callDelayed(DELAY) { startActivity<HostActivity>() }
        //}
        //else
        //{
            if (isOnline()){
                CatAppService.enqueue(this)
            }
            else{
                binding.tvSplash.text = getString(R.string.no_internet)
                callDelayed(DELAY) {finish()}
            }
        //}
    }

    private fun callDelayed(DELAY: Long, runnable: Runnable) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity<HostActivity>()
            }, DELAY)
    }
}