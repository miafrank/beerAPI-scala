package com.example.app

import com.mongodb.casbah.MongoClient
import com.mongodb.util.JSON
import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}

import scala.concurrent.{ExecutionContext, Future}

class MongoBeerData extends Repository {


  val mongoUri = "mongodb://localhost:27017/beerDb"
  val connection = MongoConnection.parseURI(mongoUri).map(MongoDriver().connection(_))
  val futureConnection = Future.fromTry(connection)

  val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  val collection2 = mongoColl("beerList")

  def db(implicit ec: ExecutionContext): Future[DefaultDB] = futureConnection.flatMap(_.database("beerDb"))
  def collection(implicit ec: ExecutionContext) = db.map(_.collection("beerList"))



  def getAllJsonItems(mongoDocumentName: String) = {
    JSON.serialize(collection(ec))
  }

//  def getById(collect: ObjectId) : Future[ObjectId] = {
//    collect.toHexString
//  }


//   collection2.find(collect)(implicitly)
//      .find(collect)
//      .one[BSONDocument]
    //collection
//  .flatMap
//    .find(document("_id"
//      -> new ObjectId(id.toHexString))).next()
//
//  def createNewItem[T](item: Beer)(implicit ec: ExecutionContext) = {
//    val document = MongoDBObject(
//      "name" -> item.name,
//      "rating" -> item.rating
//    )
//    collection.flatMap.insert(document)
//  }
//
//  def deleteItemById(id: ObjectId)(implicit ec: ExecutionContext): Option[TypeImports.DBObject] =
//    collection.findAndRemove(MongoDBObject("_id" -> new ObjectId(id.toHexString)))
//
//  def updateItemByObjectId[T](item: Beer, id: ObjectId)(implicit ec: ExecutionContext) = {
//    val builder = collection.initializeOrderedBulkOperation
//
//    builder
//      .find(MongoDBObject("_id" -> new ObjectId(id.toHexString)))
//      .updateOne($set("name" -> item.name, "rating" -> item.rating))
//
//    builder.execute()
//  }
}


