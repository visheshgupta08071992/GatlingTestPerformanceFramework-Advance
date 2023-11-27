package com.GatlingPerformanceFramework.simulation

import com.GatlingPerformanceFramework.config.Config.{rateEndRange, rateStartRange, users}
import com.GatlingPerformanceFramework.requests.PSRequests
import io.gatling.core.Predef.*
import com.GatlingPerformanceFramework.util.RandomString.randomString
import io.gatling.core.structure.ChainBuilder

import scala.concurrent.duration.*
import scala.language.postfixOps

class AddListOfPortfolios extends Simulation{

/*  def AddListOfPortfoliosScn= scenario("Add List of Portfolios")
    .exec(session => {
      session.setAll(Map("portfolioId" -> s"PortTest-${randomString(8)}" ,
                         "positionId" -> s"LoadPos-${randomString(8)}"))
    })
    .exec(PSRequests.addListOfPortfolios("${portfolioId}","${positionId}"))

  setUp(AddListOfPortfoliosScn.inject(atOnceUsers(10)))*/

  def AddListOfPortfoliosScn1(repeatCount:Int)= scenario("Add List of Portfolios")
    .repeat(repeatCount) {
      exec(session => {
        session.setAll(Map("portfolioId" -> s"POTest-${randomString(8)}",
          "positionId" -> s"LoadPos-${randomString(8)}"))
      })
        .exec(PSRequests.addListOfPortfolios("${portfolioId}", "${positionId}"))
    }

  setUp(AddListOfPortfoliosScn1(500).inject(atOnceUsers(100)))

}
