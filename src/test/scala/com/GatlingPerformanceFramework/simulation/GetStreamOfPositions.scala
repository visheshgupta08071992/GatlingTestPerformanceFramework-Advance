package com.GatlingPerformanceFramework.simulation

import com.GatlingPerformanceFramework.config.Config.{rateEndRange, rateStartRange, users}
import com.GatlingPerformanceFramework.requests.PSRequests
import com.GatlingPerformanceFramework.util.RandomString.randomString
import io.gatling.core.Predef.*
import io.gatling.core.structure.ChainBuilder

import scala.concurrent.duration.*
import scala.language.postfixOps

class GetStreamOfPositions extends Simulation{


  def GetStreamOfPositionsScn(repeatCount:Int)= scenario("Get Stream of Positions of a Portfolio")
    .repeat(repeatCount) {
        exec(PSRequests.getStreamOfPosition())
    }

  setUp(GetStreamOfPositionsScn(1).inject(atOnceUsers(1)))

}
