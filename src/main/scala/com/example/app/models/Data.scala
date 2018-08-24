package com.example.app.models
import sangria.execution.deferred.HasId

  case class Beer(name: String,
                   rating: Int)

  class BeerRepo {
    import BeerRepo.beers

    def getBeerByRating(rating: Int) : Option[Beer] = beers.find(c => c.rating == rating)
    def getBeerByName(name: String) : Option[Beer] = beers.find(c => c.name == name)
  }

  object BeerRepo {

    val beers = List(
      Beer(
        name = "Lemon Radler",
        rating = 10
      ),
      Beer(
        name = "Grapefruit Radler",
        rating = 10
      )
    )
}

