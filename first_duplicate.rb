require 'set'
puts "***** First Duplicate *****"

inArr = [1,2,3,3,2,1,1,5]

outSet = Set.new()

inArr.each { |item|
    if outSet.include?(item) 
        print "First duplicate! and the number is ==> #{item}"
        break
    else 
      outSet.add(item) 
    #   print "First Unique element!  and the number is ==> #{item} "
    #   break
    end
}
