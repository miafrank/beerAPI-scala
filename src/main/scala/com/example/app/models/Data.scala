package com.example.app.models
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.{MongoDBObject, TypeImports}
import com.mongodb.util.JSON
import org.bson.types.ObjectId
import sangria.execution.deferred.HasId


object Data {

  case class Beer(
                   name: Option[String],
                   rating: Option[Int]
                 )

  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  private val collection = mongoColl("beerList")


    def getAllJsonItems(mongoDocumentName: String)= {JSON.serialize(mongoColl(s"$mongoDocumentName"))}

    def getById(id: ObjectId)  = collection.find(MongoDBObject("_id"
      -> new ObjectId(id.toHexString))).next()

    def createNewItem[T](item: Beer) = {
      val document = MongoDBObject(
        "name" -> item.name,
        "rating" -> item.rating
      )
      collection.insert(document)
    }

    def deleteItemById(id: ObjectId): Option[TypeImports.DBObject] =
      collection.findAndRemove(MongoDBObject("_id" -> new ObjectId(id.toHexString)))

  def updateItemByObjectId[T](item: Beer, id: ObjectId) = {
    val builder = collection.initializeOrderedBulkOperation

      builder
      .find(MongoDBObject("_id" -> new ObjectId(id.toHexString)))
      .updateOne($set("name" -> item.name, "rating" -> item.rating))

      builder.execute()
  }

}