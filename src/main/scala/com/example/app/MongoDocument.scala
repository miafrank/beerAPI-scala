package com.example.app

import com.example.app.models.Data.mongoColl

object MongoDocument {
  MongoClient.getMongoClient
  def getCollection(mongoDbObject: String) = mongoColl("beerList")
}
