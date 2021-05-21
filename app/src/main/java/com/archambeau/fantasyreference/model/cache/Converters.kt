package com.archambeau.fantasyreference.model.cache

import androidx.room.TypeConverter
import java.util.*

/**
 * Needed because Room doesn't actually know about Date
 *
 */
class Converters {

    @TypeConverter
    fun dateFromTimestamp(value : Long?): Date?{
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun timestampFromDate(value: Date?): Long?{
        return value?.time
    }

}