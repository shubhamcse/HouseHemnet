package com.assignment.househemnet.utils

sealed class Status {
    object SUCCESS : Status()
    object ERROR : Status()
    object LOADING : Status()
}
