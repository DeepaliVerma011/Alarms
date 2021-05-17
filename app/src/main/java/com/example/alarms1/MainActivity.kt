package com.example.alarms1

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val i: Intent =Intent(baseContext,MainActivity2::class.java)
val pi:PendingIntent= PendingIntent.getActivity(baseContext,12345,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val alarmManager:AlarmManager= getSystemService(ALARM_SERVICE) as AlarmManager
            //for setting one time alarm
           // alarmManager.set(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+600000,pi)
            //for Repeating Alarms
            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+600000,600000,pi)
            //setInexactRepeating can also be used for exact alarm Repeating Continously
            //we can also getService getBroadcast
            //current time + the time delay for scheduling the alarm
            //x,x+5   triggerMillis=x+5

            //we have to use flag update current to create to repeating alarm instead of flag one shot

           /* Four types of alarm :
                    Elapsed_Real_Time ----->not for real time(your time)[for eg setting a alarm for 5 minutes]fires the pending intent
            Elapsed_real_time_wakeup ---->for urgent alarms,fires pending intent,works on actual watch time
            RTC ---> works on Real time , fires pending intent
            RTC_wakeup---------->shows when user opens the phn,not fires the pending intent



            Types of Flags
            1. Flag immutable(cannot be modified or changed)
            2.Flag Cancel current(will cancel the current activity to update into another)
            3.Flag update current (will update the current activity to another)
            4.Flag no create(will not create a view)
            5.Flag one shot (used for one time only)

            */
        }
    }
}