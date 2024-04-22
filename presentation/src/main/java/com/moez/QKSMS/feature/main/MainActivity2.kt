package com.moez.QKSMS.feature.main

import android.os.Bundle
import android.os.Environment
import android.provider.CallLog
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.moez.QKSMS.R
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        getCallDetails()
    }

    private fun getCallDetails() {
        var counter = 0
        val sb = StringBuffer()

        val calls = mutableListOf<HashMap<String, Long>>()

        val managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, "${CallLog.Calls.DATE} DESC")
        val number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER)
        val type = managedCursor.getColumnIndex(CallLog.Calls.TYPE)
        val date = managedCursor.getColumnIndex(CallLog.Calls.DATE)
        val duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION)
        val lastModified = managedCursor.getColumnIndex(CallLog.Calls.LAST_MODIFIED)
        val id = managedCursor.getColumnIndex(CallLog.Calls._ID)

        Timber.d("Counts = ${managedCursor.count}")

        /*sb.append("Call Details :")
        while (managedCursor.moveToNext()){// && counter < 100) {
            val phNumber = managedCursor.getString(number)
            val callType = managedCursor.getString(type)
            val callDate = managedCursor.getString(date)
            val callDayTime = Date(java.lang.Long.valueOf(callDate))
            val callDuration = managedCursor.getString(duration)
            val callLastModified = managedCursor.getString(lastModified)
            val callLastModifiedTIme = Date(java.lang.Long.valueOf(callLastModified))
            var dir: String? = null
            val dircode = callType.toInt()
            val callId = managedCursor.getString(id);
            when (dircode) {
                CallLog.Calls.OUTGOING_TYPE -> dir = "OUTGOING"
                CallLog.Calls.INCOMING_TYPE -> dir = "INCOMING"
                CallLog.Calls.MISSED_TYPE -> dir = "MISSED"
            }
            //sb.append("\nPhone Number:--- $phNumber \nCall Type:--- $dir \nCall Date:--- $callDayTime \nCall duration in sec :--- $callDuration\nLast modified: $callLastModifiedTIme")
            //sb.append("\n----------------------------------")

            val sb1 = StringBuilder()
            sb.append("\nPhone Number:--- $phNumber \nCall Type:--- $dir \nCall Date:--- $callDayTime \nCall duration in sec :--- $callDuration\nLast modified: $callLastModifiedTIme")
            sb.append("\n----------------------------------")

            val map = HashMap<String, Long>()
            map.put("id", java.lang.Long.valueOf(callId))
            map.put("date", java.lang.Long.valueOf(callDate))

            //calls.add(map);

            Timber.d(sb1.toString())

            counter ++
        }
        managedCursor.close()
        val call = findViewById<TextView>(R.id.call)
        //call.setText(sb)

        val BACKUP_DIRECTORY = Environment.getExternalStorageDirectory().toString() + "/QKSMS/Backups"
        val dir = File(BACKUP_DIRECTORY).apply { mkdirs() }
        val timestamp = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(System.currentTimeMillis())
        val file = File(dir, "backup-$timestamp.json")

        // Write to file
        FileOutputStream(file, true).use { fileOutputStream -> fileOutputStream.write(sb.toString().toByteArray()) }
        Timber.d("Saved at ${file.name} at ${dir.path}")*/

        // Updating the call logs
        /*calls.forEach { map ->
            Timber.d("Updating ${map.get("id")}")

            val cv = ContentValues()
            cv.put(CallLog.Calls.LAST_MODIFIED, map.get("date"))
            val rowsUpdated = contentResolver.update(CallLog.Calls.CONTENT_URI, cv, "${CallLog.Calls._ID} = ?", arrayOf("${map.get("id")}"))

            Timber.d("Rows updated: $rowsUpdated")
            Timber.d("\n")
        }*/


        Timber.d(sb.toString())
    }


}