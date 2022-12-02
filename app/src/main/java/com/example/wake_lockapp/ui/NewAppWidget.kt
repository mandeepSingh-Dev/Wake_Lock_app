package com.example.wake_lockapp.ui

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.Toast
import com.example.wake_lockapp.R
import com.example.wake_lockapp.ui.activities.MainActivity2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        context.startActivity(Intent(context,MainActivity2::class.java))

        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {

            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)


        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(context, "9h4gfrefg", Toast.LENGTH_SHORT).show()
            Toast.makeText(context,"onDisabled",Toast.LENGTH_SHORT).show()

        }
    }


    @SuppressLint("RemoteViewLayout")
    fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {

        val views = RemoteViews(context.packageName, R.layout.new_app_widget)
        //  views.setTextViewText(R.id.tenantTextView, widgetText)

        val intentUpdate = Intent(context, NewAppWidget::class.java)
        intentUpdate.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE

        val idArray = intArrayOf(appWidgetId)
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray)



        val pendingUpdate = PendingIntent.getBroadcast(context, appWidgetId,intentUpdate /*Intent(context,MainActivity2::class.java)*/, 0)

        views.setOnClickPendingIntent(R.id.buttonnn, pendingUpdate)

        appWidgetManager.updateAppWidget(appWidgetId, views)

    }

}

