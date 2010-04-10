// Very simple:
List(
  ()=>{ println("hello world") },
  ()=>{ println("ding dong") }
).foreach(x => x())

/* Ruby equivalent:
  [lambda {puts "hello world"}, lambda {puts "ding dong"}].each {|i| i.call }
*/

// Passing it around:
def everyFiveSeconds(callback: () => Unit): Unit = {
  while(true) {
    callback()
    Thread.sleep(5 * 1000)
  }
}

// Runtime:
everyFiveSeconds( () => { println("hello world") } )