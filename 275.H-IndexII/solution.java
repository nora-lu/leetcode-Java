public class H-IndexII {
  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) { return 0; }
    int len = citations.length;
    int lo = 0, hi = len - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int val = citations[mid];
      if (val == len - mid) { return val; }
      else if (val < len - mid) { lo = mid + 1; }
      else { hi = mid - 1; }
    }
    return len - lo;
  }
}
