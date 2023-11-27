package com.GatlingPerformanceFramework.requests

import com.GatlingPerformanceFramework.config.Config._
import com.GatlingPerformanceFramework.util.RandomString.randomString
import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

object PSRequests {

  def addListOfPortfolios(portfolioId: String,positionId: String) = http("Add List of Portfolios Request")
    .post(QA_URL + "/portfolios")
    .headers(postHeader)
    .body(ElFileBody("./src/test/resources/bodies/AddListOfPortfolios.json"))
    .asJson
    .check(status is 200)
    .check(jsonPath("$[0].success").ofType[Boolean].is(true))
    .requestTimeout(60000)

  def addListOfPortfoliosWithoutPositions(portfolioId: String) = http("Add List of Portfolios Request without Position")
    .post(DEV_URL + "/portfolios")
    .headers(postHeader)
    .body(ElFileBody("./src/test/resources/bodies/AddListOfPortfoliosWithoutPositions.json"))
    .asJson
    .check(status is 200)
    .check(jsonPath("$[0].success").ofType[Boolean].is(true))
    .requestTimeout(60000)

  def replacePositions(portfolioId: String,positionId: String, instrumentId: String) = http("Replace Positions Request")
    .put(DEV_URL + s"/portfolios/${portfolioId}/as-of/${asOfDate}/positions")
    .headers(postHeader)
    //.body(ElFileBody("./src/test/resources/bodies/ReplacePositions.json"))
    .body(ElFileBody("C://Users/guptvis/OneDrive/OneDrive - MSCI Office 365/Desktop/PositionJson/position.json"))
    .asJson
    .check(status is 200)
    .check(jsonPath("$.success").ofType[Boolean].is(true))
    .requestTimeout(60000)

  def addStreamOfPosition(portfolioId: String) = http("Add Stream of Positions Request")
    .post(QA_URL + s"/portfolios/${portfolioId}/as-of/${asOfDate}/positions/stream")
    .headers(postHeader)
    .body(ElFileBody("C://Users/guptvis/OneDrive/OneDrive - MSCI Office 365/Desktop/PositionJson/position.json"))
    .asJson
    .check(status is 200)
    .check(jsonPath("$.success").ofType[Boolean].is(true))
    .requestTimeout(60000)

  def getStreamOfPosition() = http("Get Stream of Positions Request")
    .get(QA_URL + s"/portfolios/${Port50KQA}/as-of/${asOfDate}/positions/stream")
    .headers(getHeader)
    .asJson
    .check(status is 200)
    .requestTimeout(60000)

  def getCount() = http("Count Request")
    .get("/")

}
