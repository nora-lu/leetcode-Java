/* Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo". */

public String simplifyPath(String path) {
  Deque<String> stack = new LinkedList<String>();
  Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
  for (String dir : path.split("/")) {
    if (!skip.contains(dir)) { stack.push(dir); }
    else if (dir.equals("..") && !stack.isEmpty()) { stack.pop(); }
  }
  String ret = "";
  for (String dir : stack) { ret = "/" + dir + ret; }
  return ret.isEmpty() ? "/" : ret;
}
