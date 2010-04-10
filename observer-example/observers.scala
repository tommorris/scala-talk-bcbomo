class Person {
  def shout(text: String) { println(text) }
}

class Dog {
  def shout(text: String) { println(text) }
}

class ShoutyMonitor[T <: {def shout(text: String): Unit}] {
  var monitored: Option[T] = None
  
  def monitor(monitored: T) {
    this.monitored = Some[T](monitored)
  }
  
  def shout(text: String) {
    this.monitored.get.shout(text)
    println("LOG: " + text + " by a " + this.monitored.get.getClass.getName)
  }
}

/* Runtime: */
var sm = new ShoutyMonitor
sm.monitor(new Dog)
sm.shout("Hello")