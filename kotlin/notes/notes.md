## Kotlin Notes:

### Print:

```
print("this is kotlin")
println("new line")
```

### Variables:

**val** is like **final** in Java

**var** in mutable.

```
val r: Int
var y: Int
var = 5
```

```
val lang="Kotlin"
val welcome = "This is $lang"
```

### Data Types:

- Int
- String
- Double
- Float
- Short
- Byte
- Char
- Boolean

### Functions

**fun** *name*(arg1:argDataType, argN...): returnDataType {}

```
fun getLen(str: String): Int {
    return str.length
}

fun minusOne(x: Int) : Int = x -1

fun welcome(){
    println("hi")
}
```

Functions can also not return a value

### High Order Functions:

*A function which takes another function as an argument or returns a function. Wild*

```
val getLen = fun(str: String) Int{
    return str.length
}
var lengths = strings.map(getLen)
```

### Extension Functions:

Add functions to classes (even if the class is a built-in, external, no source code...). Wild.

```
fun cleanNum(i: Int): Int {
    return i / 10
}
fun Int.cleanNum()
val clean50 = 50.squared()
```

### NULL

```
val t: String? = null
val l = t?.length

```

### Ternary:

```
val e = if(x > 6) "7 or more" else "6 or less"
```

### Logic Operators:

```
val a = true
val b = false
```

- and
- or
- xor

```
val a = true
val b = false
println(a and b)
println(a or b)
println(a xor b)

>false
>true
>true
```

### For Loop:

```
for (i in listOf(1,3,5)){
println(i)
}

val items = listOf(1,3,5)
for (i in items.indices){
    println("$index - ${items[i]}")
}
for ((index, i) in items.withIndex()){
     println("$index - ${items[i]}")
}
for (i in 1 until 30){
    println(i)
}
//or
for (i in 1 until 30)println(i)

```

### While Loop:


```
val items = listOf(1,3,5)
var index = 0
while (index < items.size) {
    println("item at $index is ${items[index]}")
    index++
}
```

### When loop:

```
val x = 5
val xResult = when (x) {
  0, 11 -> "0 or 11"
  in 1..10 -> "from 1 to 10"
  !in 12..14 -> "not from 12 to 14"
  2 -> "is 2"
  else ->"otherwise" 
}

fun isFive(five: Int) = five == 5 

val y = 5
val yResult = when {
  isFive(y) -> "is 5" //x in isFive() not in when() 
  else -> "not 5"
}

```

### Arrays/Lists/Collections:

```
val list = listOf(4,5,90)
val map = mapOf(50 to "Fifty", 100 to "Hundred", 150 to "Hundred and Fifty")
var c = 0
for ((key, value) in map){
    println("KEY: $key\nValue: $value\n${list[c]}")
    c++
}
```

Filtering:

```
val t = list.filter  { it < 10 }
//t is an array
t.forEach{
    println(it)
}

```
### It:

"it" is the iterator.

```
val list = listOf(4,5,90)
list.forEach {
    println(it) //wild.
}
```

### Groups


```
val list = listOf(4,5,35,54,60,87,90,103)

val groups = list.groupBy {
                if (it and 1 == 0) "even" else "odd"
}
for ((key, value) in groups){
    println(key)
    for (i in value){println(i)}
}
```

### stdlib:

**Scoping functions**

```
val object = Class()
object.function(2,5)
//even better:

val object = Class().apply{
function(2,5)
...
}
```

**Repeat**

```
repeat(10) {
        println(it+5)
}
```

### Custom Data Types:


```
data class Phone(val name: String, val OEM: String, var MP: Int, var mAh: Int)

val (name, oem, mp, mah) = Phone("Phone1", "Phone Enterprises",16,3500)
println("$name,$oem,$mp,$mah")
```

### Classes:


```
//defining a class
class Phone(var name: String, var OEM: String = "PE"){
    fun minusOne(i:Int): Int = i-1
}
val p1 = Phone("Phone1")
print(p1.minusOne(44))
```

### Import:

```
import lib
```


