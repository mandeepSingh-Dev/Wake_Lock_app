package com.example.wake_lockapp.ui.activities

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.wake_lockapp.Base.BaseActivity
import com.example.wake_lockapp.Constants
import com.example.wake_lockapp.R
import com.example.wake_lockapp.ui.NewAppWidget
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        if(Constants.type == Constants.TYPE.PAID)
        {
           showtoast(Constants.type.toString())
        }
        else{
            showtoast(Constants.type.toString())
        }

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)

            val intent: Intent = Intent(this@MainActivity, NewAppWidget::class.java)
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE)

            val ids = AppWidgetManager.getInstance(this@MainActivity).getAppWidgetIds(ComponentName(this@MainActivity,NewAppWidget::class.java))
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        }




    }

}


