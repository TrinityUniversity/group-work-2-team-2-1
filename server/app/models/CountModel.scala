package models

object CountModel {
    private var ourTicker:Int = 0
  
    def add():Unit = synchronized {
      ourTicker += 1
    }

    def getValue(): Int = synchronized {
      val ret = ourTicker
      ret
    }
}
