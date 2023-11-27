package com.GatlingPerformanceFramework.config

object Config {

  val DEV_URL = "https://QAurl.com"
  val QA_URL = "https://Devurl.com"
  val UAT_URL = "https://UATurl.com"
  val TOKEN = "Bearer tokenID"
  val postHeader = Map("SECURITY-TENANT-ID" -> "clientId",
    "SECURITY-PRINCIPAL-ID" -> "userID",
    "Authorization" -> TOKEN,
    "Content-Type" -> "application/json")

  val postHeaderForACL = Map("SECURITY-TENANT-ID" -> "clientId",
    "MSCI-PROFILE-ID" -> "userProfileID",
    "Authorization" -> TOKEN,
    "Content-Type" -> "application/json")

  val getHeader = Map("SECURITY-TENANT-ID" -> "clientID",
    "SECURITY-PRINCIPAL-ID" -> "userID",
    "Authorization" -> TOKEN)

  val asOfDate="2021-01-01"

  val Port50KQA="Gatling-Load-100K-1"
  
  val app_url = "https://reqres.in/"

  val users = Integer.getInteger("users", 10).toInt
  val rampUp = Integer.getInteger("rampup", 100).toInt
  val throughput = Integer.getInteger("throughput", 100).toInt
  val rateStartRange = Integer.getInteger("rateStartRange", 1).toInt
  val rateEndRange = Integer.getInteger("rateEndRange", 5).toInt
}