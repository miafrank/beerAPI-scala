package com.example.app

import com.example.app.models.Data.mongoColl

object MongoDocument {
  mongoClient.getMongoClient
  def getCollection(mongoDbObject: String) = mongoColl("beerList")
}
