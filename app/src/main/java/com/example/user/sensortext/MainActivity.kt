package com.example.user.sensortext

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tview1: TextView? = null
    var tview2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tview2 = findViewById(R.id.textView)
        tview1 = findViewById(R.id.textView2)
        var sManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var s: Sensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sManager.registerListener(
                object : SensorEventListener {
                    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

                    }

                    override fun onSensorChanged(event: SensorEvent?) {
                        val values=event?.values
                        tview1?.text=values?.get(0).toString()
                        tview2?.text=values?.get(1).toString()

                    }
                }, s, SensorManager.SENSOR_DELAY_NORMAL)

    }
}
