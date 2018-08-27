package com.example.app
import com.mongodb.casbah.MongoClient

object mongoClient {

  def getMongoClient = MongoClient()
}
