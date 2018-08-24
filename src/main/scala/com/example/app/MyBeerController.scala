package com.example.app

import com.example.app.models.Data.Beer
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.util.JSON
import org.bson.types.ObjectId
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json._
import com.example.app.models.{Data => beerData}

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


  //TODO insert graphiql html here

  get("/") {

//    views.html.graphiql()
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

    //get id from params, find in mongo db
//  val beerId = collection.find(MongoDBObject("_id" -> new ObjectId(params("beerId")))).next()

    //look up beer id in 'Data'(dummy data)
    beerData.getBeerById(1)
  }

  put("/beer/:beerId") {

    val updateBeer = parsedBody.extract[Beer]
    val builder = collection.initializeOrderedBulkOperation

    builder
      .find(MongoDBObject("_id" -> new ObjectId(params("beerId"))))
      .updateOne($set("name" -> updateBeer.name, "rating" -> updateBeer.rating))
    builder.execute()
  }

  delete("/beer/:beerId") {
    collection.findAndRemove(MongoDBObject("_id" -> new ObjectId(params("beerId"))))
  }
}
