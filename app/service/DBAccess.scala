package service

import javax.inject._
import play.api.db._

@Singleton
class DBAccess @Inject()(db: Database) {
}
