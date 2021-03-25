package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import models.CountModel
import play.api.libs.json._
import akka.actor.Actor
import play.api.libs.streams.ActorFlow
import akka.actor.ActorSystem
import akka.stream.Materializer
//import actors.countActor
import akka.actor.Props
//import actors.countManager

@Singleton
class Application @Inject()(cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {

  val manager = system.actorOf(Props(countManager), "Manager")

  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef {
      countActor.props(out, manager)
    }
  }

  def index = Action {
    Ok(views.html.Counting())
  }

  def addNumber = Action {
    CountModel.add()
    Ok(CountModel.getValue().toString)
  }


}
