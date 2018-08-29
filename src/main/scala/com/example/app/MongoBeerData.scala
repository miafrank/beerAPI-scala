package com.example.app

import com.example.app.models.Data.mongoColl
import com.mongodb.util.JSON
import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}

import scala.concurrent.{ExecutionContext, Future}

object MongoBeerData {

//  val mongoClient = MongoClient()
//  val mongoColl = mongoClient("beerDb")
//  val collection = mongoColl("beerList")

  val mongoUri = "mongodb://localhost:27017/beerDb"
  val connection = MongoConnection.parseURI(mongoUri).map(MongoDriver().connection(_))
  val futureConnection = Future.fromTry(connection)

  def db(implicit ec: ExecutionContext): Future[DefaultDB] = futureConnection.flatMap(_.database("beerDb"))
  def collection(implicit ec: ExecutionContext) = db.map(_.collection("beerList"))

  def getAllJsonItems(mongoDocumentName: String)= {JSON.serialize(mongoColl(s"$mongoDocumentName"))}
}


