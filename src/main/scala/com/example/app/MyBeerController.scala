package com.example.app

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json._
class MyBeerController extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  object BodyParserForJson {
    def parseJsonItem[T](json: String)(implicit m: Manifest[T]) : T = parse(json).extract[T]
  }


  val mongoData = new MongoBeerData

  before() {
    contentType = formats("json")
  }

  get("/beer") {
    mongoData.getAllJsonItems("beerList")
  }
//
//  post("/beer/create") {
//    val postBeer = parsedBody.extract[Beer]
//    data.createNewItem(postBeer)
//  }

  get("/beer/:beerId") {
//    val beerId = new ObjectId(params("beerId"))
//    mongoData.getById(beerId)
//    println(beerId)
//    println(mongoData.getById(beerId))
  }

//  put("/beer/:beerId") {
//    val beerId = new ObjectId(params("beerId"))
//    val updateBeer = parsedBody.extract[Beer]
//
//    data.updateItemByObjectId(updateBeer, beerId)
//  }
//
//  delete("/beer/:beerId") {
//    val beer = new ObjectId(params("beerId"))
//    data.deleteItemById(beer)
//    }
}
