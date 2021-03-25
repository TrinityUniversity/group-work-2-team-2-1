package actors

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorRef

class CountingActor(out: ActorRef, manager:ActorRef) extends Actor {
  private var counter = 0

  import CountingActor._
  def receive = {
    case s: Int => CountManager.SendMessage(s)
    case SendMessage(s) => out ! msg
    case m => println("Unhandled message in ChatActor: " + m)
  }
}

object CountingActor {
  def props(out: ActorRef) = Props(new ChatActor(out))

  case class SendMessage(msg: String)
}