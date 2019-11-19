package com.oreodroid.codingchallenge.models


object JobModelConverter {

    val recurrenceMap =
        mapOf(
            0 to "Once",
            7 to "Weekly",
            14 to "Every 2 weeks",
            28 to "Monthly"
        )

    // Return adequate duration format
    fun adequateDuration(duration: String): String {

        return "Duration: ".plus(duration).plus(" hours")
    }

    // Return adequate duration format
    fun adequateRecurrence(recurrence: Int): String {

        return "Recurrence: ".plus(recurrenceMap[recurrence])
    }

    // Return adequate duration format
    fun adequateLocation(city: String?, street: String?, postalCode: String?): String {

        val location: String = street.plus(" , ").plus(postalCode)

        if (city?.isNotEmpty()!!)
            return city.plus(" |  ").plus(location)

        return location
    }

}