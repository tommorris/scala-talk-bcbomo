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