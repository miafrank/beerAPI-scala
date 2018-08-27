package com.example.app.models
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import org.bson.types.ObjectId
import sangria.execution.deferred.HasId
object Data {

  case class Beer(
                   name: Option[String],
                   rating: Option[Int]
                 )

  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  val collection = mongoColl("beerList")


//    def getBeerByRating(rating: Int): Option[Beer] = Beer.find(c => c.rating == rating)
//    def getBeerByName(name: String): Option[Beer] = beers.find(c => c.name == name)
    def getBeerById(id: ObjectId)  = collection.find(MongoDBObject("_id"  -> new ObjectId(id.toHexString))).next()

//    def beerId(id: ObjectId) = collection.findOneByID(c => c.id == id)
}