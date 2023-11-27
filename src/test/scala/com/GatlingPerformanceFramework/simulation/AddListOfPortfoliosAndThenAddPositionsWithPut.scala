package com.GatlingPerformanceFramework.simulation

import com.GatlingPerformanceFramework.config.Config.{rateEndRange, rateStartRange, users}
import com.GatlingPerformanceFramework.requests.PSRequests
import com.GatlingPerformanceFramework.util.RandomString.randomString
import io.gatling.core.Predef.*
import io.gatling.core.structure.ChainBuilder

import scala.concurrent.duration.*
import scala.language.postfixOps

class AddListOfPortfoliosAndThenAddPositionsWithPut extends Simulation{


  def AddListOfPortfoliosAndAddPositionsScn(repeatCount:Int)= scenario("Add List of Portfolios and then Add Positions")
    .repeat(repeatCount) {
      exec(session => {
        session.setAll(Map("portfolioId" -> s"BenBe-${randomString(8)}",
          "positionId" -> s"BenBe-${randomString(8)}",
          "instrumentId" -> s"BenBe-${randomString(8)}"))
      })
        .exec(PSRequests.addListOfPortfoliosWithoutPositions("${portfolioId}"))
        .exec(PSRequests.replacePositions("${portfolioId}","${positionId}","${instrumentId}"))
    }

  setUp(AddListOfPortfoliosAndAddPositionsScn(400).inject(atOnceUsers(50)))

}
