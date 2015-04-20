#1 keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the left of the same character last found (lastPos+1). Note that the two pointers can only move forward.

The variable "i" is used to indicate the index of first character of this substring. If the repeated character's index is less than i itself, which means the repeated character in the hash map is no longer available this time

#2 DP Solution https://leetcode.com/discuss/13336/shortest-o-n-dp-solution-with-explanations
