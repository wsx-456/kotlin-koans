package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)


//Support adding several time intervals to a date.
//Add an extra class for storing the time interval and the number of intervals,
//e.g. 'class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)'.
//Add an extension function 'times' to 'TimeInterval', constructing the value of this class.
//Add an extension function 'plus' to 'MyDate', taking a 'RepeatedTimeInterval' as an argument.


operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval { DAY, WEEK, YEAR }

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)

    operator fun contains(d: MyDate): Boolean {
        return d >= start && d <= endInclusive
    }
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }

    override fun hasNext(): Boolean {
        return current <= dateRange.endInclusive
    }
}