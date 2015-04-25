二分搜索的关键在于找中点(mid), 然后两头保持一个 low 和一个 high两个标记.

if (A[mid] == target) return mid;
else if (A[mid] < target) low = mid + 1;
else high = mid - 1; // A[mid] > target.
