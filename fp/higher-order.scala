/* Exists! 
  
  If you use a procedural language, you eventually find yourself writing the 
  same for loops over and over. It is quite boring. For instance, in 
  Proto-Algol:
  
  $a = array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  bool $a_contains_eight = false;
  for ($i = 0; $i < sizeof($a); $i++) {
    if($a[$i] == 8) {
      $a_contains_eight = true;
      break;
    }
  }
  do_something_clever_with($a_contains_eight);
  
  In Scala, you get a nice higher-order function called exists:
  
  List
    exists  (p : (A) => Boolean) : Boolean
      Tests the existence in this list of an element
      that satisfies the predicate p.
      
  What does this mean?
  
  exists is a method on List, and it takes as an argument a single-argument 
  predicate function and returns a Boolean - that is, true or false. */
  
List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).exists(_ == 8)
// => True