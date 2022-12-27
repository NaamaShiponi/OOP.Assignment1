# OOP.Assignment1

### Code structure:
The code is built from two interfaces three classes and one test:

### Interfaces:
1. Sender - which describes the update sender (Observable).
2. Member - which describes receiving updates (Observer).

### Classes:
1. UndoableStringBuilder - UndoableStringBuilder class is stringBuilder class with support for the undo operation.
2. GroupAdmin - GroupAdmin implements the interface Sender, which is used to send information to the user about the changes made to the String
		The class contains the repository of the changes made in a stack data structure
		The class stores the customer database in a data structure of type ArrayList
3. ConcreteMember - ConcreteMember implements the interface Member, The users receive the information
		The class contains the copy (sallow copy) of the UndoableStringBuilder buffer of GroupAdmin 
4. Test:
    checks the edge case for the code.
	print data from JVMUtilities.

### How to run the code:
In order to run the test file:
1. clone the repository from the following git link: https://github.com/NaamaShiponi/OOP.Assignment1.git
2. run the tests
