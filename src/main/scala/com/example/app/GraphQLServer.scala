package com.example.app

import com.mongodb.casbah.MongoClient

object GraphQLServer {
  val mongoClient = MongoClient()
  val mongoColl = mongoClient("beerDb")
  private val collection = mongoColl("beerList")

//  def executeGraphQLQuery(query: Document, operation: Option[String], vars: JsObject)(implicit ec: ExecutionContext) =
//    Executor.execute(
//    GraphQLSchema.SchemaDef,
//    query,
//    operationName = operation,
//    variables = vars,
//  ).map(_)
//    .recover {
//      case error: QueryAnalysisError => BadRequest -> error.resolveError
//      case error: ErrorWithResolver => InternalServerError -> error.resolveError
//    }


//  def endpoint(requestJSON: JsValue)(implicit ec: ExecutionContext) = {
//    val JsObject(fields) = requestJSON
//    val JsString(query) = fields("query")
//
//    QueryParser.parse(query) match {
//      case Success(queryAst) =>
//
//        val operation = fields.get("operationName") collect {
//          case JsString(op) => op
//        }
//
//        val variables = fields.get("variables") match {
//          case Some(obj: JsObject) => obj
//          case _ => JsObject.empty
//        }
//
//        complete(executeGraphQLQuery(queryAst, operation, variables))
//      case Failure(err) =>
//        complete(BadRequest, JsObject("error" -> JsString(err.getMessage)))
//    }
//  }
}
