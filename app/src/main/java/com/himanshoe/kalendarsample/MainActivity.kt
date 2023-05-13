/*
 * Copyright 2023 Kalendar Contributors (https://www.himanshoe.com). All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.himanshoe.kalendarsample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.himanshoe.kalendar.KalendarType
import com.himanshoe.kalendar.endlos.Kalendar
import com.himanshoe.kalendar.endlos.model.KalendarEvent
import com.himanshoe.kalendar.endlos.model.KalendarEvents
import com.himanshoe.kalendar.ui.firey.DaySelectionMode
import com.himanshoe.kalendarsample.ui.theme.KalendarTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.todayIn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KalendarTheme {
                Column {
                    val events = (0..5).map {
                        KalendarEvent(
                            date = Clock.System.todayIn(
                                TimeZone.currentSystemDefault()
                            ).plus(it, DateTimeUnit.DAY),
                            eventName = it.toString(),
                        )
                    }
                    val events1 = (0..5).map {
                        com.himanshoe.kalendar.KalendarEvent(
                            date = Clock.System.todayIn(
                                TimeZone.currentSystemDefault()
                            ).plus(it, DateTimeUnit.DAY),
                            eventName = it.toString(),
                        )
                    }
                    com.himanshoe.kalendar.Kalendar(
                        currentDay = Clock.System.todayIn(
                            TimeZone.currentSystemDefault()
                        ),
                        kalendarType = KalendarType.Oceanic,
                        events = com.himanshoe.kalendar.KalendarEvents(events1 + events1 + events1)

                    )
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    com.himanshoe.kalendar.Kalendar(
                        currentDay = Clock.System.todayIn(
                            TimeZone.currentSystemDefault()
                        ),
                        kalendarType = KalendarType.Firey,
                        daySelectionMode = DaySelectionMode.Range,
                        events = com.himanshoe.kalendar.KalendarEvents(events1 + events1 + events1),
                        onRangeSelected = { range, rangeEvents ->
                            Log.d(":SDfsdfsdfdsfsdfsdf",range.toString())
                            Log.d(":SDfsdfsdfdsfsdfsdf",rangeEvents.toString())
                        }
                    )
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))

//                    Kalendar(
//                        modifier = Modifier.fillMaxSize(),
//                        events = KalendarEvents(events + events)
//                    )
                }
            }
        }
    }
}

