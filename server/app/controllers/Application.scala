package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import models.CountModel

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.Counting())
  }

  def addNumber = Action {
    CountModel.add()
    Ok(CountModel.getValue().toString)
  }
}
