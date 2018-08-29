package com.example.app.models
import com.mongodb.casbah.MongoClient
import org.json4s._
import sangria.execution.deferred.HasId

object Data {
  implicit val formats = DefaultFormats

  case class Beer(
                   id: Int,
                   name: String,
                   rating: String
                 )

  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  private val collection = mongoColl("beerList")


//  object BeerRepo {
//    import Beer._
//
//    val beers = List(
//      Beer(
//        id = 1,
//        name = "Lemon Radler",
//        rating = 10
//      ),
//      Beer(
//        id = 2,
//        name = "Grapefruit Radler",
//        rating = 10
//      )
//    )
//  }


//  val beerName: String = collection.find(MongoDBObject("name" -> beerName)).toString
//  val beerRating: String = collection.find(MongoDBObject("rating" -> beerRating)).toString
//  val beerId : String = collection.find(MongoDBObject("_id" -> beerId)).toString
//
//  object BeerRepo {
//    val beer = List(
//      Beer(
//        id = beerId,
//        name = beerName,
//        rating = beerRating
//      )
//    )
//  }
//
//  import BeerRepo.beer
//
//  def getBeerById(id: String) : Option[Beer] = beer.find(c => c.id == id)
}