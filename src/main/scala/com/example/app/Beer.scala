package com.example.app

case class BeerItem(
                 name: String,
                 rating: Int
               )
object BeerRepo {

  val beers = List(
    BeerItem(
      name = "Lemon Radler",
      rating = 10
    ),
    BeerItem(
      name = "Grapefruit Radler",
      rating = 10
    )
  )

  def getAllBeer = beers.map(c => c.name + " , " + c.rating)
}

