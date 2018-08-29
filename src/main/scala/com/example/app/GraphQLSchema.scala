package com.example.app

import sangria.schema.{Field, ObjectType, _}

import scala.concurrent.ExecutionContext

object GraphQLSchema {


  val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  val BeerType: ObjectType[Unit, BeerItem] = ObjectType[Unit, BeerItem](
    "Beer",
    fields[Unit, BeerItem](
      Field("name", StringType, resolve = _.value.name),
      Field("rating", IntType, resolve = _.value.rating)
    )
  )

  val ID = Argument("id", LongType, description = "beer id")

  val QueryType = ObjectType(
    "Query",
    fields[Repository, Unit]())
//      Field("allBeers", ListType(BeerType), arguments = ID :: Nil,  resolve = ctx => ctx.ctx.getById(ctx.arg(ID))(ec)

  val SchemaDef = Schema(QueryType)

}
