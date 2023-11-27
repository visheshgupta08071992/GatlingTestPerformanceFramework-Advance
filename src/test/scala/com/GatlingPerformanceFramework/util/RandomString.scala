package com.GatlingPerformanceFramework.util

object RandomString {
  def randomString(length: Int) = scala.util.Random.alphanumeric.filter(_.isLetter).take(length).mkString
}
