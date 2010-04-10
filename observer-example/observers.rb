class Person
  def shout(text)
    puts text.to_s
  end
end

class Dog
  def shout(text)
    puts text.to_s
  end
end

class ShoutyMonitor
  def initialize
    @monitored = nil
  end
  
  def monitor(monitored)
    @monitored = monitored if monitored.responds_to?(:shout)
  end
  
  def shout(text)
    if @monitored.responds_to?(:shout)
      @monitored.shout(text.to_s) 
      println("LOG: " + text.to_s + " by a " + @monitored.class.to_s)
    end
  end
end

# Runtime:
sm = ShoutyMonitor.new
sm.monitor(Dog.new)
sm.shout("Hello")