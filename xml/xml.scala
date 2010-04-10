/* First thing is first. */

import scala.xml._

val xmlString = """
  <foo>
    <bar>
      <baz />
    </bar>
  </foo>
"""

val xmldoc = XML.loadString(xmlString)
assert(xmldoc.isInstanceOf[scala.xml.Elem])

/* Now, let us load in a bigger document. As a literal. */

/* Demo */

/* Now how about writing some XML? */

class Person {
  var firstName: Option[String] = None
  var lastName: Option[String] = None
  
  def toXml() = <Person>
	{ if (this.firstName.isDefined) <firstName>{this.firstName.get}</firstName> }
	{ if (this.lastName.isDefined) <lastName>{this.lastName.get}</lastName> }
  </Person>
}

var tom = new Person
tom.firstName = Some("Tom")
tom.lastName = Some("Morris")
println(tom.toXml.toString)
