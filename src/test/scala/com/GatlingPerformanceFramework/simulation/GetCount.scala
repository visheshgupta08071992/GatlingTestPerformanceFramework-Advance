package com.GatlingPerformanceFramework.simulation

import com.GatlingPerformanceFramework.config.Config.{rateEndRange, rateStartRange, users}
import com.GatlingPerformanceFramework.requests.PSRequests
import com.GatlingPerformanceFramework.util.RandomString.randomString
import io.gatling.core.Predef.*
import io.gatling.core.structure.ChainBuilder

import scala.concurrent.duration.*
import scala.language.postfixOps

class GetCount extends Simulation{


  def GetCountScn()= scenario("Get Count Scenario").exec(PSRequests.getCount())



  setUp(GetCountScn().inject(atOnceUsers(10)))

}
