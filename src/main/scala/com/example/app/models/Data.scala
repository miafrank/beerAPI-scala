package com.example.app.models
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.util.JSON
import org.bson.types.ObjectId

import sangria.execution.deferred.HasId
object Data {

  case class Beer(
                   name: Option[String],
                   rating: Option[Int]
                 )
  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  private val collection = mongoColl("beerList")

//    def getBeerByRating(rating: Int): Option[Beer] = Beer.find(c => c.rating == rating)
//    def getBeerByName(name: String): Option[Beer] = beers.find(c => c.name == name)
    def getAllJsonItems(mongoDocumentName: String)= {JSON.serialize(mongoColl(s"$mongoDocumentName"))}

//    def getJsonItemFromBody[T](t: T) = {Extraction.e
    def getById(id: ObjectId)  = collection.find(MongoDBObject("_id"
      -> new ObjectId(id.toHexString))).next()

    def createNewItem[T](item: Beer) = {
      val document = MongoDBObject(
        "name" -> item.name,
        "rating" -> item.rating
      )

      collection.insert(document)
    }

//    def beerId(id: ObjectId) = collection.findOneByID(c => c.id == id)
}