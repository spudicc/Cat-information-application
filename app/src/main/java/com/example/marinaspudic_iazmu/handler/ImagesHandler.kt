package com.example.marinaspudic_iazmu.handler

import android.content.Context
import android.util.Log
import com.example.marinaspudic_iazmu.factory.createGetHttpUrlConnection
import java.io.File
import java.net.HttpURLConnection
import java.nio.file.Files
import java.nio.file.Paths

    fun downloadAndStoreImage(context: Context, url: String): String? {
        //https://apod.nasa.gov/apod/image/1705/HebesChasma_esa_1024.jpg
        //https://api-ninjas.com/images/cats/aphrodite_giant.jpg
        val filename = url.substring(url.lastIndexOf("/") + 1) //HebesChasma_esa_1024.jpg
        val file = createFile(context, filename)
        try{
            val con : HttpURLConnection = createGetHttpUrlConnection(url)
            Files.copy(con.inputStream, Paths.get(file.toURI()))
            return file.absolutePath
        } catch (e: Exception) {
            Log.e("IMAGESHANDLER", e.toString(), e)
        }

        return null
    }

    private fun createFile(context: Context, filename: String): File {
        val dir = context.applicationContext.getExternalFilesDir(null)
        val file = File(dir, filename)
        if (file.exists()) file.delete()
        return file
    }

