package com.example.notificationconcept

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notificationconcept.Channels.NotificationChannels

class MainActivity : AppCompatActivity() {
    private lateinit var btnhighpriority: Button
    private lateinit var btnlowpriority: Button
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnhighpriority = findViewById(R.id.btnhighpriority)
        btnlowpriority = findViewById(R.id.btnlowpriority)

        btnlowpriority.setOnClickListener {
            showLowPriorityNotification()
        }

        btnhighpriority.setOnClickListener {
            showHighPriorityNotification()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showLowPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels =NotificationChannels(this)
        notificationChannels.createNotificationChannels()
        val notification = NotificationCompat.Builder(this,notificationChannels.CHANNEL_2)
            .setSmallIcon(R.drawable.ic_baseline_sms_24)
            .setContentTitle("Low priority notification")
            .setContentText("This is my notification body")
            .setColor(Color.BLUE)
            .build()
        notificationManager.notify(2, notification)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun showHighPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()
        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.ic_baseline_sms_24)
            .setContentTitle("High priority notification")
            .setContentText("This is my notification body")
            .setColor(Color.BLUE)
            .build()
        notificationManager.notify(1, notification)
    }

}