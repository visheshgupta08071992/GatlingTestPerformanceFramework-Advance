package com.GatlingPerformanceFramework.simulation

import com.GatlingPerformanceFramework.config.Config.{rateEndRange, rateStartRange, users}
import com.GatlingPerformanceFramework.requests.PSRequests
import com.GatlingPerformanceFramework.util.RandomString.randomString
import io.gatling.core.Predef.*
import io.gatling.core.structure.ChainBuilder

import scala.concurrent.duration.*
import scala.language.postfixOps

class AddStreamOfPositionsToAPortfolio extends Simulation{


  def AddStreamOfPositionsScn(repeatCount:Int)= scenario("Add Stream of Positions to a Portfolio")
    .repeat(repeatCount) {
      exec(session => {
        session.setAll(Map("portfolioId" -> s"Tran100K2-${randomString(8)}"))
      })
        .exec(PSRequests.addListOfPortfoliosWithoutPositions("${portfolioId}"))
        .exec(PSRequests.addStreamOfPosition("${portfolioId}"))
    }

  setUp(AddStreamOfPositionsScn(1).inject(atOnceUsers(1)))


}
