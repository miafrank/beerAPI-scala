package com.example.app

import com.example.app.{MongoCollection => mongoColl}

object MongoDocument {
  mongoClient.getMongoClient
  def getCollection(mongoDbObject: String) = mongoColl("beerList")
}
