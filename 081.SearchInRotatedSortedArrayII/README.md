when there could be duplicates in the array, the worst case is O(n).

To explain why, consider this sorted array 1111115, which is rotated to 1151111.

Assume left = 0 and mid = 3, and the target we want to search for is 5. Therefore, the condition A[left] == A[mid] holds true, which leaves us with only two possibilities:

All numbers between A[left] and A[right] are all 1's.
Different numbers (including our target) may exist between A[left] and A[right].
As we cannot determine which of the above is true, the best we can do is to move left one step to the right and repeat the process again. Therefore, we are able to construct a worst case input which runs in O(n)
