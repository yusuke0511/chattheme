package controllers

import javax.inject._
import play.api.mvc._
import service.ChatTheme
import scala.math._

@Singleton
class ChatThemeMainController @Inject()(theme:ChatTheme, cc: ControllerComponents) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    val count = theme.getCount.getOrElse("count", 0)
    val themeNo = floor(random * count.asInstanceOf[Long]).toLong + 1

    Redirect(controllers.routes.ChatThemeMainController.display(themeNo))
  }

  def display(themeNo:Long) = Action {
    implicit request: Request[AnyContent] =>
      val t = theme.getTheme(themeNo)
      val text = t(0).getOrElse("theme", "")
      Ok(views.html.chatThemeMain(text.toString))
  }
}
