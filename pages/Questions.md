>[Home](Home.md)

# Questions

Status : IN_PROGRESS 

- [Questions](#questions)
    - [1 Object equality \& Hashcode](#1-object-equality--hashcode)

### 1 Object equality & Hashcode



What is a hashcode?

Answer: 

A hashcode is a number that is derived from an object.

A hashcode is a number that is used to determine the bucket in which an object is stored in a hash table. The hashcode is calculated by calling the hashcode method on an object. The hashcode method is inherited from the Object class.

What is the link between the equals method and the hashcode method?

Answer: The equals method is used to compare two objects for equality. The hashcode method is used to determine the hashcode of an object. The hashcode is used to determine the bucket in which the object is stored in a hash table. If two objects are equal, they must have the same hashcode. If two objects have the same hashcode, they are not necessarily equal.


```java


>[Home](HOME.md)
