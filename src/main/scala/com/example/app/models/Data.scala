package com.example.app.models
import org.bson.types.ObjectId
import sangria.execution.deferred.HasId
object Data {

  case class Beer(id: Int, name: String,
                  rating: Int)

    import BeerRepo.beers

    def getBeerByRating(rating: Int): Option[Beer] = beers.find(c => c.rating == rating)
    def getBeerByName(name: String): Option[Beer] = beers.find(c => c.name == name)
    def getBeerById(id: ObjectId) : Option[Beer] = beers.find(c => id equals c.id)

  object BeerRepo {

    val beers = List(
      Beer(
        id = 1,
        name = "Lemon Radler",
        rating = 10
      ),
      Beer(
        id = 2,
        name = "Grapefruit Radler",
        rating = 10
      )
    )
  }
}