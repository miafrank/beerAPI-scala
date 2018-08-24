package com.example.app

import com.mongodb.casbah.MongoClient

object MongoBeerData {

  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  val collection = mongoColl("beerList")
}


