package com.example.app

import com.example.app.models.Beer
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.util.JSON
import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId
import org.json4s.{DefaultFormats, Formats, JValue, JsonInput}
import org.scalatra.ScalatraServlet
import org.scalatra.json._

class MyBeerController extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats


  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  private val collection = mongoColl("beerList")

  before() {
    contentType = formats("json")
  }

  get("/beer") {
    JSON.serialize(mongoColl("beerList"))
  }

  post("/beer/create") {

    val postBeer = parsedBody.extract[Beer]


    val beerDocument = MongoDBObject(
      "name" -> postBeer.name,
      "rating" -> postBeer.rating
    )
    collection.insert(beerDocument)
}

  get ("/beer/:beerId") {
    collection.find(MongoDBObject("_id" -> new ObjectId(params("beerId")))).next()
  }

  put("/beer/:beerId") {

    val updateBeer = parsedBody.extract[Beer]
    val builder = collection.initializeOrderedBulkOperation

    builder.
      find(MongoDBObject("_id" -> new ObjectId(params("beerId"))))
      .updateOne($set("name" -> updateBeer.name, "rating" -> updateBeer.rating))
    builder.execute()
  }

  delete("/beer/:beerId") {
    collection.findAndRemove(MongoDBObject("_id" -> new ObjectId(params("beerId"))))
  }

  override def parse(in: JsonInput, useBigDecimalForDouble: Boolean, useBigIntForLong: Boolean): JValue = ???

  override def parseOpt(in: JsonInput, useBigDecimalForDouble: Boolean, useBigIntForLong: Boolean): Option[JValue] = ???

  override def render(value: JValue)(implicit formats: Formats): JValue = ???

  override def compact(d: JValue): String = ???

  override def pretty(d: JValue): String = ???
}
