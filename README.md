# MakeChangeProject

The MakeChangeProject works by taking in an input from the user for the price of an item and the amount of money used to pay for the item. Both of these values are stored as floating variables: objectPrice and moneyUsed. I decided to use floating variables as opposed to doubles because I wanted practice with different data types and casting between data types. 

The program then runs through a 3 step if else statement to determing if the money used was too little, the perfect ammount, or too much.

If the amount of money used was too little an error message 
(using system.err) is printed saying that not enough money was given to cover the purchase

If the amount is the perfect amount than a message comes up saying that you paid with exact change. 

if neither of those cases are true the program calculates how much change is due back. it does this by calculating the change due, storing it as a floating variable: changeAMT, which equals the moneyUsed - objectPrice + a correction of 0.00001. 

This correction is to make up for the small amount of data lost from floating and double variables. Without this correction, the amount of change is typically off by a small amount, usually off by one penny or nickel if one would be given. 

The program then prints out the total change owed and calculates the amount of each denomination used. It does this by running a for loop eight times (one for each amount, $20, $10, $5, $1, $0.25, $0.10, $ 0.05, $0.01).

In the  for loop a method denType(i) is called that uses the argument 'i' that the for loop uses to run a switch that outputs the dollar amount correlating with the number of loops ran through. it returns this number to main. 

An if statement is then used to determine if the changeAmt is greater than or equal to this denomination, if it is the int value numberUsed is set equal to changeAmt / denomination. the changeAMT is then edited to the remainder (changeAMT % denomination). 

Then the program prints the numberUsed and a string from a method billType(i), which works similarly to denType(i), but instead of returning an int value it returns a String saying the cash value (ex: twenty dollar bill or quarter). 

An if statement is ran to see if the numberUsed > 1 or if i == 7, which checks if their is more than one penny used, printing "ies" to go on the end of "penn". this is for multiple pennies.
If only i == 7 (ie num used == 1) than it only prints "y" to add on to "penn". tis is for a singular penny.
If number Used > 1 (but it is not on  i == 7) than it simply prints "s", to make the  number of bills/coins plural

The for loop then moves on to a sigular if statement that checks if the changeAmt > 0.01, if it is a comma is inserted into the output. 

The program than loops back around. This gives the for loop the output of "numberUsed billType (s), ". So if you are owed a $10.51, it will print:
 "You are owed: 1 ten dollar bill, 2 quarters, and 1 penny"

 Once the loop is exited, the program prints an exit message, exits the initial if statements, and closes the scanner









