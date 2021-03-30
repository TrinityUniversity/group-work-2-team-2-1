package controllers

import javax.inject._
import play.api.mvc._
import play.api.i18n._
import play.api.libs.json._

@Singleton
class ReactController @Inject() (cc: ControllerComponents) extends AbstractController(cc) {
  def load = Action { implicit request =>
    Ok(views.html.React())
  }
}