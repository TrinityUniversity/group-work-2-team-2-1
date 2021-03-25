import akka.actor.Actor
import akka.actor.ActorRef

class CountManager extends Actor {
  val countActor = context.actorOf(Props(CountActor), "CountActor")

  import CountManager._
  def receive = {
    case NewChatter(chatter) => chatters ::= chatter
    case Message(msg) => for (c <- chatters) c ! ChatActor.SendMessage(msg)
    case m => println("Unhandled message in ChatManager: " + m)
  }
}

object CountManager {
  case class Message(msg: String)
}