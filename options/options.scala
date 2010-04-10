/* Options.

  In lotsa OOP languages, you do stuff like this:
  
  class Person
    attr_accessor :first_name, :last_name
    
    def initialize()
      @first_name = nil
      @last_name = nil
    end
    
    def some_method
      unless @first_name.nil?
        return @first_name
      else
        return ""
      end
    end
  end
  
  All that nil? checking. Or, worse, having to catch NullPointerExceptions.
  
  In the Ruby example, you need to check the damn type too. I mean, what if 
  some 'tard has poked an integer into the first_name property? You then need 
  to do a kind_of? call. And then you get flamed on the Ruby mailing lists 
  because you are a 'tard and you don't know about duck typing and should 
  really be using responds_to?
  
  I seem to spend half my time when writing Rails apps to do just this.
  There is a better way! Options!
  
  Scala has Options. Haskell calls them Maybe monads. They are awesome */
  
var foo: String = Nil
/* Fails. As it should. Nil is not a fucking string.

    <console>:4: error: type mismatch;
     found   : Nil.type (with underlying type object Nil)
     required: String
           var foo: String = Nil
           
*/

var foo: Option[String] = None

/* Option[T] has two subclasses: Some[T] and None. */

var foo: Option[String] = Some("string")

/* Okay, how do I use this Some object?

Simple. */

var foo: Option[String] = Some("string")

foo.get

/* But what if there is nothing there? Surely, it'll just say that there isn't 
a 'get' method on the None type?

Very perceptive. But you also have getOrElse. */

foo.getOrElse("default")

var foo: Option[String] = None

foo.getOrElse("default")

/* See? Pretty awesome, no?

It is a type-safe Null. You can also match. */

foo match {
  case None => None
  case Some(x) => println(x)
}

/* And you can be a bit less specific about the type, too. */

var bar: Option[Any] = Some[String]("hello world")

bar match {
  case Some(x: Int) => println((x * 2).asInstanceOf[String])
  case Some(x: String) => println(x)
  case None => None
  case _ => None
}

/* In practice, though... */

class Person {
  var firstName: Option[String] = None
  var lastName: Option[String] = None
  var age: Option[Int] = None
}

var tom = new Person
tom.firstName = Some("Tom")
tom.lastName = Some("Morris")
tom.age = Some(25)