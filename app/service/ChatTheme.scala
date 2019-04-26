package service

import javax.inject._
import play.api.db._
import anorm._
import anorm.SqlParser._

@Singleton
class ChatTheme @Inject()(db: Database) {

  val parser = {
    long("id") ~
      str("theme_type") ~
      str("theme")
  }

  val mapper = parser.map {
    case id ~ theme_type ~ theme => Map("id" -> id, "theme_type" -> theme_type, "theme" -> theme)
  }

  val parser2 = {
    long("count")
  }

  val mapper2 = parser2.map{case count => Map("count" -> count)}

  def getCount: Map[String, Any] = {
    db.withConnection {
      implicit c => SQL("SELECT count(*) as count FROM theme").as(mapper2.*).apply(0)
    }
  }

  def getTheme: List[Map[String, Any]] = {
    db.withConnection { implicit c =>
      SQL("SELECT * FROM theme ORDER BY id desc")
        .as(mapper.*)
    }
  }

  def getTheme(id: Long): List[Map[String, Any]] = {
    db.withConnection { implicit c =>
      SQL("SELECT * FROM theme WHERE id = {id} ORDER BY id desc").on('id -> id)
        .as(mapper.*)
    }
  }
}
