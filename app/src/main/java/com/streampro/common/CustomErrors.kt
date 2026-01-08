package com.streampro.common

class NetworkError : Exception("No Internet Connection")
class ApiError(val code: Int, message: String) : Exception(message)
