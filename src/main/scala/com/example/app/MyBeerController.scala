package com.example.app

import com.example.app.models.Data.Beer
import com.example.app.models.{Data => data}
import com.mongodb.casbah.MongoClient
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json._
//import com.example.app.{MongoDocument => collection}
//import com.example.app.{MongoCollection => mongoColl}
//import com.example.app.{MongoClient => mongoClient}
class MyBeerController extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  private val collection = mongoColl("beerList")

  before() {
    contentType = formats("json")
  }

  get("/beer") {
    data.getAllJsonItems("beerList")
  }

  post("/beer/create") {

    val postBeer = parsedBody.extract[Beer]
    data.createNewItem(postBeer)

}
//
//  get ("/beer/:beerId") {
//    val beerId = new ObjectId(params("beerId"))
//    data.getById(beerId)
//  }
//
//  put("/beer/:beerId") {
//
//    val updateBeer = parsedBody.extract[Beer]
//    val builder = collection.initializeOrderedBulkOperation
//
//    builder
//      .find(MongoDBObject("_id" -> new ObjectId(params("beerId"))))
//      .updateOne($set("name" -> updateBeer.name, "rating" -> updateBeer.rating))
//    builder.execute()
//  }
//
//  delete("/beer/:beerId") {
//    collection.findAndRemove(MongoDBObject("_id" -> new ObjectId(params("beerId"))))
//  }
}
