package com.example.practical_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class MainActivity : AppCompatActivity() { override fun
                onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main) var alarmbutton
                    = findViewById<Button>(R.id.alrmbtn1)
            alarmbutton.setOnClickListener { showTimeDialog()
            }
        }

            fun showTimeDialog() { val cldr: Calendar =
                Calendar.getInstance() val hour: Int =
                cldr.get(Calendar.HOUR_OF_DAY) val minutes:
                    Int = cldr.get(Calendar.MINUTE) val picker = TimePickerDialog(
                this,
                { tp, sHour, sMinute -> sendDialogDataToActivity(sHour, sMinute) }, hour,
                minutes, false
            )
                picker.show()
            }

            private fun sendDialogDataToActivity(sHour: Int, sMinute: Int) {
                val alarmCalendar = Calendar.getInstance() val year: Int =
                    alarmCalendar.get(Calendar.YEAR) val month: Int =
                    alarmCalendar.get(Calendar.MONTH) val day: Int =
                    alarmCalendar.get(Calendar.DATE)
                alarmCalendar.set(year, month, day, sHour, sMinute, 0)
            }

            private fun setAlarm(millisTime: Long, str: String) { val
                    intent = Intent(this, MyReceiver::class.java)
                intent.putExtra("Service1", str)
            }

        }
    }
}