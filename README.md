# A*
Algorithem A* on 7 characters.
The next game is a rectangle consisting of 7 squares, three of which are white (W), three of them black (B) and one square is empty. The initial situation is described in the painting and the goal is to move all the black squares to the right of the white squares where the location of the empty square is insignificant.
The permitted steps are:
• Switching between a painted square and an empty square next to it - the step cost is 1.
• Switch between a painted square and an empty square provided that it is one square square or two square feet away - the cost of a step is 1 or 2.


W W W 0 B B B


The following heuristics are evaluated - the number of white squares to the left of one or more black squares.
