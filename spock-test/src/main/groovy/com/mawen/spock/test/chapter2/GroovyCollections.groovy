package com.mawen.spock.test.chapter2

// Creating a map in Java
def wordCounts = new HashMap<>()
wordCounts.put("Hello", 1)
wordCounts.put("Java", 2)
wordCounts.put("World", 3)

// Creating a map in Groovy
Map<String, Integer> wordCounts2 = ["Hello":1, "Groovy":1, "World": 2]

// Creating a map with objects
Employee person1 = new Employee(firstName: "Alice", lastName: "Olson", age: 30);
Employee person2 = new Employee(firstName: "Jones", lastName: "Corwin", age: 45);

Address address1 = new Address(street: "Marley", number: 25)
Address address2 = new Address(street: "Barnam", number: 7)

Map<Employee, Address> staffAddresses = new HashMap<>()
staffAddresses.put(person1, address1)
staffAddresses.put(person2, address2)

Map<Employee, Address> staffAddresses2 = [(person1):address1, (person2): address2]
assert staffAddresses[person2].street == "Barnam"

// List
List<String> races = Arrays.asList("Drazi", "Minbari", "Humans");
List<String> races2 = ["Drazi", "Minbari", "Humans"]
assert races == races2

// Array
String[] racesArray = ["Drazi", "Minbari", "Humans"]

assert racesArray[0] == "Drazi"
assert racesArray[1] == "Minbari"
assert racesArray[2] == "Humans"

def humanShips = ["Condor", "Explorer"]
assert humanShips.get(0) == "Condor"
assert humanShips[0] == "Condor"

humanShips.add("Hyperion")
humanShips << "Nova" << "Olympus"
assert humanShips[3] == "Nova"
assert humanShips[4] == "Olympus"
humanShips[3] = "Omega"
assert humanShips[3] == "Omega"

// Using an non-existing index
humanShips[8] = "Warlock"
assert humanShips[8] == "Warlock"
assert humanShips[7] == null

// Accessing maps
Map<String, String> personRoles = [:]
personRoles.put("Suzan Ivanova", "Lt, Commander")
personRoles["Stephen Franklin"] = "Doctor"

assert personRoles.get("Suzan Ivanova") == "Lt, Commander"
assert personRoles.get("Stephen Franklin") == "Doctor"

personRoles["Suzan Invanova"]="Commander"
assert personRoles["Suzan Invanova"] == "Commander"