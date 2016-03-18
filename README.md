Naming
------
* package names generally follow x.y.z
* class names shouldn't have underscores
* variable names shouldn't have underscores
* Don't use the word "Implementation" in a class name. Just call it what it is.
* The CashDonation object already contains the value of the check number, but then you pass in the checkNumber to the validation method. Instead, use the value that it already contains.
* Try reading your expressions as sentences to see if they make sense, so "if cash donation has valid check number" ... rather than "if cash donation validate check number check number"

Exception Handling
------------------
* when the file fails to read, you should exit the program, otherwise it will continue trying to read the nonexistant file and you'll get a NullPointerException.


Style
-----
* avoid negative conditions in a boolean statement for clarity, i.e. rather than

    if (!x) y else z

  use

    if (x) z else y

Minimal Moving Parts
--------------------
* the cashDonationList variable is not used, so remove it.
* the javadoc comments "@param args the..." doesn't add any clarity to the program, so remove it.
* inputArray is initialized to be a String array of size 100, but then inside the loop it is overwritten, so no need to initialize it that way. Just use a variable local to the loop.
